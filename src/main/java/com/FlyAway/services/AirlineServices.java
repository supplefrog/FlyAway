package com.FlyAway.services;

import com.FlyAway.entities.Airline;
import com.FlyAway.models.AirlineModel;

public interface AirlineServices {
    Airline getAirlineById(int airlineId);
    void createAirline(AirlineModel airlineModel);
    void updateAirline(AirlineModel airlineModel);
    void deleteAirline(int airlineId);
}
