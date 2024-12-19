package com.example.demo.Models;

import com.example.demo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Delievry_Staff extends User{
        private String area;
        private String governorate;
        private int age;
        private String Phone_number;
        private Boolean deliverystaff_status = true;

        private ObservableList<Order> orders = FXCollections.observableArrayList();

        public int Register(String F_name, String L_name, String Email, String Password, String Phone_number, int age, String Area, String Governorate) {
            int check = super.Register(F_name, L_name, Email, Password);
            if (Phone_number.length() != 11 || Phone_number.charAt(0) != '0') {
                check = -6;
            }
            this.age = age;
            this.Phone_number = Phone_number;
            this.area = Area;
            this.governorate = Governorate;
            return check;
        }


        public void Change_state_order(int id) {
            for (int i = 0; i < this.orders.size(); i++) {
                if (this.orders.get(i).getId() == id) {
                    this.orders.get(i).setStatus(true);
                }
            }
            this.deliverystaff_status = true;
        }


    public static int get_free_delivery(int govindex,int areaindex)
    {

        for(int i = 0; i< Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().size(); i++)
        {
            if(Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(i).deliverystaff_status)
            {
                return i;
            }
        }

        return -1;
    }



    public String get_FName(){
        return this.F_name;
    }
    public String get_LName(){
        return this.L_name;
    }
    public String get_Email(){
        return this.Email;
    }
    public String get_Phone_number(){
        return this.Phone_number;
    }
    public int get_age(){
        return this.age;
    }
    public String get_Governorate(){
        return this.governorate;
    }
    public String get_pass(){
        return this.Password;
    }
    public String get_Area(){
            return this.area;
    }
    public Boolean get_deliverystaff_status(){
            return this.deliverystaff_status;
    }
    public void set_deliverystaff_status(Boolean status){
            this.deliverystaff_status = status;
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ObservableList<Order> orders) {
        this.orders = orders;
    }
}
