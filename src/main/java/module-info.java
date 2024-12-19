module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.controllers;
    exports com.example.demo.controllers.Admin;
    exports com.example.demo.controllers.Customer;
    exports com.example.demo.Models;
    exports com.example.demo.Views;
    opens com.example.demo.controllers to javafx.fxml;
    exports com.example.demo.controllers.Delivery;
    opens com.example.demo.controllers.Delivery to javafx.fxml;
}