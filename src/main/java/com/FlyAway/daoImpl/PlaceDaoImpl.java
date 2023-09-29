package com.FlyAway.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.FlyAway.dao.PlaceDao;
import com.FlyAway.entities.Place;
import com.FlyAway.config.HibConfig;

public class PlaceDaoImpl implements PlaceDao {
    private SessionFactory sessionFactory;

    public PlaceDaoImpl() {
        sessionFactory = HibConfig.getSessionFactory();
    }

    @Override
    public Place getPlaceByPinCode(int pinCode) {
        Session session = sessionFactory.openSession();
        Place place = session.get(Place.class, pinCode);
        session.close();
        return place;
    }

    @Override
    public void savePlace(Place place) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(place);
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
    public void updatePlace(Place place) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(place);
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
    public void deletePlace(Place place) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(place);
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
