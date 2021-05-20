package com.example.calculateyourcalorie.RoomDataBase;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


// database table
@Entity(tableName = "item_table")
public class Item {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "Date")
    private String date;
    @ColumnInfo(name = "period")
    private String period;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "foodname")
    private String foodname;
    @ColumnInfo(name = "calories")
    private int calories;

    public Item(String date, String period, String category, String foodname, int calories) {
        this.date = date;
        this.period = period;
        this.category = category;
        this.foodname = foodname;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
