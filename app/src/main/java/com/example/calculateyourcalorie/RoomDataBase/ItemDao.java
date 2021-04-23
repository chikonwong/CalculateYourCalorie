package com.example.calculateyourcalorie.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


// sqlite
@Dao
public interface ItemDao {


    @Insert
    void insert(Item item);
    @Update
    void update(Item item);
    @Delete
    void delete(Item item);
    // clear all items
    @Query("DELETE FROM item_table")
    void deleteAllItem();
    // get all items
    @Query("SELECT * FROM item_table ORDER BY date DESC")
    // if item_table have any change, display automatically
    LiveData<List<Item>> getAllItems();

    @Query("SELECT TOTAL(calories) FROM item_table")
    LiveData<Integer> getTotalCalories();
}
