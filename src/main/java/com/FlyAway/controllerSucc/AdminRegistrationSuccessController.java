package com.FlyAway.controllerSucc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminRegisterSucc")
public class AdminRegistrationSuccessController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle GET request for the admin registration success page

        // You can add any logic or retrieve data related to the successful registration here

        // Forward the request to the admin registration success page
        request.getRequestDispatcher("AdminRegisterSucc.jsp").forward(request, response);
    }
}
