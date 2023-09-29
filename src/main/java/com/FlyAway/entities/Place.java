package com.FlyAway.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Place {
    @Id
    private int pinCode; // Renamed placeId to pinCode
    private String placeName;
    private String country; // Added the country attribute
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "Place_Flight",
        joinColumns = @JoinColumn(name = "place_id"),
        inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private Set<Flight> flights = new HashSet<>();
    
    public int getPinCode() {
        return pinCode;
    }
    
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    
    public String getPlaceName() {
        return placeName;
    }
    
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public Set<Flight> getFlights() {
        return flights;
    }
    
    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
    
    // Helper methods
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
    
    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }
    
    public int getFlightCount() {
        return flights.size();
    }
}
