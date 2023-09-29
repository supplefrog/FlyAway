package com.FlyAway.daoImpl;

import com.FlyAway.dao.AdminDao;
import com.FlyAway.entities.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.FlyAway.config.HibConfig;

public class AdminDaoImpl implements AdminDao {
    private SessionFactory sessionFactory;

    public AdminDaoImpl() {
        sessionFactory = HibConfig.getSessionFactory();
    }

    @Override
    public Admin getAdminById(int adminId) {
        Session session = sessionFactory.openSession();
        Admin admin = session.get(Admin.class, adminId);
        session.close();
        return admin;
    }

    @Override
    public Admin getAdminByEmail(String email) {
        Session session = sessionFactory.openSession();
        Admin admin = null;
        try {
            admin = session.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return admin;
    }

    @Override
    public Admin getAdmin(String adminName, String password) {
        Session session = sessionFactory.openSession();
        Admin admin = null;
        try {
            admin = session.createQuery("SELECT a FROM Admin a WHERE a.adminName = :adminName AND a.password = :password", Admin.class)
                    .setParameter("adminName", adminName)
                    .setParameter("password", password)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return admin;
    }

    @Override
    public Admin getAdminByUsername(String adminName) {
        Session session = sessionFactory.openSession();
        Admin admin = null;
        try {
            admin = session.createQuery("SELECT a FROM Admin a WHERE a.adminName = :adminName", Admin.class)
                    .setParameter("adminName", adminName)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return admin;
    }

    @Override
    public void saveAdmin(Admin admin) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(admin);
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
    public void updateAdmin(Admin admin) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(admin);
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
    public void deleteAdmin(Admin admin) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(admin);
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
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
