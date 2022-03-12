package com.codegym.service.serviceUsermanagement;

import com.codegym.dao.usermanagement.UserManagementDAO;
import com.codegym.model.User;

import java.util.List;

public class UsermanagementService implements IUserManagementService {
    private UserManagementDAO userManagementDAO;

    public UsermanagementService(UserManagementDAO userManagementDAO) {
        this.userManagementDAO = userManagementDAO;
    }

    @Override
    public List<User> findAll() {
        return userManagementDAO.findAll();
    }

    @Override
    public User findById(int id) {
        return userManagementDAO.findById(id);
    }

    @Override
    public boolean create(User user) {
        return userManagementDAO.create(user);
    }

    @Override
    public boolean update(int id, User user) {
        return userManagementDAO.update(id,user);
    }

    @Override
    public boolean delete(int id) {
        return userManagementDAO.delete(id);
    }
}
