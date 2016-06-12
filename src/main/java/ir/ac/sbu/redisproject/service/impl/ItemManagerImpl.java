package ir.ac.sbu.redisproject.service.impl;

import ir.ac.sbu.redisproject.dao.ItemDao;
import ir.ac.sbu.redisproject.dao.impl.ItemDaoImpl;
import ir.ac.sbu.redisproject.dao.model.Item;
import ir.ac.sbu.redisproject.service.ItemManager;
import java.util.Set;

public class ItemManagerImpl implements ItemManager {

    @Override
    public void insertItem(Item item) {
        ItemDao itemDao = new ItemDaoImpl();
        itemDao.insertItem(item);
    }

    @Override
    public String getItem(Item item) {
        ItemDao itemDao = new ItemDaoImpl();
        return itemDao.getItem(item);
    }

    @Override
    public Set<String> getAllItems() {
        ItemDao itemDao = new ItemDaoImpl();
        return itemDao.getAllItems();
    }

    @Override
    public String getItemScore(String itemId) {
        ItemDao itemDao = new ItemDaoImpl();
        return itemDao.getItemScore(itemId);
    }

}
