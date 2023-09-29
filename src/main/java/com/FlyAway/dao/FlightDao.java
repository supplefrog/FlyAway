package com.FlyAway.dao;

import java.util.List;

import com.FlyAway.entities.Flight;
import org.hibernate.SessionFactory;

public interface FlightDao {
    void setSessionFactory(SessionFactory sessionFactory);
    void saveFlight(Flight flight);
    Flight getFlightById(int flightId);
    List<Flight> getAllFlights();
    void updateFlight(Flight flight);
    void deleteFlight(int flightId);
    List<Flight> getFlightsBySource(String source);
    List<Flight> getFlightsByDestination(String destination);
    List<Flight> getFlightsBySourceAndDestination(String source, String destination);

}
