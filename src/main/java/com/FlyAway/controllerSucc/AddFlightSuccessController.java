package com.FlyAway.controllerSucc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addFlightSuccess")
public class AddFlightSuccessController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Display a success message
        response.getWriter().println("<h2>Flight added successfully!</h2>");
        response.getWriter().println("<p>Thank you for adding the flight.</p>");
    }
}
