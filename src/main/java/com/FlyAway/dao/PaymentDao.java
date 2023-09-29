package com.FlyAway.dao;

import com.FlyAway.entities.Payment;

public interface PaymentDao {
    Payment getPaymentById(int paymentId);
    void savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(Payment payment);
}
