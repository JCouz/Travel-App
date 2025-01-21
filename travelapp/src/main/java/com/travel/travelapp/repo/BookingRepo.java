package com.travel.travelapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.travelapp.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
