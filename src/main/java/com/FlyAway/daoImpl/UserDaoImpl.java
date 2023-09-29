package com.FlyAway.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.FlyAway.config.HibConfig;
import com.FlyAway.dao.UserDao;
import com.FlyAway.entities.User;

public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
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
    public User getUser(String username, String password) {
    	SessionFactory factory = HibConfig.getSessionFactory();
        Session session = factory.openSession();
        try {
            
            return session.createQuery("FROM User WHERE username = :username AND password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
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
    public User getUserByUsername(String username) {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
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
    public User getUserById(int id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            return session.get(User.class, id);
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
    public void updateUser(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
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
    public void insert(User user) {
        // Implementation to insert a new user into the database
        // ...
    }

    @Override
    public void deleteUser(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(user);
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
    public User getUserByEmail(String email) {
        Session session = null;

        try {
            session = sessionFactory.openSession();

            return session.createQuery("FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
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
