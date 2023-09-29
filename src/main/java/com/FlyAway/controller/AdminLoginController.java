package com.FlyAway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FlyAway.entities.Admin;
import com.FlyAway.models.AdminLoginModel;
import com.FlyAway.services.AdminServices;
import com.FlyAway.servicesImpl.AdminServicesImpl;

@WebServlet("/admin-login")
public class AdminLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminServices adminService = new AdminServicesImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve adminName and password from the request
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");

        // Create an AdminLoginModel object
        AdminLoginModel loginModel = new AdminLoginModel();
        loginModel.setAdminName(adminName);
        loginModel.setPassword(password);

        // Call the getAdmin method of the AdminService with the AdminLoginModel
        Admin admin = adminService.getAdmin(loginModel);

        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);

            // Forward the request to the admin home page
            RequestDispatcher rd = request.getRequestDispatcher("admin-home.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("admin-login.jsp");
            request.setAttribute("error", "Admin Name/Password is invalid");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect GET requests to the login page
        response.sendRedirect("admin-login.jsp");
    }
}
