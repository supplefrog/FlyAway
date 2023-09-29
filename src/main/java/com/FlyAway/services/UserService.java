package com.FlyAway.services;

import com.FlyAway.entities.User;
import com.FlyAway.models.LoginModel;
import com.FlyAway.models.UserModel;

public interface UserService {
    void registerUser(UserModel userModel);
    User getUserByUsername(String username);
    User getUser(LoginModel loginModel);

}
