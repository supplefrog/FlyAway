package com.FlyAway.controllerSucc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addPlaceSuccess")
public class AddPlaceControllerSuccess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Display a success message
        response.getWriter().println("<h2>Place added successfully!</h2>");
        response.getWriter().println("<p>Thank you for adding the place.</p>");
    }
}
