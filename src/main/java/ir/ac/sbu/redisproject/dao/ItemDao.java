package ir.ac.sbu.redisproject.dao;

import ir.ac.sbu.redisproject.dao.model.Item;
import java.util.List;

public interface ItemDao {

    public void insertItem(Item item);

    public List<Item> getAllItems();

    public String getItem(Item item);

    public String getItemScore(String itemId);

}
