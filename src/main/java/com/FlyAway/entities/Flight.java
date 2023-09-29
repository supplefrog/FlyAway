package com.FlyAway.entities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight {
    @Id
    private int flightId;
    private String airlineName;
    private int availableSeat;
    private String flightSource;
    private String flightDestination;
    private int ticketPrice;
    private String flightNumber; // New property for flight number
    private LocalTime arrivalTime;
    private LocalTime departureTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToMany(mappedBy = "flights")
    private Set<Booking> bookings = new HashSet<>();

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getFlightSource() {
        return flightSource;
    }

    public void setFlightSource(String flightSource) {
        this.flightSource = flightSource;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public String getSource() {
        return flightSource;
    }

    public void setSource(String source) {
        this.flightSource = source;
    }

    public String getDestination() {
        return flightDestination;
    }

    public void setDestination(String destination) {
        this.flightDestination = destination;
    }


    // Helper methods
    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.getFlights().add(this);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.getFlights().remove(this);
    }

    public int getBookingCount() {
        return bookings.size();
    }
}
