package ir.ac.sbu.redisproject.dao;

import ir.ac.sbu.redisproject.dao.model.Item;
import java.util.List;
import java.util.Map;

public interface ItemDao {

    public void insertItem(Item item);

    public List<Item> getAllItems();

    public String getItem(Item item);

    public String getItemScore(String itemId);
    
    public Map<Item, Double> getAllItemsWithScores();

}
