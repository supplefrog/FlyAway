package com.FlyAway.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private LocalDate bookingDate;
	private int passengerCount;
	private int totalPrice;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Flight> flights = new HashSet<>();

	@OneToMany
	private Set<Payment> payments = new HashSet<>();

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	// Helper methods
	public void addFlight(Flight flight) {
		flights.add(flight);
		flight.getBookings().add(this);
	}

	public void removeFlight(Flight flight) {
		flights.remove(flight);
		flight.getBookings().remove(this);
	}

	public int getFlightCount() {
		return flights.size();
	}

	public void addPayment(Payment payment) {
		payments.add(payment);
		payment.setBooking(this);
	}

	public void removePayment(Payment payment) {
		payments.remove(payment);
		payment.setBooking(null);
	}

	public int getPaymentAmount() {
		int totalAmount = 0;
		for (Payment payment : payments) {
			totalAmount += payment.getPaymentAmount();
		}
		return totalAmount;
	}
}
