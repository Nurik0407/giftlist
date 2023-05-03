package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import com.example.giftlistb8.entities.Mailing;
import com.example.giftlistb8.services.MailingServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailingServiceImpl implements MailingServices {


    @Override
    public List<MailingResponse> getAllMailingList() {
       /* String sql="SELECT m.image, m.title, m.created_at FROM AllMailingResponse";
        List<AllMailingResponse>getMailingList=jdbcTemplate.query(sql,(resultSet, i)->{
            return new
        })*/

    }

    @Override
    public SimpleResponse saveMailing(MailingRequest request) {
        Mailing mailing=new Mailing(request);
    }

    @Override
    public SimpleResponse deleteMailing(Long id) {
        return null;
    }
}
