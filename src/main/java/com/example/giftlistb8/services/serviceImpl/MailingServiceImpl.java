package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.dto.mailing.response.AllMailingResponse;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import com.example.giftlistb8.entities.Mailing;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.MailingRepository;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.MailingServices;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class MailingServiceImpl implements MailingServices {
    private final MailingRepository repository;
    private final JavaMailSender javaMailSender;
    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public SimpleResponse sendMailWithAttachment(
            MailingRequest request) throws MessagingException {
        String sql = """
                 select u.email from users u where u.subscribe_mailing is true;
                """;
        List<String> usersEmail = jdbcTemplate.queryForList(sql, String.class);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        for (String email : usersEmail) {
            mimeMessageHelper.setFrom("amanbekovnurbek04@gmail.com");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject(request.getTitle());
            String htmlMessage = "<html><body>" + request.getDescription() + "<br><br><img src=" + request.getImage() + "></body></html>";
            mimeMessageHelper.setText(htmlMessage, true);
            javaMailSender.send(mimeMessage);
        }
        Mailing mailing = new Mailing();
        mailing.setTitle(request.getTitle());
        mailing.setDescription(request.getDescription());
        mailing.setImage(request.getImage());
        mailing.setCreatedAt(LocalDate.now());
        repository.save(mailing);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("mailing successfully sent and saved to database ")
                .build();
    }

    @Override
    public Optional<MailingResponse> getMailingById(Long id) {
        String query = "SELECT m.id, m.image, m.title, m.description, m.created_at " +
                "FROM mailings m WHERE m.id = ?";
        MailingResponse mailingResponse = jdbcTemplate.queryForObject(query, new Object[]{id},
                (rs, rowNum) -> new MailingResponse(
                        rs.getLong("id"),
                        rs.getString("image"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("created_at").toLocalDate()
                ));
        return Optional.ofNullable(mailingResponse);
    }

    @Override
    public List<AllMailingResponse> getAllMailingList() {
        String query = "SELECT m.id, m.image, m.title, m.created_at " +
                "FROM mailings m ORDER BY m.id DESC";
        return jdbcTemplate.query(query, (rs, rowNum) -> new AllMailingResponse(
                rs.getLong("id"),
                rs.getString("image"),
                rs.getString("title"),
                rs.getDate("created_at").toLocalDate()
        ));
    }

    @Override
    public SimpleResponse delete(Long id) {
        Mailing mailing = repository.findById(id).orElseThrow(()
                -> new NotFoundException("Not found"));
        repository.delete(mailing);
        return SimpleResponse.builder()
                .message("DELETE MAILING")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public SimpleResponse subscribeToMailing(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new NotFoundException("Пользователь с почтой %s не найден.".formatted(email)));

        User userInToken = jwtService.getUserInToken();
        if (!userInToken.getEmail().equals(user.getEmail())) {
            throw new BadRequestException("Вы можете подписаться только на свою почту.");
        }

        if (user.isSubscribeMailing()) {
            throw new BadRequestException("Вы уже подписаны на рассылку.");
        }

        user.setSubscribeMailing(true);
        userRepository.save(user);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Вы успешно подписались на рассылки.")
                .build();
    }
}
