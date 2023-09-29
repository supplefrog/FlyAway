package com.FlyAway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.FlyAway.dao.UserDao;
import com.FlyAway.daoImpl.UserDaoImpl;
import com.FlyAway.entities.User;
import com.FlyAway.config.HibConfig;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        // Initialize UserDaoImpl with the session factory
        SessionFactory sessionFactory = HibConfig.getSessionFactory();
        userDao = new UserDaoImpl();
        userDao.setSessionFactory(sessionFactory);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user registration form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Validate form data (e.g., check for empty fields, password match, etc.)
        boolean isValid = validateForm(username, email, password, confirmPassword);

        if (isValid) {
            // Create a new User object and set the form data
            User user = new User();
            user.setUserName(username);
            user.setEmail(email);
            user.setPassword(password);

            // Save the user to the database using the UserDao
            userDao.saveUser(user);

            // Forward to a success page after successful registration
            RequestDispatcher dispatcher = request.getRequestDispatcher("registration-success.jsp");
            dispatcher.forward(request, response);
        } else {
            // If form data is invalid, forward back to the registration page with an error message
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp?error=1");
            dispatcher.forward(request, response);
        }
    }

    private boolean validateForm(String username, String email, String password, String confirmPassword) {
        // Perform form validation logic here
        // You can add your own validation rules based on your requirements
        // For example, check for empty fields, validate email format, compare passwords, etc.

        // In this example, we are checking if all form fields are non-empty
        return !username.isEmpty()
                && !email.isEmpty()
                && !password.isEmpty()
                && !confirmPassword.isEmpty();
    }
}
