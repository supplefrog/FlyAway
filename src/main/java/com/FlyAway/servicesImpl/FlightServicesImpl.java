package com.FlyAway.servicesImpl;

import com.FlyAway.dao.FlightDao;
import com.FlyAway.entities.Flight;
import com.FlyAway.models.FlightModel;
import com.FlyAway.services.FlightServices;

import java.util.ArrayList;
import java.util.List;

public class FlightServicesImpl implements FlightServices {
    private FlightDao flightDao;

    public FlightServicesImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public void addFlight(FlightModel flightModel) {
        Flight flight = convertToFlightEntity(flightModel);
        flightDao.saveFlight(flight);
    }

    @Override
    public FlightModel getFlightById(int flightId) {
        Flight flight = flightDao.getFlightById(flightId);
        return convertToFlightModel(flight);
    }

    @Override
    public void updateFlight(FlightModel flightModel) {
        Flight flight = convertToFlightEntity(flightModel);
        flightDao.updateFlight(flight);
    }

    @Override
    public void deleteFlight(int flightId) {
        flightDao.deleteFlight(flightId);
    }

    @Override
    public List<FlightModel> getAllFlights() {
        List<Flight> flights = flightDao.getAllFlights();
        return convertToFlightModelList(flights);
    }

    private Flight convertToFlightEntity(FlightModel flightModel) {
        Flight flight = new Flight();
        flight.setFlightId(flightModel.getFlightId());
        flight.setFlightNumber(flightModel.getFlightNumber());
        flight.setFlightSource(flightModel.getSource());
        flight.setFlightDestination(flightModel.getDestination());
        // Set other properties of the Flight entity as needed
        return flight;
    }

    private FlightModel convertToFlightModel(Flight flight) {
        FlightModel flightModel = new FlightModel();
        flightModel.setFlightId(flight.getFlightId());
        flightModel.setFlightNumber(flight.getFlightNumber());
        flightModel.setSource(flight.getFlightSource());
        flightModel.setDestination(flight.getFlightDestination());
        // Set other properties of the FlightModel as needed
        return flightModel;
    }

    private List<FlightModel> convertToFlightModelList(List<Flight> flights) {
        List<FlightModel> flightModels = new ArrayList<>();

        for (Flight flight : flights) {
            FlightModel flightModel = convertToFlightModel(flight);
            flightModels.add(flightModel);
        }

        return flightModels;
    }

    @Override
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }
}
