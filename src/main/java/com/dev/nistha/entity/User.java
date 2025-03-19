package com.dev.nistha.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    private String email;
    private String password;
    @Column(unique = true, columnDefinition = "varchar(15)", nullable = false)
    private String phoneNumber;
    private String address;

}