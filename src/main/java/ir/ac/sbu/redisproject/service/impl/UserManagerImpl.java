package ir.ac.sbu.redisproject.service.impl;

import ir.ac.sbu.redisproject.dao.UserDao;
import ir.ac.sbu.redisproject.dao.impl.UserDaoImpl;
import ir.ac.sbu.redisproject.dao.model.User;
import ir.ac.sbu.redisproject.service.UserManager;
import java.util.Map;

public class UserManagerImpl implements UserManager {

    @Override
    public void insertUser(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.insertUser(user);
    }

    @Override
    public Map<String, String> getAllUsers() {
        UserDao userDao = new UserDaoImpl();
        return userDao.getAllUsers();
    }

}
