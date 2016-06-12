package ir.ac.sbu.redisproject.dao.impl;

import ir.ac.sbu.redisproject.dao.ItemDao;
import ir.ac.sbu.redisproject.dao.model.Item;
import ir.ac.sbu.redisproject.util.RedisHelper;
import ir.ac.sbu.redisproject.util.Tag;
import java.util.Set;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class ItemDaoImpl implements ItemDao {

    // The jedis connection pool
    private static JedisPool pool = null;

    @Override
    public void insertItem(Item item) {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        jedis.zadd(Tag.REDIS_ITEM_KEY, 0, item.getItemId() + "");
    }

    @Override
    public Set<String> getAllItems() {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        return jedis.zrange(Tag.REDIS_ITEM_KEY, 0, -1);
    }

    @Override
    public String getItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getItemScore(String itemId) {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        if (jedis.zrank(Tag.REDIS_ITEM_KEY, itemId + "") == null) {
            return null;
        }
        return jedis.zrank(Tag.REDIS_ITEM_KEY, itemId + "").toString();
    }

}
