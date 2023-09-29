package com.FlyAway.daoImpl;

import com.FlyAway.dao.BookingDao;
import com.FlyAway.entities.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.FlyAway.config.HibConfig;

public class BookingDaoImpl implements BookingDao {
    private SessionFactory sessionFactory;

    public BookingDaoImpl() {
        sessionFactory = HibConfig.getSessionFactory();
    }

    @Override
    public Booking getBookingById(int bookingId) {
        Session session = sessionFactory.openSession();
        Booking booking = session.get(Booking.class, bookingId);
        session.close();
        return booking;
    }

    @Override
    public void saveBooking(Booking booking) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteBooking(Booking booking) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
