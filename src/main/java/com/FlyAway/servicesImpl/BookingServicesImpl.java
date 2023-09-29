package com.FlyAway.servicesImpl;

import java.util.HashSet;
import java.util.Set;

import com.FlyAway.dao.BookingDao;
import com.FlyAway.entities.Booking;
import com.FlyAway.entities.Flight;
import com.FlyAway.entities.Payment;
import com.FlyAway.entities.User;
import com.FlyAway.models.BookingModel;
import com.FlyAway.models.FlightModel;
import com.FlyAway.models.PaymentModel;
import com.FlyAway.services.BookingServices;

public class BookingServicesImpl implements BookingServices {
    private BookingDao bookingDao;

    public BookingServicesImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void createBooking(BookingModel bookingModel) {
        Booking booking = new Booking();
        
        // Set the booking properties based on the bookingModel
        booking.setBookingDate(bookingModel.getBookingDate());
        booking.setPassengerCount(bookingModel.getPassengerCount());
        booking.setTotalPrice(bookingModel.getTotalPrice());
        
        // Set the user
        User user = new User();
        user.setUserName(bookingModel.getUser().getUserName());
        user.setEmail(bookingModel.getUser().getEmail());
        // Set other user properties if needed
        booking.setUser(user);
        
        // Set the flights
        Set<Flight> flights = new HashSet<>();
        for (FlightModel flightModel : bookingModel.getFlights()) {
            Flight flight = new Flight();
            flight.setFlightNumber(flightModel.getFlightNumber());
            // Set other flight properties if needed
            flights.add(flight);
        }
        booking.setFlights(flights);
        
        // Set the payments
        Set<Payment> payments = new HashSet<>();
        for (PaymentModel paymentModel : bookingModel.getPayments()) {
            Payment payment = new Payment();
            payment.setPaymentMethod(paymentModel.getPaymentMethod());
            // Set other payment properties if needed
            payments.add(payment);
        }
        booking.setPayments(payments);

        bookingDao.saveBooking(booking);
    }
}
