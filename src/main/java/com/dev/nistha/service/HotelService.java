package com.dev.nistha.service;

import com.dev.nistha.dto.HotelDTO;
import com.dev.nistha.errorhandler.NoHotelFoundException;

import java.util.List;

public interface HotelService {
    HotelDTO getHotelById(Long id) throws NoHotelFoundException;
    List<HotelDTO> getHotels();
    HotelDTO createHotel(HotelDTO hotelDTO);
    HotelDTO updateHotel(HotelDTO hotelDTO) throws NoHotelFoundException;
    void deleteHotel(Long id);

}
