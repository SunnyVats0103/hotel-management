package com.dev.nistha.controller;

import com.dev.nistha.dto.ResponseDTO;
import com.dev.nistha.dto.RoomDTO;
import com.dev.nistha.errorhandler.NoRoomFoundException;
import com.dev.nistha.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<ResponseDTO> addNewRoom(@RequestBody RoomDTO roomDTO) {
        RoomDTO room = roomService.createRoom(roomDTO);

        if (room != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ResponseDTO.builder()
                            .code("201")
                            .message("Room Created")
                            .build());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDTO.builder()
                        .code("500")
                        .message("Room Creation Failed")
                        .build());
    }

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getRooms());
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long roomId) throws NoRoomFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomById(roomId));
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateRoom(@RequestBody RoomDTO roomDTO) throws NoRoomFoundException {
        RoomDTO room = roomService.updateRoom(roomDTO);
        if (room != null) {
            ResponseEntity.status(HttpStatus.OK)
                    .body(ResponseDTO.builder()
                            .code("200")
                            .message("Room Updated")
                            .build());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDTO.builder()
                        .code("500")
                        .message("Room Update Failed")
                        .build());
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<ResponseDTO> deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok()
                .body(ResponseDTO.builder()
                        .code("200")
                        .message("Room Deleted")
                        .build());
    }

}
