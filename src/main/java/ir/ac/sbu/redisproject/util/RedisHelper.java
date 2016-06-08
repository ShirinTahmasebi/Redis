package ir.ac.sbu.redisproject.util;

import redis.clients.jedis.JedisPool;

public class RedisHelper {

    public static JedisPool initialRedisPool() {
        JedisPool pool = new JedisPool(Tag.REDIS_HOST, Tag.REDIS_PORT);
        return pool;
    }

}
