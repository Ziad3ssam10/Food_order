package com.example.demo.Models;
import com.example.demo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Governorate {

    private String Name;
    private ObservableList<Area> area_list= FXCollections.observableArrayList();
    private ObservableList<Customer> customers=FXCollections.observableArrayList();

    public Governorate(String Name){

        this.Name=Name;

    }


    public static int get_index(String Location_of_customer)
    {
        for(int i = 0; i< Main.capitals.size(); i++)
        {
            if(Main.capitals.get(i).Name.equals(Location_of_customer))
            {
                return i;
            }
        }

        return -1;
    }


    public void add_area(Area area)
    {
        area_list.add(area);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ObservableList<Area> getArea_list() {
        return area_list;
    }

    public void setArea_list(ObservableList<Area> area_list) {
        this.area_list = area_list;
    }

    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ObservableList<Customer> customers) {
        this.customers = customers;
    }
}
