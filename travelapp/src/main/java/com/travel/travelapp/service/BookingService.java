package com.travel.travelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travelapp.entity.Booking;
import com.travel.travelapp.repo.BookingRepo;

@Service
public class BookingService {

	@Autowired
	private BookingRepo bookingRepo;

	public Booking createBooking(Booking booking) {
		double dummyDistance = Math.random() * 20 + 1;
		double fare = calcutelateFare(dummyDistance);
		booking.setFare(fare);

		return bookingRepo.save(booking);
	}

	public double calcutelateFare(double distance) {
		double baseFare = 5.0;
		return baseFare + distance * 2;
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
	}

}
