package com.FlyAway.dao;

import com.FlyAway.entities.Booking;

public interface BookingDao {
    Booking getBookingById(int bookingId);
    void saveBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(Booking booking);
}
