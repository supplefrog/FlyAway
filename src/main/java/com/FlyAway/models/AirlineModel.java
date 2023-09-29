package com.FlyAway.models;

import java.util.HashSet;
import java.util.Set;

public class AirlineModel {
    private int airlineId;
    private String airlineName;
    private String airlineHeadquarters;
    private String websites;
    private String code;
    private String country;
    private Set<FlightModel> flights = new HashSet<>();

    public AirlineModel() {
        
    }

    public int getAirlineId() {
        return airlineId;
    }

    public AirlineModel(int airlineId, String airlineName, String airlineHeadquarters, String websites, String code,
			String country, Set<FlightModel> flights) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.airlineHeadquarters = airlineHeadquarters;
		this.websites = websites;
		this.code = code;
		this.country = country;
		this.flights = flights;
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

    public Set<FlightModel> getFlights() {
        return flights;
    }

    public void setFlights(Set<FlightModel> flights) {
        this.flights = flights;
    }
}
