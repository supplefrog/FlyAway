package com.FlyAway.daoImpl;

import com.FlyAway.dao.AirlineDao;
import com.FlyAway.entities.Airline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.FlyAway.config.HibConfig;

public class AirlineDaoImpl implements AirlineDao {
    private SessionFactory sessionFactory;

    public AirlineDaoImpl() {
        sessionFactory = HibConfig.getSessionFactory();
    }

    @Override
    public Airline getAirlineById(int airlineId) {
        Session session = sessionFactory.openSession();
        Airline airline = session.get(Airline.class, airlineId);
        session.close();
        return airline;
    }

    @Override
    public void saveAirline(Airline airline) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(airline);
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
    public void updateAirline(Airline airline) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(airline);
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
    public void deleteAirline(Airline airline) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(airline);
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
