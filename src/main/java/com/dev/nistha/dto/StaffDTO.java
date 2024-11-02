package com.dev.nistha.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class StaffDTO {

    private String firstName;
    private String lastName;
    private String position;
    private BigDecimal salary;
    private String dateOfBirth;
    private String phone;
    private String email;

}
