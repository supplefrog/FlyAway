package com.FlyAway.servicesImpl;

import com.FlyAway.dao.PlaceDao;
import com.FlyAway.entities.Place;
import com.FlyAway.models.PlaceModel;
import com.FlyAway.services.PlaceServices;

public class PlaceServicesImpl implements PlaceServices {
    private PlaceDao placeDao;

    public PlaceServicesImpl(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public void createPlace(PlaceModel placeModel) {
        Place place = new Place();
        place.setPinCode(placeModel.getPinCode()); // Updated to use pinCode
        place.setPlaceName(placeModel.getPlaceName());
        place.setCountry(placeModel.getCountry());
        // Set other place properties if needed

        placeDao.savePlace(place);
    }

    // Implement other methods of PlaceServices if needed
}
