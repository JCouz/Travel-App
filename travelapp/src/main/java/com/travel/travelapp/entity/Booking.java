package com.travel.travelapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Booking {
	

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookingid;
private String name;
private String time;
private String pickup;
private String destination;
private double fare;

public Booking() {
	
}

public Booking(int bookingid, String name, String time, String pickup, String destination, double fare) {
	super();
	this.bookingid = bookingid;
	this.name = name;
	this.time = time;
	this.pickup = pickup;
	this.destination = destination;
	this.fare = fare;
}

public int getBookingid() {
	return bookingid;
}
public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getPickup() {
	return pickup;
}
public void setPickup(String pickup) {
	this.pickup = pickup;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public double getFare() {
	return fare;
}
public void setFare(double fare) {
	this.fare = fare;
}
@Override
public String toString() {
	return "Booking [bookingid=" + bookingid + ", name=" + name + ", time=" + time + ", pickup=" + pickup
			+ ", destination=" + destination + ", fare=" + fare + "]";
}

}
