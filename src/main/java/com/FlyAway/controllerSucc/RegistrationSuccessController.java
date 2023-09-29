package com.FlyAway.controllerSucc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration-success")
public class RegistrationSuccessController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET request for the registration success page

        // You can add any logic or retrieve data related to the successful registration here

        // Forward the request to the registration success page
        request.getRequestDispatcher("registration-success.jsp").forward(request, response);
    }
}
