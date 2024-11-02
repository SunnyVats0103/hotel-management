package com.dev.nistha.mapper;

import com.dev.nistha.dto.HotelDTO;
import com.dev.nistha.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public HotelDTO hotelToHotelDTO(Hotel hotel) {
        return HotelDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .room(hotel.getRoom())
                .build();
    }

    public Hotel hotelDTOToHotel(HotelDTO hotelDTO) {
        return Hotel.builder()
                .id(hotelDTO.getId())
                .name(hotelDTO.getName())
                .room(hotelDTO.getRoom())
                .build();
    }

}
