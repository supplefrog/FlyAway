package com.FlyAway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FlyAway.dao.UserDao;
import com.FlyAway.daoImpl.UserDaoImpl;
import com.FlyAway.entities.User;
import com.FlyAway.models.LoginModel;
import com.FlyAway.services.UserService;
import com.FlyAway.servicesImpl.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a LoginModel object
        LoginModel loginModel = new LoginModel();
        loginModel.setUsername(username);
        loginModel.setPassword(password);

        // Call the getUser method of the UserService with the LoginModel
        User user = userService.getUser(loginModel);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            UserDao userDao = new UserDaoImpl(); // Create an instance of UserDao
            

            // Pass the retrieved user object to the view
            request.setAttribute("user", user);

            // Forward the request to the home.jsp page
            

            
            // Get the user by username using the UserDao
            User userByUsername = userDao.getUserByUsername(username);
            request.setAttribute("user", userByUsername);

            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            request.setAttribute("error", "Username/Password is invalid");
            rd.forward(request, response);
        }
    }
}
