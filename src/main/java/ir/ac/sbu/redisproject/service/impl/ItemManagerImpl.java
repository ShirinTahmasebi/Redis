package ir.ac.sbu.redisproject.service.impl;

import ir.ac.sbu.redisproject.dao.ItemDao;
import ir.ac.sbu.redisproject.dao.impl.ItemDaoImpl;
import ir.ac.sbu.redisproject.dao.model.Item;
import ir.ac.sbu.redisproject.service.ItemManager;
import java.util.List;
import java.util.Map;

public class ItemManagerImpl implements ItemManager {

    @Override
    public void insertItem(Item item) {
        ItemDao itemDao = new ItemDaoImpl();
        itemDao.insertItem(item);
    }

    @Override
    public void insertItem(Item item, Double score) {
        ItemDao itemDao = new ItemDaoImpl();
        itemDao.insertItem(item, score);
    }

    @Override
    public Item getItem(String itemId) {
        ItemDao itemDao = new ItemDaoImpl();
        return itemDao.getItem(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        ItemDao itemDao = new ItemDaoImpl();
        return itemDao.getAllItems();
    }

    @Override
    public String getItemScore(String itemId) {
        ItemDao itemDao = new ItemDaoImpl();
        return itemDao.getItemScore(itemId);
    }

    @Override
    public Map<Item, Double> getAllItemsWithScores() {
        ItemDao itemDao = new ItemDaoImpl();
        return itemDao.getAllItemsWithScores();
    }

}
