package com.example.demo.Models;

import com.example.demo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Area {

    private String Name;
    private ObservableList<Resturant> resturantlist= FXCollections.observableArrayList();
    private ObservableList<Delievry_Staff> delievryStaffs=FXCollections.observableArrayList();


    public static int get_index(String area,int index_of_governorate)
    {
        for(int i=0;i<Main.capitals.get(index_of_governorate).getArea_list().size();i++)
        {
            if(Main.capitals.get(index_of_governorate).getArea_list().get(i).Name.equals(area))
            {
                return i;
            }
        }
        return -1;
    }



    public static ObservableList<Resturant> search_category(int index_of_governorate,int index_of_area,String category)
    {
        ObservableList<Resturant> demo=FXCollections.observableArrayList();
        for(int i = 0; i< Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).resturantlist.size(); i++)
        {

            for(int j=0;j<Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).resturantlist.get(i).getCategory().size();j++)
            {
                if(Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).resturantlist.get(i).getCategory().get(j).equals(category))
                {
                    demo.add(Main.capitals.get(index_of_governorate).getArea_list().get(index_of_area).resturantlist.get(i));
                }

            }
        }
        return demo;
    }


    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public ObservableList<Resturant> getResturantlist() {
        return resturantlist;
    }

    public ObservableList<Delievry_Staff> getDelievryStaffs() {
        return delievryStaffs;
    }
}
