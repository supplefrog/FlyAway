package com.FlyAway.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.dao.AirlineDao;
import com.FlyAway.daoImpl.AirlineDaoImpl;
import com.FlyAway.models.AirlineModel;

import com.FlyAway.services.AirlineServices;
import com.FlyAway.servicesImpl.AirlineServicesImpl;

@WebServlet("/addAirline")
public class AirlineController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AirlineServices airlineService;

    @Override
    public void init() throws ServletException {
        // Initialize AirlineService with the AirlineDao
        AirlineDao airlineDao = new AirlineDaoImpl();
        airlineService = new AirlineServicesImpl(airlineDao);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve data from the request
        String airlineName = request.getParameter("airlineName");
        String airlineHeadquarters = request.getParameter("airlineHeadquarters");
        String websites = request.getParameter("websites");
        String code = request.getParameter("code");
        String country = request.getParameter("country");

        // Create a new AirlineModel object
        AirlineModel airlineModel = new AirlineModel();
        airlineModel.setAirlineName(airlineName);
        airlineModel.setAirlineHeadquarters(airlineHeadquarters);
        airlineModel.setWebsites(websites);
        airlineModel.setCode(code);
        airlineModel.setCountry(country);

        // Call the createAirline method of the airlineService
        airlineService.createAirline(airlineModel);

        // Set the airline model as an attribute in the request
        request.setAttribute("airline", airlineModel);

        // Forward the request to the success page
        request.getRequestDispatcher("addAirlineSuccess.jsp").forward(request, response);
    }
}
