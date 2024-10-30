package com.dev.nistha.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    
//    Added for testing Git hub rules sets

    @GetMapping("/detail")
    public String getHotel() {
        return "Raddison Blu";
    }

}
