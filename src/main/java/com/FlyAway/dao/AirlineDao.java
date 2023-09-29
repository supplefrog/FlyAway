package com.FlyAway.dao;

import com.FlyAway.entities.Airline;

public interface AirlineDao {
    Airline getAirlineById(int airlineId);
    void saveAirline(Airline airline);
    void updateAirline(Airline airline);
    void deleteAirline(Airline airline);
}
