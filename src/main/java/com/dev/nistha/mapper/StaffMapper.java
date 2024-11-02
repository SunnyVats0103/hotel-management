package com.dev.nistha.mapper;

import com.dev.nistha.dto.StaffDTO;
import com.dev.nistha.entity.Staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StaffMapper {

    public static StaffDTO staffToStaffDTO(Staff staff) {
        return StaffDTO.builder()
                .firstName(staff.getFirstName())
                .lastName(staff.getLastName())
                .email(staff.getEmail())
                .phone(staff.getPhone())
                .dateOfBirth(staff.getDateOfBirth().toString())
                .position(staff.getPosition())
                .salary(staff.getSalary())
                .build();
    }

    public static Staff staffDTOToStaff(StaffDTO staffDTO) throws ParseException {
        return Staff.builder()
                .firstName(staffDTO.getFirstName())
                .lastName(staffDTO.getLastName())
                .email(staffDTO.getEmail())
                .phone(staffDTO.getPhone())
                .dateOfBirth(new SimpleDateFormat("dd-MM-yyyy")
                        .parse(staffDTO.getDateOfBirth()))
                .position(staffDTO.getPosition())
                .salary(staffDTO.getSalary())
                .build();
    }

}
