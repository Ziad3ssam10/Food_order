package com.example.demo;


import com.example.demo.Models.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;


public class Main extends Application {
    public static ObservableList<Admin> moderators = FXCollections.observableArrayList();  //save
    public static ObservableList<Governorate> capitals = FXCollections.observableArrayList(); //save
    public static int customeridx;
    public static int deliveryidx;
    public static int adminidx=0;
    public static int governoridx=0;
    public static int area_del_idx=0;
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().ShowRegisterWindow();
    }

    public static void main(String[] args) {
        Governorate governorate1=new Governorate("Alex");
        Area a1=new Area();
        a1.setName("abo qer");
        Area a2=new Area();
        a2.setName("bianki");
        Area a3=new Area();
        a3.setName("san fransisco");
        governorate1.add_area(a1);
        governorate1.add_area(a2);
        governorate1.add_area(a3);
        Area area1 = new Area();
        area1.setName("abasia");
        Area area2 = new Area();
        area2.setName("ta7reer");
        Area area3 = new Area();
        area3.setName("ramsis");
        Governorate governorate = new Governorate("cairo");
        governorate.add_area(area1);
        governorate.add_area(area2);
        governorate.add_area(area3);
        capitals.add(governorate);
        capitals.add(governorate1);
        Admin first=new Admin();
        first.setL_name("Ahmed");
        first.setEmail("mada.am23@gmail.com");
        first.setPassword("123456789");
        first.set_Phone_number("01069017980");
        moderators.add(first);
        launch(args);
    }
}