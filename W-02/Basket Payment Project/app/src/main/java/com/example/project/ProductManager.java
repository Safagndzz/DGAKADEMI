package com.example.project;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private volatile static ProductManager instance;
    private static List<Product> basket;
    public static ProductManager getInstance() {
        if(instance == null) {
            synchronized (ProductManager.class) {
                if(instance == null) {
                    instance = new ProductManager();
                    basket = new ArrayList<>();
                }
            }
        }
        return instance;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }
}
