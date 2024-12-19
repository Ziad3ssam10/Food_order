package com.example.demo.Models;

import javafx.beans.property.*;

public class Order {
    private  int id;
    private  String restaurantName;
    private  double totalPrice;
    private boolean status=false;
    private final SimpleStringProperty delivered=new SimpleStringProperty("delivered");
    private final SimpleStringProperty pending=new SimpleStringProperty("pending");
    private String Governorate;
    private String addrsse;
    private String area;
    private Boolean assigne_Io_delivery=false;



    public SimpleIntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }


    public SimpleStringProperty restaurantNameProperty() {
        return new SimpleStringProperty(restaurantName);
    }


    public SimpleDoubleProperty totalPriceProperty() {
        return new SimpleDoubleProperty(totalPrice);
    }

    public SimpleStringProperty statusProperty() {
        if (status){
            return delivered;
        }
        else {
            return pending;
        }
    }


    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean getStatus() {

        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getGovernorate() {
        return Governorate;
    }

    public void setGovernorate(String governorate) {
        Governorate = governorate;
    }

    public String getAddrsse() {
        return addrsse;
    }

    public void setAddrsse(String addrsse) {
        this.addrsse = addrsse;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Boolean getAssigne_Io_delivery() {
        return assigne_Io_delivery;
    }

    public void setAssigne_Io_delivery(Boolean assigne_Io_delivery) {
        this.assigne_Io_delivery = assigne_Io_delivery;
    }
}
