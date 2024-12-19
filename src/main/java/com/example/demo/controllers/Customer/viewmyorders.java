package com.example.demo.controllers.Customer;

import com.example.demo.Main;
import com.example.demo.Models.Customer;
import com.example.demo.Models.Model;
import com.example.demo.Models.Order;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class viewmyorders implements Initializable {
    public Button undo_btn;
    public TableColumn<Order,Integer> OrderID_column;
    public TableView<Order> vieworder_table;
    public TableColumn<Order,String> namerest_column;
    public TableColumn<Order,Double> price_column;
    public TableColumn<Order,String> Status_column;
    public Label noorder_lbl;
    public Text el7taelso8nna;


    public ObservableList<Order> orders = FXCollections.observableArrayList();
    public Button cancel1_btn;
    public Button cancel2_btn;
    public Button cancel3_btn;
    public Button cancel4_btn;
    public Button cancel5_btn;
    public Button cancel6_btn;
    public Button cancel7_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        cancel1_btn.setVisible(false);
        cancel2_btn.setVisible(false);
        cancel3_btn.setVisible(false);
        cancel4_btn.setVisible(false);
        cancel5_btn.setVisible(false);
        cancel6_btn.setVisible(false);
        cancel7_btn.setVisible(false);
        noorder_lbl.setVisible(true);
        orders= Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders();
        if(orders.isEmpty()){
            cancel1_btn.setVisible(false);
            cancel2_btn.setVisible(false);
            cancel3_btn.setVisible(false);
            cancel4_btn.setVisible(false);
            cancel5_btn.setVisible(false);
            cancel6_btn.setVisible(false);
            cancel7_btn.setVisible(false);
            noorder_lbl.setVisible(true);
            vieworder_table.setVisible(false);
            el7taelso8nna.setVisible(false);
        }
        else {
            for (int i = 0; i < orders.size(); i++) {
                if (i==0 && !orders.get(i).getStatus()){
                    cancel1_btn.setVisible(true);
                }
                if(i==1 && !orders.get(i).getStatus()){
                    cancel2_btn.setVisible(true);
                }
                if(i==2 && !orders.get(i).getStatus()){
                    cancel3_btn.setVisible(true);
                }
                if(i==3 && !orders.get(i).getStatus()){
                    cancel4_btn.setVisible(true);
                }
                if(i==4 && !orders.get(i).getStatus()){
                    cancel5_btn.setVisible(true);
                }
                if(i==5 && !orders.get(i).getStatus()){
                    cancel6_btn.setVisible(true);
                }
                if(i==6 && !orders.get(i).getStatus()){
                    cancel7_btn.setVisible(true);
                }
            }
            el7taelso8nna.setVisible(true);
            noorder_lbl.setVisible(false);
            vieworder_table.setVisible(true);
            OrderID_column.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            namerest_column.setCellValueFactory(cellData -> cellData.getValue().restaurantNameProperty());
            price_column.setCellValueFactory(cellData -> cellData.getValue().totalPriceProperty().asObject());
            Status_column.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
            vieworder_table.setItems(orders);
        }
        cancel1_btn.setOnAction(event -> cancel(0));
        cancel2_btn.setOnAction(event -> cancel(1));
        cancel3_btn.setOnAction(event ->cancel(2));
        cancel4_btn.setOnAction(event -> cancel(3));
        cancel5_btn.setOnAction(event -> cancel(4));
        cancel6_btn.setOnAction(event -> cancel(5));
        cancel7_btn.setOnAction(event -> cancel(6));

        undo_btn.setOnAction(event -> to_undo());
    }


    public void cancel(int i){
        Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).RemoveOrder(i);
        orders= Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).getOrders();
        if(orders.isEmpty()){
            cancel1_btn.setVisible(false);
            cancel2_btn.setVisible(false);
            cancel3_btn.setVisible(false);
            cancel4_btn.setVisible(false);
            cancel5_btn.setVisible(false);
            cancel6_btn.setVisible(false);
            cancel7_btn.setVisible(false);
            noorder_lbl.setVisible(true);
            vieworder_table.setVisible(false);
            el7taelso8nna.setVisible(false);
        }
        else {
            if (i==0){
                cancel1_btn.setVisible(false);
            }
            if (i==1){
                cancel2_btn.setVisible(false);
            }
            if (i==2){
                cancel3_btn.setVisible(false);
            }
            if (i==3){
                cancel4_btn.setVisible(false);
            }
            if (i==4){
                cancel5_btn.setVisible(false);
            }
            if (i==5){
                cancel6_btn.setVisible(false);
            }
            if (i==6){
                cancel7_btn.setVisible(false);
            }
        }
    }


    public void to_undo() {
        orders=FXCollections.observableArrayList();
        Model.getInstance().getViewFactory().ShowfirstcusWindow();
    }
}

