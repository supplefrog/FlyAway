package com.FlyAway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.FlyAway.dao.AdminDao;
import com.FlyAway.daoImpl.AdminDaoImpl;
import com.FlyAway.entities.Admin;
import com.FlyAway.config.HibConfig;

@WebServlet("/AdminRegister")
public class AdminRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao adminDao;

    @Override
    public void init() throws ServletException {
        // Initialize AdminDaoImpl with the session factory
        SessionFactory sessionFactory = HibConfig.getSessionFactory();
        adminDao = new AdminDaoImpl();
        adminDao.setSessionFactory(sessionFactory);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve admin registration form data
        String adminName = request.getParameter("adminName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate form data (e.g., check for empty fields, password strength, etc.)
        boolean isValid = validateForm(adminName, email, password);

        if (isValid) {
            // Create a new Admin object and set the form data
            Admin admin = new Admin();
            admin.setAdminName(adminName);
            admin.setEmail(email);
            admin.setPassword(password);

            // Save the admin to the database using the AdminDao
            adminDao.saveAdmin(admin);

            // Forward to a success page after successful registration
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminRegisterSucc.jsp");
            dispatcher.forward(request, response);
        } else {
            // If form data is invalid, forward back to the registration page with an error message
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-register.jsp?error=1");
            dispatcher.forward(request, response);
        }
    }

    private boolean validateForm(String adminName, String email, String password) {
        // Perform form validation logic here
        // You can add your own validation rules based on your requirements
        // For example, check for empty fields, validate email format, password strength, etc.

        // In this example, we are checking if all form fields are non-empty
        return !adminName.isEmpty()
                && !email.isEmpty()
                && !password.isEmpty();
    }
}
