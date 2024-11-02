package com.dev.nistha.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    @CreationTimestamp
    private Date hireDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;

}
