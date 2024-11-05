package com.dev.nistha.dto;

import com.dev.nistha.entity.Room;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class HotelDTO {

    private Long id;
    private String name;
    private List<Room> room;

}
