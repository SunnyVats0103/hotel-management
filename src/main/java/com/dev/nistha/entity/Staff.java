package com.dev.nistha.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Staff {

    @Id
    @GeneratedValue
    private Long id;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String firstName;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String lastName;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String position;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal salary;
    @Column(columnDefinition = "date", nullable = false)
    private Date dateOfBirth;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "varchar(255)")
    private String email;
    @CreatedDate
    private Date hireDate;
    @ManyToOne
    private Hotel hotel;

}
