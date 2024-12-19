package com.example.demo.Models;

import com.example.demo.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Resturant {
    private String Name;
    private String Area;
    private String Governorate;
    private ObservableList<String> Category= FXCollections.observableArrayList();
    private ObservableList<Items> Food_items=FXCollections.observableArrayList();





    public static int get_index(String rest,int index_of_governorate,int index_of_area)
    {
        for(int i = 0; i< Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).getResturantlist().size(); i++)
        {
            if(Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).getResturantlist().get(i).Name.equals(rest))
            {
                return i;
            }
        }

        return -1;
    }





    // update resturant


    public void add_category(String name)
    {

        this.Category.add(name);
    }


    public int Remove_category(String name) {
        for (int i = 0; i < this.Category.size(); i++) {
            if (this.Category.get(i).equals(name)) {
                this.Category.remove(i);
                return 1;
            }
        }
        return 0;
    }


    public void AddItem(String Name , double Price, String Type)
    {
        Items it=new Items();
        it.setName(Name);
        it.setPrice(Price);
        it.setType(Type);
        this.Food_items.add(it);
    }

    public int RemoveItem(String name)
    {
        for(int i=0;i<this.Food_items.size();i++)
        {
            if(this.Food_items.get(i).getName().equals(name))
            {
                this.Food_items.remove(i);
                return 1;

            }
        }
        return 0;
    }


    public String get_name(){
        return Name;
    }
    public String get_area(){
        return Area;
    }
    public String get_Governorate(){
        return Governorate;
    }
    public SimpleStringProperty getNameProperty(){
        return new SimpleStringProperty(Name);
    }
    public SimpleStringProperty getAreaProperty(){
        return new SimpleStringProperty(Area);
    }
    public SimpleStringProperty getGovernorateProperty(){
        return new SimpleStringProperty(Governorate);
    }


    public void set_Name(String Name){
         this.Name=Name;
    }
    public void set_Area(String Area){
        this.Area=Area;
    }
    public void set_Governorate(String Governorate){
        this.Governorate=Governorate;
    }


    public void setCategory(String category) {
        this.Category.add(category);
    }

    public void setFood_items(Items food_items) {
        this.Food_items.add(food_items);
    }

    public ObservableList<String> getCategory() {
        return Category;
    }

    public ObservableList<Items> getFood_items() {
        return Food_items;
    }
}