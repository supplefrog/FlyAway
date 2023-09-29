package com.FlyAway.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.FlyAway.dao.PaymentDao;
import com.FlyAway.entities.Payment;

public class PaymentDaoImpl implements PaymentDao {
    private SessionFactory sessionFactory;
    
    public PaymentDaoImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        Session session = sessionFactory.openSession();
        Payment payment = session.get(Payment.class, paymentId);
        session.close();
        return payment;
    }

    @Override
    public void savePayment(Payment payment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePayment(Payment payment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
