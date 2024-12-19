package com.example.demo.Models;

import com.example.demo.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Customer extends User {
    private static int order_id=238000;
    private String governorate;
    private int age;
    private String Phone_number;
    private String Gender;

    private ObservableList<Order> orders= FXCollections.observableArrayList();

    public int Register(String F_name, String L_name, String Email, String Password, String Phone_number, int age,String Gender,String Governorate,int govindex)
    {
        int check=super.Register( F_name,  L_name,  Email,  Password);
        if(Phone_number.length()!=11 || Phone_number.charAt(0)!='0') {
            check= -3;
        }
        this.age=age;
        this.Gender=Gender;
        this.Phone_number=Phone_number;
        this.governorate=Governorate;

        if(check!=1){
            return check;
        }

        Main.capitals.get(govindex).getCustomers().add(this);
        return  Main.capitals.get(govindex).getCustomers().size()-1;
    }
    public int CreateOrder(String Governorate,String area,String name, Double price,String addresse, int govindex,int areaindex)
    {
        Order order1=new Order();
        order1.setId(order_id);
        order_id++;
        order1.setRestaurantName(name);
        order1.setArea(area);
        order1.setAddrsse(addresse);
        order1.setTotalPrice(price);
        order1.setGovernorate(Governorate);

        int deliveryindex=Delievry_Staff.get_free_delivery(govindex,areaindex);

        if(deliveryindex!=-1) {
            order1.setAssigne_Io_delivery(true);
            Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(deliveryindex).set_deliverystaff_status(false);
            Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(deliveryindex).getOrders().add(order1);
        }
        Main.capitals.get(govindex).getCustomers().get(Main.customeridx).orders.add(order1);
        return 1;

    }

    public int RemoveOrder(int orderindex)
    {

        order_id--;
        int govindex= Governorate.get_index(this.orders.get(orderindex).getGovernorate());
        int areaindex=Area.get_index(this.orders.get(orderindex).getArea(),govindex);
        Boolean found=false;
        for(int j=0;j<Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().size();j++)
        {
            if(found)
                break;
            for(int k=0;k<Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(j).getOrders().size();k++)
            {
                if( Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(j).getOrders().get(k).getId()==this.orders.get(orderindex).getId())
                {
                    Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(j).set_deliverystaff_status(true);
                    Main.capitals.get(govindex).getArea_list().get(areaindex).getDelievryStaffs().get(j).getOrders().remove(k);
                    found=true;
                    break;
                }


            }
        }
        this.orders.remove(orderindex);
        return 1;
    }



    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ObservableList<Order> orders) {
        this.orders = orders;
    }

}