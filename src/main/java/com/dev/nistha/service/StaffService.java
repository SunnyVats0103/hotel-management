package com.dev.nistha.service;

import com.dev.nistha.dto.ResponseDTO;
import com.dev.nistha.dto.StaffDTO;
import com.dev.nistha.errorhandler.NoStaffFoundException;

import java.text.ParseException;
import java.util.List;

public interface StaffService {

    ResponseDTO createStaff(StaffDTO staffDTO) throws ParseException;
    StaffDTO getStaffById(Long id) throws NoStaffFoundException;
    List<StaffDTO> getAllStaff();
    ResponseDTO updateStaff(StaffDTO staffDTO) throws NoStaffFoundException, ParseException;
    ResponseDTO deleteStaff(Long id) throws NoStaffFoundException;

}
