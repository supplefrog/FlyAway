package com.FlyAway.models;

public class FlightModel {
    private int flightId;
    private String flightNumber;
    private String source;
    private String destination;
    private AirlineModel airline; // Assuming there is an AirlineModel associated with the flight

    public FlightModel() {
        
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public AirlineModel getAirline() {
        return airline;
    }

    public void setAirline(AirlineModel airline) {
        this.airline = airline;
    }
}
