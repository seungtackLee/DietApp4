package com.example.dietapp4;

import java.io.Serializable;
import java.util.Date;

public class Meal implements Serializable {
    String date;
//    나중엔 배열로 바꿔야 할듯?
    String food;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Meal(String date, String food) {
        this.date = date;
        this.food = food;
    }



}
