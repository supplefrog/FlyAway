package com.FlyAway.dao;

import com.FlyAway.entities.User;
import org.hibernate.SessionFactory;

public interface UserDao {
    User getUserById(int userId);
    User getUserByEmail(String email);
    User getUserByUsername(String username); 
    User getUser(String username, String password);

    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    void insert(User user);
    void setSessionFactory(SessionFactory sessionFactory);
}
