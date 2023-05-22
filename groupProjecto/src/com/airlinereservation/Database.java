package com.airlinereservation;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Customer> customers;
    private List<Admin> admins;
    private List<Flight> flights;
    private List<Booking> bookings;
    private List<Cancellation> cancellations;

    public Database() {
        customers = new ArrayList<>();
        admins = new ArrayList<>();
        flights = new ArrayList<>();
        bookings = new ArrayList<>();
        cancellations = new ArrayList<>();

        // Sample Data
        Customer customer1 = new Customer("John Doe", "john@example.com", "password1");
        Customer customer2 = new Customer("Jane Smith", "jane@example.com", "password2");
        customers.add(customer1);
        customers.add(customer2);

        Admin admin1 = new Admin("Admin1", "admin1@example.com", "adminpassword");
        Admin admin2 = new Admin("Admin2", "admin2@example.com", "adminpassword");
        admins.add(admin1);
        admins.add(admin2);

        Flight flight1 = new Flight("FL001", "ABC Airlines", "New York", "London", "2023-06-01", "10:00 AM", 5000.0);
        Flight flight2 = new Flight("FL002", "XYZ Airways", "Los Angeles", "Paris", "2023-06-02", "12:00 PM", 3000.897);
        flights.add(flight1);
        flights.add(flight2);

        Booking booking1 = new Booking(customer1, flight1);
        Booking booking2 = new Booking(customer2, flight2);
        bookings.add(booking1);
        bookings.add(booking2);
    }

    // Customer methods
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Admin methods
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void removeAdmin(Admin admin) {
        admins.remove(admin);
    }

    public List<Admin> getAllAdmins() {
        return admins;
    }

    // Flight methods
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public List<Flight> getAllFlights() {
        return flights;
    }

    // Booking methods
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    // Cancellation methods
    public void addCancellation(Cancellation cancellation) {
        cancellations.add(cancellation);
    }

    public Flight getFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public void deleteFlight(Flight flight) {
        flights.remove(flight);
    }

	public static Database getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}