package com.example.giftlistb8.dto.complaint.response;

import com.example.giftlistb8.dto.charity.response.CharityResponseWithComplaint;
import com.example.giftlistb8.dto.wish.response.WishResponseWithComplaint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComplaintResponse {
    List<CharityResponseWithComplaint> charityResponseWithComplaints;
    List<WishResponseWithComplaint> wishResponseWithComplaints;
}
