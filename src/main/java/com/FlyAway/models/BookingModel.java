package com.FlyAway.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BookingModel {
    private int bookingId;
    private LocalDate bookingDate;
    private int passengerCount;
    private int totalPrice;
    private UserModel user;
    private AirlineModel airline;
    private Set<FlightModel> flights = new HashSet<>();
    private Set<PaymentModel> payments = new HashSet<>();

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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public AirlineModel getAirline() {
        return airline;
    }

    public void setAirline(AirlineModel airline) {
        this.airline = airline;
    }

    public Set<FlightModel> getFlights() {
        return flights;
    }

    public void setFlights(Set<FlightModel> flights) {
        this.flights = flights;
    }

    public Set<PaymentModel> getPayments() {
        return payments;
    }

    public void setPayments(Set<PaymentModel> payments) {
        this.payments = payments;
    }
}
