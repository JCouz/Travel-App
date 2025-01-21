package com.travel.travelappfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.travel.travelappfrontend.model.Booking;

@Controller
public class BookingController {

	@Autowired
	private RestTemplate template;

	String backendUrl = "http://localhost:9090/api/bookings";

	@GetMapping("/bookinglist")
	public String getAllBookings(Model model) {
		ResponseEntity<List<Booking>> response = template.exchange(backendUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Booking>>() {
				});
		List<Booking> bookings = response.getBody();
		model.addAttribute("bookings", bookings);
		 double total = 0;
		for(Booking b : bookings) {
			total = total + (b.getFare());
		}
		model.addAttribute("total", total);
		return "bookinglist";
	}

	@GetMapping("/add-booking")
	public String addBookingForm(Model model) {
		model.addAttribute("bookings", new Booking());
		return "makebooking";
	}

	@PostMapping("/add-booking")
	public String addNewBooking(@ModelAttribute Booking booking) {
		booking.setFare(0.0);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Booking> requestEntity = new HttpEntity<>(booking, headers);

		ResponseEntity<Booking> response = template.exchange(backendUrl, HttpMethod.POST, requestEntity, Booking.class);

		return "redirect:/bookinglist";
	}
}