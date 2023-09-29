package com.FlyAway.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.dao.PaymentDao;
import com.FlyAway.daoImpl.PaymentDaoImpl;
import com.FlyAway.models.PaymentModel;
import com.FlyAway.services.PaymentServices;
import com.FlyAway.servicesImpl.PaymentServicesImpl;

@WebServlet("/addPayment")
public class PaymentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PaymentServices paymentService;

    @Override
    public void init() throws ServletException {
        // Initialize PaymentService with the PaymentDao
        PaymentDao paymentDao = new PaymentDaoImpl();
        paymentService = new PaymentServicesImpl(paymentDao);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve data from the request
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        int paymentAmount = Integer.parseInt(request.getParameter("paymentAmount"));
        String paymentDateString = request.getParameter("paymentDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate paymentDate = LocalDate.parse(paymentDateString, formatter);
        String paymentMethod = request.getParameter("paymentMethod");

        // Create a new PaymentModel object
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setPaymentId(bookingId); // Assuming paymentId is the same as bookingId
        paymentModel.setPaymentAmount(paymentAmount);
        paymentModel.setPaymentDate(paymentDate);
        paymentModel.setPaymentMethod(paymentMethod);

        // Call the processPayment method of the paymentService
        paymentService.processPayment(paymentModel);

        // Set the payment model as an attribute in the request
        request.setAttribute("payment", paymentModel);

        // Forward the request to the success page
        request.getRequestDispatcher("addPaymentSuccess.jsp").forward(request, response);
    }
}
