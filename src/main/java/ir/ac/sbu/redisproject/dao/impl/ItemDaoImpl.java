package ir.ac.sbu.redisproject.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.ac.sbu.redisproject.dao.ItemDao;
import ir.ac.sbu.redisproject.dao.model.Item;
import ir.ac.sbu.redisproject.util.RedisHelper;
import ir.ac.sbu.redisproject.util.Tag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

public class ItemDaoImpl implements ItemDao {

    // The jedis connection pool
    private static JedisPool pool = null;

    @Override
    public void insertItem(Item item) {
        try {
            pool = RedisHelper.initialRedisPool();
            Jedis jedis = pool.getResource();
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(item);
            jedis.zadd(Tag.REDIS_ITEM_KEY, 0, jsonInString);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Item> getAllItems() {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        Set<String> items = jedis.zrange(Tag.REDIS_ITEM_KEY, 0, -1);
        List<Item> itemList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (String item : items) {
            Item i;
            try {
                i = objectMapper.readValue(item, Item.class);
                itemList.add(i);
            } catch (IOException ex) {
                Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return itemList;
    }

    @Override
    public Map<Item, Double> getAllItemsWithScores() {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        Set<Tuple> items = jedis.zrangeWithScores(Tag.REDIS_ITEM_KEY, 0, -1);
        Map<Item, Double> itemList = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Tuple item : items) {
            Item i;
            try {
                i = objectMapper.readValue(item.getElement(), Item.class);
                itemList.put(i, item.getScore());
            } catch (IOException ex) {
                Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, "" + item.getElement(), ex);
            }
        }
        return itemList;
    }

    @Override
    public String getItemScore(String itemId) {
        pool = RedisHelper.initialRedisPool();
        Jedis jedis = pool.getResource();
        
        Set<Tuple> items = jedis.zrangeWithScores(Tag.REDIS_ITEM_KEY, 0, -1);
        ObjectMapper objectMapper = new ObjectMapper();
        for(Tuple item : items){
            Item i;
            try{
                i = objectMapper.readValue(item.getElement(), Item.class);
                if(i.getItemId().equals(itemId)){
                    return item.getScore() + "";
                }
            }
            catch (IOException ex) {
                Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, "" + item.getElement(), ex);
            }
        }
        return null;
    }

    @Override
    public Item getItem(String itemId) {
        List<Item> items = getAllItems();
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

}
