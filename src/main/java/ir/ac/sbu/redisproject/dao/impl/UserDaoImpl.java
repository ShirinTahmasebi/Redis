package ir.ac.sbu.redisproject.dao.impl;

import ir.ac.sbu.redisproject.dao.UserDao;
import ir.ac.sbu.redisproject.dao.model.User;
import ir.ac.sbu.redisproject.util.RedisHelper;
import ir.ac.sbu.redisproject.util.Tag;
import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class UserDaoImpl implements UserDao {

    // The jedis connection pool..
    private static JedisPool pool = null;

    @Override
    public void insertUser(User user) {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        Map<String, String> map = new HashMap<>();
        map.put(user.getUserName(), user.getPassword());
        jedis.hmset(Tag.REDIS_USER_KEY, map);
    }

    @Override
    public Map<String, String> getAllUsers() {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        return jedis.hgetAll(Tag.REDIS_USER_KEY);
    }

    @Override
    public String getUser(User user) {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        return jedis.hget(Tag.REDIS_USER_KEY, user.getUserName());
    }

}
