package com.example.demo.controllers.Admin;

import com.example.demo.Main;
import com.example.demo.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class addtayar implements Initializable {

    public TextField firstname_fild;
    public TextField lastname_fild;
    public TextField email_fild;
    public PasswordField pass_fild;
    public TextField phonenum_fild;
    public ChoiceBox<String> gov_selector;
    public ChoiceBox<String> area_selector;
    public TextField age_fild;
    public Label Error_lbl;
    public Button addtayar_btn;
    public Button undo_btn;
    public Label success_lbl;
    int idx_gov;
    int idx_area;
    static ObservableList<String> areas=FXCollections.observableArrayList();
    static ObservableList<String> govs=FXCollections.observableArrayList();



    public void get_array_of_areas(ObservableList<Area> areas1) {
        for (Area idx : areas1) {
            areas.add(idx.getName());
        }
    }
    public void get_array_of_gov() {
        for( Governorate idx : Main.capitals){
            govs.add(idx.getName());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        govs=FXCollections.observableArrayList();
        areas=FXCollections.observableArrayList();
        get_array_of_gov();
        gov_selector.setItems(govs);
        success_lbl.setVisible(false);
        Error_lbl.setVisible(false);
        area_selector.setDisable(true);
        gov_selector.setOnAction(event -> open_area_select());
        addtayar_btn.setOnAction(event -> addtayar());
        undo_btn.setOnAction(event -> undo());
        firstname_fild.setOnAction(event -> success_lbl.setVisible(false));
    }





    public void addtayar() {
        if (gov_selector.getValue() == null || area_selector.getValue() == null || age_fild.getText() == "") {
            Error_lbl.setVisible(true);
        }
        else {
            try {
                idx_area = Area.get_index(area_selector.getSelectionModel().getSelectedItem(), idx_gov);
                int check = Main.moderators.get(Main.adminidx).Add_Delievry_stuff(firstname_fild.getText(), lastname_fild.getText(), email_fild.getText(), pass_fild.getText(), phonenum_fild.getText(), Integer.parseInt(age_fild.getText()), area_selector.getSelectionModel().getSelectedItem(), gov_selector.getSelectionModel().getSelectedItem(),idx_area,idx_gov);
                if (check ==1) {
                    Error_lbl.setVisible(false);
                    success_lbl.setVisible(true);
                    firstname_fild.clear();
                    lastname_fild.clear();
                    email_fild.clear();
                    pass_fild.clear();
                    phonenum_fild.clear();
                    age_fild.clear();
                    firstname_fild=null;
                    lastname_fild=null;
                    email_fild=null;
                    pass_fild=null;
                    phonenum_fild=null;
                    age_fild=null;
                    gov_selector.getSelectionModel().clearSelection();
                    area_selector.getSelectionModel().clearSelection();
                }
                else {
                    Error_lbl.setVisible(true);
                }
            }
            catch (NumberFormatException e) {
                Error_lbl.setVisible(true);
            }
        }
    }



    public void undo() {
        gov_selector.getSelectionModel().clearSelection();
        area_selector.getSelectionModel().clearSelection();
        success_lbl.setVisible(false);
        Error_lbl.setVisible(false);
        Model.getInstance().getViewFactory().Show_firstpageadmin();
    }




    public void open_area_select() {
        areas=FXCollections.observableArrayList();
        area_selector.setDisable(false);
        if(gov_selector.getValue()!=null) {
            idx_gov=Governorate.get_index(gov_selector.getSelectionModel().getSelectedItem());
            get_array_of_areas(Main.capitals.get(idx_gov).getArea_list());
            area_selector.setItems(areas);
        }
    }
}
