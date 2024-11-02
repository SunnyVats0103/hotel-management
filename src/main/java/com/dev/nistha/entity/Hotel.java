package com.dev.nistha.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Hotel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "hotel_name")
    private String name;
    @OneToMany(mappedBy = "hotel")
    private List<Room> room;

}
