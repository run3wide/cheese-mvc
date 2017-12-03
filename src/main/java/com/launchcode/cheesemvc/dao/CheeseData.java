package com.launchcode.cheesemvc.dao;

import com.launchcode.cheesemvc.models.Cheese;

import java.util.HashMap;
import java.util.Map;

public class CheeseData {

    public static Map<Integer, Cheese> cheeses = new HashMap<>();

    public CheeseData() {
    }

    public static Map<Integer, Cheese> getCheeses() {
        return cheeses;
    }

    public static void setCheeses(Map<Integer, Cheese> cheeses) {
        CheeseData.cheeses = cheeses;
    }

    public static void addCheese(Cheese cheese) {
        cheeses.put(cheese.getId(), cheese);
    }


    public static void removeCheese(Cheese cheese) {
        cheeses.remove(cheese.getId());
    }

    public static void removeCheeseById(int id) {
        cheeses.remove(id);
    }
}
