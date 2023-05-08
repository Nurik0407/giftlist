package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.dto.mailing.response.AllMailingResponse;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import com.example.giftlistb8.entities.Mailing;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.MailingRepository;
import com.example.giftlistb8.services.MailingServices;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class MailingServiceImpl implements MailingServices {
    @Autowired
    private MailingRepository repository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SimpleResponse sendMailWithAttachment(
            MailingRequest request) throws MessagingException {
        String sql = """
                 select u.email from user_mailing u where mailing_list is true;
                """;
        List<String> usersemail = jdbcTemplate.queryForList(sql, String.class);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        for (String email : usersemail) {
            mimeMessageHelper.setFrom("amanbekovnurbek04@gmail.com");
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject(request.getTitle());
            mimeMessageHelper.setText(request.getText());
            FileSystemResource fileSystemResource =
                    new FileSystemResource(new File(request.getImage()));
            mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()),
                    fileSystemResource);
            javaMailSender.send(mimeMessage);
        }
        Mailing mailing = new Mailing();
        mailing.setTitle(request.getTitle());
        mailing.setDescription(request.getText());
        mailing.setImage(request.getImage());
        mailing.setCreatedAt(LocalDate.now());
        repository.save(mailing);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("mailing successfully sent and saved to database ")
                .build();
    }

    @Override
    public List<AllMailingResponse> getAllMailingList() {
        return repository.getAllMailingList();
    }

    @Override
    public MailingResponse getByIdMailingList(Long id) {
        return repository.getMailingById(id).orElseThrow(() -> new NotFoundException(
                String.format("MailingList with id %s not found.", id)));
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
}
