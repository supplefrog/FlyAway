package com.FlyAway.daoImpl;

import com.FlyAway.dao.FlightDao;
import com.FlyAway.entities.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.FlyAway.config.HibConfig;

import java.util.List;

public class FlightDaoImpl implements FlightDao {
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public FlightDaoImpl() {
        sessionFactory = HibConfig.getSessionFactory();
    }

    @Override
    public Flight getFlightById(int flightId) {
        Session session = sessionFactory.openSession();
        Flight flight = session.get(Flight.class, flightId);
        session.close();
        return flight;
    }

    @Override
    public void saveFlight(Flight flight) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(flight);
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
    public void updateFlight(Flight flight) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(flight);
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
    public void deleteFlight(int flightId) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Flight flight = session.get(Flight.class, flightId);
            if (flight != null) {
                session.delete(flight);
            }
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
    public List<Flight> getAllFlights() {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            return session.createQuery("FROM Flight", Flight.class)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Flight> getFlightsBySource(String source) {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            return session.createQuery("FROM Flight WHERE flightSource = :source", Flight.class)
                    .setParameter("source", source)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Flight> getFlightsByDestination(String destination) {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            return session.createQuery("FROM Flight WHERE flightDestination = :destination", Flight.class)
                    .setParameter("destination", destination)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Flight> getFlightsBySourceAndDestination(String source, String destination) {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            return session.createQuery("FROM Flight WHERE flightSource = :source AND flightDestination = :destination", Flight.class)
                    .setParameter("source", source)
                    .setParameter("destination", destination)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}