package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.entities.UserInfo;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.UserInfoRepository;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.EmailService;
import com.example.giftlistb8.services.UserInfoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private final EmailService mailSenderService;
    private final UserRepository userRepository;
    private final TemplateEngine templateEngine;
    private final PasswordEncoder passwordEncoder;
    private final UserInfoRepository userInfoRepository;

    @Override
    public SimpleResponse updateResetPasswordToken(String email) {
        log.info("Updating reset password token for email: {}", email);
        String token = UUID.randomUUID().toString();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found!"));
        if (user.getUserInfo() == null) {
            UserInfo userInfo = new UserInfo();
            user.setUserInfo(userInfo);
            userInfo.setResetToken(token);
            userInfoRepository.save(userInfo);
        }
        UserInfo userInfo = user.getUserInfo();
        userInfo.setResetToken(token);
        userInfoRepository.save(userInfo);
        try {
            String resetPasswordLink = "http://ec2-3-120-31-83.eu-central-1.compute.amazonaws.com/api/user/reset_password?token=" + token;
            String subject = "Password Reset Request";
            Context context = new Context();
            context.setVariable("title", "Password Reset");
            context.setVariable("message", "Hello " + user.getFirstName() + "" +
                                           " Click the link below to reset your password:");
            context.setVariable("link", resetPasswordLink);
            context.setVariable("tokenTitle", "Reset Password");

            String htmlContent = templateEngine.process("reset-password-template.html", context);

            mailSenderService.sendEmail(email, subject, htmlContent);
            log.info("Password reset email sent to: {}", email);
        } catch (NotFoundException ex) {
            log.error("User not found while updating reset password token for email: {}", email);
            return SimpleResponse.builder().
                    status(HttpStatus.OK).
                    message("Please check your email inbox for password reset instructions.")
                    .build();
        }
        log.info("Reset password token updated for email: {}", email);
        return SimpleResponse.builder().
                status(HttpStatus.OK).
                message("Please check your email inbox for password reset instructions.")
                .build();
    }

    @Override
    public SimpleResponse getByResetPasswordToken(String token, String firstPassword, String secondPassword) {
        log.info("Getting user by reset password token: {}", token);
        UserInfo userInfo = userInfoRepository.findByResetPasswordToken(token);
        if (userInfo == null) {
            log.error("No user found with reset password token: {}", token);
            return SimpleResponse.builder().
                    status(HttpStatus.OK).
                    message("You've encountered some errors while trying to reset your password.")
                    .build();
        } else {
            User user = userInfo.getUser();
            updatePassword(user, firstPassword);
            log.info("User password updated with reset password token: {}", token);
        }
        return SimpleResponse.builder().
                status(HttpStatus.OK).
                message("You've successfully reset your password.")
                .build();
    }


    private void updatePassword(User user, String newPassword) {
        log.info("Updating user password for user: {}", user.getId());
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.getUserInfo().setResetToken(null);
        userRepository.save(user);
        log.info("User password updated successfully for user: {}", user.getId());
    }
}
