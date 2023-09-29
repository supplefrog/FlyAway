package com.FlyAway.servicesImpl;

import com.FlyAway.dao.AirlineDao;
import com.FlyAway.entities.Airline;
import com.FlyAway.models.AirlineModel;
import com.FlyAway.services.AirlineServices;

public class AirlineServicesImpl implements AirlineServices {
    private AirlineDao airlineDao;

    public AirlineServicesImpl(AirlineDao airlineDao) {
        this.airlineDao = airlineDao;
    }

    @Override
    public Airline getAirlineById(int airlineId) {
        return airlineDao.getAirlineById(airlineId);
    }

    @Override
    public void createAirline(AirlineModel airlineModel) {
        Airline airline = convertToAirlineEntity(airlineModel);
        airlineDao.saveAirline(airline);
    }

    @Override
    public void updateAirline(AirlineModel airlineModel) {
        Airline airline = airlineDao.getAirlineById(airlineModel.getAirlineId());
        if (airline != null) {
            // Update the properties of the airline entity based on the airlineModel
            airline.setAirlineName(airlineModel.getAirlineName());
            airline.setAirlineHeadquarters(airlineModel.getAirlineHeadquarters());
            airline.setWebsites(airlineModel.getWebsites());
            airline.setCode(airlineModel.getCode());
            airline.setCountry(airlineModel.getCountry());
            // Update any other properties as needed
            // ...

            airlineDao.updateAirline(airline);
        }
    }

    @Override
    public void deleteAirline(int airlineId) {
        Airline airline = airlineDao.getAirlineById(airlineId);
        if (airline != null) {
            airlineDao.deleteAirline(airline);
        }
    }

    private Airline convertToAirlineEntity(AirlineModel airlineModel) {
        Airline airline = new Airline();
        airline.setAirlineName(airlineModel.getAirlineName());
        airline.setAirlineHeadquarters(airlineModel.getAirlineHeadquarters());
        airline.setWebsites(airlineModel.getWebsites());
        airline.setCode(airlineModel.getCode());
        airline.setCountry(airlineModel.getCountry());
        // Set any other properties as needed
        // ...

        return airline;
    }
}
