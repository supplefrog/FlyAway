package com.FlyAway.servicesImpl;

import com.FlyAway.config.HibConfig;
import com.FlyAway.dao.AdminDao;
import com.FlyAway.daoImpl.AdminDaoImpl;
import com.FlyAway.entities.Admin;
import com.FlyAway.models.AdminLoginModel;
import com.FlyAway.models.AdminModel;
import com.FlyAway.services.AdminServices;

public class AdminServicesImpl implements AdminServices {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public void registerAdmin(AdminModel adminModel) {
        Admin admin = convertToAdminEntity(adminModel);
        adminDao.setSessionFactory(HibConfig.getSessionFactory());
        adminDao.saveAdmin(admin);
    }


    @Override
    public Admin getAdmin(AdminLoginModel loginModel) {
        String adminName = loginModel.getAdminName();
        String password = loginModel.getPassword();
        return adminDao.getAdmin(adminName, password);
    }


    @Override
    public Admin getAdminByadminName(String username) {
        return adminDao.getAdminByUsername(username);
    }

    private Admin convertToAdminEntity(AdminModel adminModel) {
        Admin admin = new Admin();
        admin.setAdminName(adminModel.getAdminName());
        admin.setEmail(adminModel.getEmail());
        admin.setPassword(adminModel.getPassword());
        return admin;
    }
}
