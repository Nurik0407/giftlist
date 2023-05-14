package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.profile.request.ChangePasswordUser;
import com.example.giftlistb8.dto.profile.request.ProfileRequest;
import com.example.giftlistb8.dto.profile.request.ProfileUpdateRequest;
import com.example.giftlistb8.dto.profile.response.ProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponseGetById;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.entities.UserInfo;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SimpleResponse saveUser(ProfileRequest profileRequest) {
        UserInfo userInfo = UserInfo.builder().image(profileRequest.image()).country(profileRequest.country()).dateOfBirth(profileRequest.dateOfBirth()).phoneNumber(profileRequest.phoneNumber()).clothingSize(profileRequest.clothingSize()).shoeSize(profileRequest.shoeSize()).hobby(profileRequest.hobby()).important(profileRequest.important()).facebook(profileRequest.faceBook()).whatsApp(profileRequest.whatsApp()).instagram(profileRequest.instagram()).telegram(profileRequest.instagram()).build();

        User user = User.builder().userInfo(userInfo).firstName(profileRequest.firstName()).lastName(profileRequest.lastName()).email(profileRequest.email()).build();
        userRepository.save(user);
        return SimpleResponse.builder().status(HttpStatus.OK).message(String.format("User with %s name successfully saved", profileRequest.firstName())).build();
    }

    @Override
    public ProfileResponseGetById getById() {
        User userInToken = jwtService.getUserInToken();
        return userRepository.getByIdUser(userInToken.getId()).orElseThrow(() -> new NotFoundException(String.format("User with %s id not found", userInToken.getId())));
    }

    @Override
    public ProfileResponse getByIdDetailInformation() {
        User userInToken = jwtService.getUserInToken();
        return userRepository.getByIdUserDetail(userInToken.getId()).orElseThrow(() -> new NotFoundException(String.format("User with %s id not found", userInToken.getId())));
    }

    @Override
    public SimpleResponse changeUserPassword(ChangePasswordUser changePasswordUser) {
        User userInToken = jwtService.getUserInToken();
        User user = userRepository.getUserById(userInToken.getId()).orElseThrow(() -> new NotFoundException(String.format("User with %s id not found", userInToken.getId())));
        if (!passwordEncoder.matches(changePasswordUser.oldPassword(), user.getPassword())) {
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("Old password does not match").build();
        }


        if (!changePasswordUser.newPassword().equals(changePasswordUser.repeatPassword())) {
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("New password and repeat password do not match").build();
        }


        user.setPassword(passwordEncoder.encode(changePasswordUser.newPassword()));
        userRepository.save(user);

        return SimpleResponse.builder().status(HttpStatus.OK).message("Password updated successfully").build();

    }

    @Override
    public SimpleResponse updateUserProfile(ProfileUpdateRequest profileRequest) {
        User user = jwtService.getUserInToken();
        if (user == null) {
            return SimpleResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message(String.format("User with %s id not found", profileRequest.id()))
                    .build();
        }
        UserInfo userInfo = user.getUserInfo();
        userInfo.setImage(profileRequest.image());
        userInfo.setCountry(profileRequest.country());
        userInfo.setDateOfBirth(profileRequest.dateOfBirth());
        userInfo.setPhoneNumber(profileRequest.phoneNumber());
        userInfo.setClothingSize(profileRequest.clothingSize());
        userInfo.setShoeSize(profileRequest.shoeSize());
        userInfo.setHobby(profileRequest.hobby());
        userInfo.setImportant(profileRequest.important());
        userInfo.setFacebook(profileRequest.faceBook());
        userInfo.setWhatsApp(profileRequest.whatsApp());
        userInfo.setInstagram(profileRequest.instagram());
        userInfo.setTelegram(profileRequest.telegram());

        user.setFirstName(profileRequest.firstName());
        user.setLastName(profileRequest.lastName());
        user.setEmail(profileRequest.email());

        userRepository.save(user);
        return SimpleResponse.builder().status(HttpStatus.OK).message(String.format("User with %s id successfully update", profileRequest.id())).build();
    }

}
