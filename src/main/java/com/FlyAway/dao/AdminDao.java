package com.FlyAway.dao;

import com.FlyAway.entities.Admin;
import org.hibernate.SessionFactory;

public interface AdminDao {
    Admin getAdminById(int adminId);
    Admin getAdminByEmail(String email);
    Admin getAdmin(String adminName, String password); // Modified method name
    Admin getAdminByUsername(String adminName); // Modified method name
    void saveAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(Admin admin);
    void setSessionFactory(SessionFactory sessionFactory);
}
