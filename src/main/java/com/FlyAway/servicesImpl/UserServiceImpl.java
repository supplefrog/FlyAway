package com.FlyAway.servicesImpl;

import com.FlyAway.dao.UserDao;
import com.FlyAway.daoImpl.UserDaoImpl;
import com.FlyAway.entities.User;
import com.FlyAway.models.LoginModel;
import com.FlyAway.models.UserModel;
import com.FlyAway.services.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(UserModel userModel) {
        User user = convertToUserEntity(userModel);
        userDao.saveUser(user);
    }

    @Override
    public User getUser(LoginModel loginModel) {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();
        return userDao.getUser(username, password);
    }

    
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    private User convertToUserEntity(UserModel userModel) {
        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        return user;
    }
}
