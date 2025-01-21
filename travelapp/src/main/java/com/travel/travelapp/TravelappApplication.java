package com.travel.travelapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.travel.travelapp.entity.Booking;
import com.travel.travelapp.repo.BookingRepo;
import com.travel.travelapp.service.BookingService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TravelappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelappApplication.class, args);
	}

	
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private BookingService bookingService;
	
	@PostConstruct
	public void initialize() {
		if(bookingRepo.count() == 0) {
			Booking b1 = new Booking();
			b1.setName("Jason");
			b1.setPickup("Leeds");
			b1.setDestination("Manchester");
			b1.setTime("10:00AM");
			b1.setFare(bookingService.calcutelateFare(10));
				
			
			Booking b2 = new Booking();
			b2.setName("Meg");
			b2.setPickup("London");
			b2.setDestination("Surrey");
			b2.setTime("11:00 AM");
			b2.setFare(bookingService.calcutelateFare(16));
			
			Booking b3 = new Booking();
			b3.setName("Big Dave");
			b3.setPickup("Cornwall");
			b3.setDestination("Devon");
			b3.setTime("2:30 PM");
			b3.setFare(bookingService.calcutelateFare(20));
			
			bookingRepo.saveAll(Arrays.asList(b1, b2, b3));
		}
	}
	
}
