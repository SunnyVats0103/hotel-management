package com.dev.nistha.controller;

import com.dev.nistha.dto.ResponseDTO;
import com.dev.nistha.entity.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    
//    Added for testing Git hub rules sets

    @GetMapping
    public ResponseEntity<Void> getHotels() {
        return null;
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Void> getHotel(@PathVariable Long hotelId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createHotel(@RequestBody Hotel hotel) {
        return null;
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<ResponseDTO> deleteHotel(@PathVariable Long hotelId) {
        return null;
    }

}
