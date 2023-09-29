package com.FlyAway.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airlineId;
    private String airlineName;
    private String airlineHeadquarters;
    private String websites;
    private String code;
    private String country;

    @OneToMany(mappedBy = "airline")
    private Set<Flight> flights = new HashSet<>();

    public Airline() {
    }

    public Airline(String airlineName, String airlineHeadquarters, String websites, String code, String country) {
        this.airlineName = airlineName;
        this.airlineHeadquarters = airlineHeadquarters;
        this.websites = websites;
        this.code = code;
        this.country = country;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineHeadquarters() {
        return airlineHeadquarters;
    }

    public void setAirlineHeadquarters(String airlineHeadquarters) {
        this.airlineHeadquarters = airlineHeadquarters;
    }

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
