package com.FlyAway.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.dao.PlaceDao;
import com.FlyAway.daoImpl.PlaceDaoImpl;
import com.FlyAway.models.PlaceModel;
import com.FlyAway.services.PlaceServices;
import com.FlyAway.servicesImpl.PlaceServicesImpl;

@WebServlet("/addPlace")
public class PlaceController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PlaceServices placeService;

    @Override
    public void init() throws ServletException {
        // Initialize PlaceService with the PlaceDao
        PlaceDao placeDao = new PlaceDaoImpl();
        placeService = new PlaceServicesImpl(placeDao);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve data from the request
        String pinCodeStr = request.getParameter("pinCode");
        String placeName = request.getParameter("placeName");
        String country = request.getParameter("country");

        // Create a new PlaceModel object
        PlaceModel placeModel = new PlaceModel();
        placeModel.setPinCode(Integer.parseInt(pinCodeStr)); // Updated to use pinCode
        placeModel.setPlaceName(placeName);
        placeModel.setCountry(country);

        // Call the createPlace method of the placeService
        placeService.createPlace(placeModel);

        // Set the place model as an attribute in the request
        request.setAttribute("place", placeModel);

        // Forward the request to the success page
        request.getRequestDispatcher("addPlaceSuccess.jsp").forward(request, response);
    }
}
