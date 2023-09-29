package com.FlyAway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.dao.FlightDao;
import com.FlyAway.daoImpl.FlightDaoImpl;
import com.FlyAway.models.FlightModel;
import com.FlyAway.services.FlightServices;
import com.FlyAway.servicesImpl.FlightServicesImpl;


@WebServlet("/addflight")
public class FlightController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FlightServices flightServices;

    @Override
    public void init() throws ServletException {
        // Initialize FlightServices with the FlightDao
        FlightDao flightDao = new FlightDaoImpl();
        flightServices = new FlightServicesImpl(flightDao);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve data from the request
        String flightNumber = request.getParameter("flightNumber");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        // Create a new FlightModel object
        FlightModel flightModel = new FlightModel();
        flightModel.setFlightNumber(flightNumber);
        flightModel.setSource(source);
        flightModel.setDestination(destination);

        // Call the addFlight method of the flightService
        flightServices.addFlight(flightModel);

        // Set the flight model as an attribute in the request
        request.setAttribute("flight", flightModel);

        // Forward the request to the success page
        request.getRequestDispatcher("addFlightSuccess.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve all flights from the flightService
        List<FlightModel> flights = flightServices.getAllFlights();

        // Set the flights as an attribute in the request
        request.setAttribute("flights", flights);

        // Forward the request to the flights.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("flights.jsp");
        dispatcher.forward(request, response);
    }
}
