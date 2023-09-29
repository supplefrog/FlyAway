package com.FlyAway.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.dao.BookingDao;
import com.FlyAway.dao.FlightDao;
import com.FlyAway.daoImpl.BookingDaoImpl;
import com.FlyAway.daoImpl.FlightDaoImpl;
import com.FlyAway.models.BookingModel;
import com.FlyAway.models.FlightModel;
import com.FlyAway.models.UserModel;
import com.FlyAway.services.BookingServices;
import com.FlyAway.services.FlightServices;
import com.FlyAway.servicesImpl.BookingServicesImpl;
import com.FlyAway.servicesImpl.FlightServicesImpl;

@WebServlet("/addBooking")
public class BookingController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookingServices bookingService;
    private FlightServices flightService;

    @Override
    public void init() throws ServletException {
        // Initialize services with respective DAO implementations
        BookingDao bookingDao = new BookingDaoImpl();
        FlightDao flightDao = new FlightDaoImpl();

        bookingService = new BookingServicesImpl(bookingDao);
        flightService = new FlightServicesImpl(flightDao);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve data from the request
        int userId = Integer.parseInt(request.getParameter("userId"));
        String bookingDateString = request.getParameter("bookingDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate bookingDate = LocalDate.parse(bookingDateString, formatter);
        int passengerCount = Integer.parseInt(request.getParameter("passengerCount"));
        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
        String[] flightNumbers = request.getParameterValues("flightNumber");

        // Create a new UserModel object
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);

        // Create a new BookingModel object
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingDate(bookingDate);
        bookingModel.setPassengerCount(passengerCount);
        bookingModel.setTotalPrice(totalPrice);
        bookingModel.setUser(userModel);

        // Set the flights
        Set<FlightModel> flightModels = new HashSet<>();
        for (String flightNumber : flightNumbers) {
            FlightModel flightModel = new FlightModel();
            flightModel.setFlightNumber(flightNumber);
            flightModels.add(flightModel);
        }
        bookingModel.setFlights(flightModels);

        
        
        // Call the createBooking method of the bookingService
        bookingService.createBooking(bookingModel);

        // Set the booking model as an attribute in the request
        request.setAttribute("booking", bookingModel);

        // Forward the request to the success page
        request.getRequestDispatcher("addBookingSuccess.jsp").forward(request, response);
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Forward the request to the addBooking.jsp page
    request.getRequestDispatcher("addBooking.jsp").forward(request, response);
}
}
