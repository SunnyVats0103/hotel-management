package com.dev.nistha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {

//    Added for testing Git hub rules sets

    @GetMapping("/detail")
    public String getHotel() {
        return "Radisson Blu";
    }

    @GetMapping
    public List<Map<String, String>> listHotels() {
        Map<String, String> hotels = new LinkedHashMap<>();

        hotels.put("name", "Radisson Blu");

        return List.of(hotels);
    }

}
