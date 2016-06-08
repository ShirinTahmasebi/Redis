package ir.ac.sbu.redisproject.dao;

import ir.ac.sbu.redisproject.dao.model.User;
import java.util.Map;

public interface UserDao {

    public void insertUser(User user);

    public Map<String, String> getAllUsers();
}
