//WISSEBO ABDULMAJID 2218587
package com.airlinereservation;

import java.time.LocalDateTime;

public class Booking {
    private String bookingNumber;
    private Customer customer;
    private Flight flight;
    private LocalDateTime bookingDateTime;
    private int numberOfPassengers;

    public Booking(String bookingNumber, Customer customer, Flight flight,
                   LocalDateTime bookingDateTime, int numberOfPassengers) {
        this.bookingNumber = bookingNumber;
        this.customer = customer;
        this.flight = flight;
        this.bookingDateTime = bookingDateTime;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Booking(Customer customer, Flight flight) {
		// TODO Auto-generated constructor stub
	}

	public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNumber='" + bookingNumber + '\'' +
                ", customer=" + customer +
                ", flight=" + flight +
                ", bookingDateTime=" + bookingDateTime +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
