package com.FlyAway.services;

import com.FlyAway.dao.FlightDao;
import com.FlyAway.models.FlightModel;
import java.util.List;

public interface FlightServices {
    void addFlight(FlightModel flightModel);
    void setFlightDao(FlightDao flightDao);
    FlightModel getFlightById(int flightId);
    void updateFlight(FlightModel flightModel);
    void deleteFlight(int flightId);
    List<FlightModel> getAllFlights(); // Add getAllFlights method
}
