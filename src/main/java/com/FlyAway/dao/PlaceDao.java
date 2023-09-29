package com.FlyAway.dao;

import com.FlyAway.entities.Place;

public interface PlaceDao {
    Place getPlaceByPinCode(int pinCode);
    void savePlace(Place place);
    void updatePlace(Place place);
    void deletePlace(Place place);
}
