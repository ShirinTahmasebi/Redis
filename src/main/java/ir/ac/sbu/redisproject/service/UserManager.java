package ir.ac.sbu.redisproject.service;

import ir.ac.sbu.redisproject.dao.model.User;
import java.util.Map;

public interface UserManager {

    public void insertUser(User user);

    public Map<String, String> getAllUsers();

}
