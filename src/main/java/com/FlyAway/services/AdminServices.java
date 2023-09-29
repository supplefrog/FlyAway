package com.FlyAway.services;

import com.FlyAway.entities.Admin;
import com.FlyAway.models.AdminLoginModel;
import com.FlyAway.models.AdminModel;

public interface AdminServices {
    void registerAdmin(AdminModel adminModel);
    Admin getAdminByadminName(String username);
    
    Admin getAdmin(AdminLoginModel loginModel);

}
