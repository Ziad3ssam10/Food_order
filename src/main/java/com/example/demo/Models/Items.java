package com.example.demo.Models;

import com.example.demo.Main;

public class Items {
    private String Name;
    private double Price;
    private String type;
    private int quantity;


    public static int get_index(String item, int index_of_governorate, int index_of_area, int index_of_rest)
    {
        for(int i = 0; i< Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).getResturantlist().get(index_of_rest).getFood_items().size(); i++)
        {
            if(Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).getResturantlist().get(index_of_rest).getFood_items().get(i).Name.equals(item))
            {
                return i;
            }
        }

        return -1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
