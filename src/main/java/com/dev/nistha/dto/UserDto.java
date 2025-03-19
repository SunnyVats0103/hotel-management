package com.dev.nistha.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for {@link com.dev.nistha.entity.User}
 */
@Data
@Builder
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String firstName;
    private final String lastName;
    private transient String password;
    private final String email;
    private final String phoneNumber;
    private final String address;

    

}