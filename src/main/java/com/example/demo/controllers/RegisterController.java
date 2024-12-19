package com.example.demo.controllers;

import com.example.demo.Main;
import com.example.demo.Models.Customer;
import com.example.demo.Models.Governorate;
import com.example.demo.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    public TextField firstname_fild;
    public TextField lastname_fild;
    public TextField email_fild;
    public PasswordField pass_fild;
    public TextField phonenum_fild;
    public ChoiceBox<String> gov_selector;
    public ChoiceBox<String> gender_selector;
    public TextField age_fild;
    public Button register_btn;
    public Button registerpage_btn;
    public Button loginpage_btn;
    public Label Error_lbl;

    ObservableList<String> gov=FXCollections.observableArrayList();
    ObservableList<String> gender=FXCollections.observableArrayList("Male","Female");
    public void add_gov(){
        for(Governorate idx: Main.capitals){
            gov.add(idx.getName());
        }
        gov_selector.setItems(gov);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_gov();
        gender_selector.setItems(gender);
        loginpage_btn.setOnAction(event -> gotologin());
        register_btn.setOnAction(event -> onregister());
    }

    private void onregister (){
        if (gov_selector.getValue() == null || gender_selector.getValue() == null) {
            Error_lbl.setVisible(true);
        }
        else {
            Customer c=new Customer();
            int idx= Governorate.get_index(gov_selector.getSelectionModel().getSelectedItem());
             int check =c.Register(firstname_fild.getText(),lastname_fild.getText(),email_fild.getText(),pass_fild.getText(),phonenum_fild.getText(), Integer.parseInt(age_fild.getText()),gender_selector.getSelectionModel().getSelectedItem(),gov_selector.getSelectionModel().getSelectedItem(),idx);
             if (check<0){
                 Error_lbl.setVisible(true);
             }
             else {
                 Main.governoridx=Governorate.get_index(gov_selector.getSelectionModel().getSelectedItem());
                 Main.customeridx=check;
                 Model.getInstance().getViewFactory().ShowfirstcusWindow();
             }
        }
    }
    private void gotologin(){
        gov_selector.getSelectionModel().clearSelection();
        gender_selector.getSelectionModel().clearSelection();
        Model.getInstance().getViewFactory().ShowLoginWindow();
    }
}

