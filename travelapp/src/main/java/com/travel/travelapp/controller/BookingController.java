package com.travel.travelapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travelapp.entity.Booking;
import com.travel.travelapp.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> bookCab(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @GetMapping("/fare")
    public ResponseEntity<Double> getFare(@RequestParam String pickup, @RequestParam String destination) {
        double fare = bookingService.calcutelateFare(10);
        return ResponseEntity.ok(fare);
    }
    
    @GetMapping
    public ResponseEntity<List<Booking>> getBookings(){
    	return ResponseEntity.ok(bookingService.getAllBookings());
    }
}