package com.example.demo.controllers.Customer;

import com.example.demo.Main;
import com.example.demo.Models.Area;
import com.example.demo.Models.Governorate;
import com.example.demo.Models.Model;
import com.example.demo.Models.Resturant;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class restaurantview implements Initializable {
    public Button undo_btn;
    public Label RestaurantName_lbl;
    public Label Governate_lbl;
    public Label Catogery_lbl;
    public TextField QTY_fild1;
    public TextField QTY_fild2;
    public TextField QTY_fild3;
    public TextField QTY_fild5;
    public TextField QTY_fild4;
    public TextField QTY_fild6;
    public TextField QTY_fild7;
    public TextField QTY_fild8;
    public Label itemname_lbl1;
    public Label itemname_lbl2;
    public Label itemname_lbl3;
    public Label itemname_lbl4;
    public Label itemname_lbl5;
    public Label itemname_lbl6;
    public Label itemname_lbl7;
    public Label itemname_lbl8;
    public Label price_lbl1;
    public Label price_lbl2;
    public Label price_lbl3;
    public Label price_lbl4;
    public Label price_lbl5;
    public Label price_lbl6;
    public Label price_lbl7;
    public Label price_lbl8;
    public Button confirm_btn;
    public Label totalp_lbl;
    public TextField address_fild;

    static Resturant resturant=new Resturant();
    public Label nomenu_lbl;
    public Button Add_btn;
    public Button cancel_btn;
    public Text text1_lbl;
    public Text text2_lbl;
    public Text text3_lbl;
    public Label error_lbl;
    public Label success_lbl;
    public Label error_lbl1;

    double total=0;

    public static void set_rest(Resturant rest){
        resturant=rest;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomenu_lbl.setVisible(true);
        RestaurantName_lbl.setText(resturant.get_name().toUpperCase());
        Governate_lbl.setText(resturant.get_Governorate()+" , "+resturant.get_area());
        if (!resturant.getCategory().isEmpty()) {
            Catogery_lbl.setText(resturant.getCategory().get(0));
        }
        else {
            Catogery_lbl.setText("");
        }
        totalp_lbl.setVisible(false);
        confirm_btn.setVisible(false);
        cancel_btn.setVisible(false);
        totalp_lbl.setVisible(false);
        text1_lbl.setVisible(false);
        text2_lbl.setVisible(false);
        text3_lbl.setVisible(false);
        address_fild.setText("");
        address_fild.setVisible(false);
        Add_btn.setVisible(false);
        for (int i=0;i<resturant.getFood_items().size();i++){
            if (i==0){
                Add_btn.setVisible(true);
                itemname_lbl1.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl1.setVisible(true);
                price_lbl1.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl1.setVisible(true);
                QTY_fild1.setVisible(true);
                nomenu_lbl.setVisible(false);
            }
            if(i==1){
                itemname_lbl2.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl2.setVisible(true);
                price_lbl2.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl2.setVisible(true);
                QTY_fild2.setVisible(true);
            }
            if(i==2){
                itemname_lbl3.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl3.setVisible(true);
                price_lbl3.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl3.setVisible(true);
                QTY_fild3.setVisible(true);
            }
            if(i==3){
                itemname_lbl4.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl4.setVisible(true);
                price_lbl4.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl4.setVisible(true);
                QTY_fild4.setVisible(true);
            }
            if(i==4){
                itemname_lbl5.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl5.setVisible(true);
                price_lbl5.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl5.setVisible(true);
                QTY_fild5.setVisible(true);
            }
            if(i==5){
                itemname_lbl6.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl6.setVisible(true);
                price_lbl6.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl6.setVisible(true);
                QTY_fild6.setVisible(true);
            }
            if(i==6){
                itemname_lbl7.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl7.setVisible(true);
                price_lbl7.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl7.setVisible(true);
                QTY_fild7.setVisible(true);
            }
            if(i==7){
                itemname_lbl8.setText(resturant.getFood_items().get(i).getName());
                itemname_lbl8.setVisible(true);
                price_lbl8.setText(String.valueOf(resturant.getFood_items().get(i).getPrice())+"$");
                price_lbl8.setVisible(true);
                QTY_fild8.setVisible(true);
            }
        }

        cancel_btn.setOnAction(event -> clear_order());
        confirm_btn.setOnAction(event -> confirm_order());
        Add_btn.setOnAction(event -> addorder());
        undo_btn.setOnAction(event -> undo());
    }


    public void undo(){
        Model.getInstance().getViewFactory().ShowCreateorderView();
    }


    public void clear_order(){
        text1_lbl.setVisible(false);
        text2_lbl.setVisible(false);
        text3_lbl.setVisible(false);
        address_fild.setVisible(false);
        cancel_btn.setVisible(false);
        confirm_btn.setVisible(false);
        totalp_lbl.setVisible(false);
        QTY_fild1.setDisable(false);
        QTY_fild2.setDisable(false);
        QTY_fild3.setDisable(false);
        QTY_fild4.setDisable(false);
        QTY_fild5.setDisable(false);
        QTY_fild6.setDisable(false);
        QTY_fild7.setDisable(false);
        QTY_fild8.setDisable(false);
        Add_btn.setDisable(false);
        total=0;
        totalp_lbl.setText("0");
        address_fild.setText("");
        error_lbl.setVisible(false);
        success_lbl.setVisible(false);
        error_lbl1.setVisible(false);
    }

    public void confirm_order(){
        if (address_fild.getText().isEmpty() || address_fild.getText().equals("")){
         error_lbl.setVisible(true);
         success_lbl.setVisible(false);
         error_lbl1.setVisible(false);
        }
        else if (total==0){
            error_lbl1.setVisible(true);
            error_lbl.setVisible(false);
            success_lbl.setVisible(false);
        }
        else{
            Main.capitals.get(Main.governoridx).getCustomers().get(Main.customeridx).CreateOrder(resturant.get_Governorate(),resturant.get_area(),resturant.get_name(),total,address_fild.getText(), Governorate.get_index(resturant.get_Governorate()), Area.get_index(resturant.get_area(),Governorate.get_index(resturant.get_Governorate())));
            success_lbl.setVisible(true);
            error_lbl.setVisible(false);
            error_lbl1.setVisible(false);
            Model.getInstance().getViewFactory().ShowViewordersView();
        }
    }


    public void addorder() {
        text1_lbl.setVisible(true);
        text2_lbl.setVisible(true);
        text3_lbl.setVisible(true);
        cancel_btn.setVisible(true);
        confirm_btn.setVisible(true);
        totalp_lbl.setVisible(true);
        address_fild.setVisible(true);
        QTY_fild1.setDisable(true);
        QTY_fild2.setDisable(true);
        QTY_fild3.setDisable(true);
        QTY_fild4.setDisable(true);
        QTY_fild5.setDisable(true);
        QTY_fild6.setDisable(true);
        QTY_fild7.setDisable(true);
        for (int i = 0; i < resturant.getFood_items().size(); i++) {
            if (i==0) {
                total += resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild1.getText());
            }
            if (i==1) {
                total+=resturant.getFood_items().get(i).getPrice()*Integer.parseInt(QTY_fild2.getText());
            }
            if (i==2) {
                total+=resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild3.getText());
            }
            if (i==3) {
                total+=resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild4.getText());
            }
            if (i==4) {
                total+=resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild5.getText());
            }
            if (i==5) {
                total+=resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild6.getText());
            }
            if (i==6){
                total+=resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild7.getText());
            }
            if (i==7){
                total+=resturant.getFood_items().get(i).getPrice() * Integer.parseInt(QTY_fild8.getText());
            }
        }
        totalp_lbl.setText(String.valueOf(total)+"$");
        Add_btn.setDisable(true);
    }
}
