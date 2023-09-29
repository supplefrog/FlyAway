package com.FlyAway.servicesImpl;

import com.FlyAway.dao.PaymentDao;
import com.FlyAway.entities.Payment;
import com.FlyAway.models.PaymentModel;
import com.FlyAway.services.PaymentServices;

public class PaymentServicesImpl implements PaymentServices {
    private PaymentDao paymentDao;

    public PaymentServicesImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public void processPayment(PaymentModel paymentModel) {
        Payment payment = new Payment();
        // Set the payment properties based on the paymentModel
        payment.setPaymentId(paymentModel.getPaymentId());
        payment.setPaymentAmount(paymentModel.getPaymentAmount());
        payment.setPaymentDate(paymentModel.getPaymentDate());
        payment.setPaymentMethod(paymentModel.getPaymentMethod());
        // Set other payment properties if needed

        paymentDao.savePayment(payment);
    }
}
