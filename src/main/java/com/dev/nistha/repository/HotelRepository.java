package com.dev.nistha.repository;

import com.dev.nistha.entity.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    @Query("SELECT h FROM Hotel h")
    List<Hotel> findAllHotel();

}