package com.dev.nistha.controller;

import com.dev.nistha.dto.HotelDTO;
import com.dev.nistha.dto.ResponseDTO;
import com.dev.nistha.errorhandler.NoHotelFoundException;
import com.dev.nistha.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/hotel")
public class HotelController {
private final HotelService hotelService;
        @PostMapping
        public ResponseEntity<ResponseDTO> addNewHotel(@RequestBody HotelDTO hotelDTO) {
            HotelDTO hotel = hotelService.createHotel(hotelDTO);

            if (hotel != null) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(ResponseDTO.builder()
                                .code("201")
                                .message("Hotel Created")
                                .build());
            }

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseDTO.builder()
                            .code("500")
                            .message("Hotel Creation Failed")
                            .build());
        }

        @GetMapping
        public ResponseEntity<List<HotelDTO>> getAllHotel() {
            return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotels());
        }

        @GetMapping("/{hotelId}")
        public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long hotelId) throws NoHotelFoundException {
            return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
        }


        @PutMapping
        public ResponseEntity<ResponseDTO> updateHotel(@RequestBody HotelDTO hotelDTO) throws NoHotelFoundException {
            HotelDTO hotel = hotelService.updateHotel(hotelDTO);
            if (hotel != null) {
                ResponseEntity.status(HttpStatus.OK)
                        .body(ResponseDTO.builder()
                                .code("200")
                                .message("Hotel Updated")
                                .build());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseDTO.builder()
                            .code("500")
                            .message("Hotel Update Failed")
                            .build());
        }

        @DeleteMapping("/{hotelId}")
        public ResponseEntity<ResponseDTO> deleteHotel(@PathVariable Long hotelId) {
            hotelService.deleteHotel(hotelId);
            return ResponseEntity.ok()
                    .body(ResponseDTO.builder()
                            .code("200")
                            .message("Hotel Deleted")
                            .build());
        }

    }
