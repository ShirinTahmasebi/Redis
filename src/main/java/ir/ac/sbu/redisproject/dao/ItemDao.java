package ir.ac.sbu.redisproject.dao;

import ir.ac.sbu.redisproject.dao.model.Item;
import java.util.Set;

public interface ItemDao {

    public void insertItem(Item item);

    public Set<String> getAllItems();

    public String getItem(Item item);

    public String getItemScore(String itemId);
}