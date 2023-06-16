package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.holiday.request.HolidayRequest;
import com.example.giftlistb8.dto.holiday.response.GlobalSearchHoliday;
import com.example.giftlistb8.dto.holiday.response.HolidayByIdResponse;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;

import java.util.List;

public interface HolidayService {

    List<HolidayResponse> findAll();

    SimpleResponse save(HolidayRequest request);

    SimpleResponse update(Long id, HolidayRequest request);

    SimpleResponse delete(Long id);

    HolidayByIdResponse getById(Long id);

    List<GlobalSearchHoliday> globalSearch(String keyWord);
}
