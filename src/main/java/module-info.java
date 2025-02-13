module com.example.homechef {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires java.management;
    requires spring.context;
    requires spring.jdbc;
    requires org.testng;
    requires java.naming;
    requires java.desktop;
    requires spring.tx;
    requires com.opencsv;

    opens logic to javafx.fxml;
    exports logic;
    exports logic.viewcontroller.login;
    opens logic.viewcontroller.login to javafx.fxml;
    exports logic.viewcontroller.recoverpasswd;
    opens logic.viewcontroller.recoverpasswd to javafx.fxml;
    exports logic.viewcontroller.search;
    opens logic.viewcontroller.search to javafx.fxml;
    exports logic.viewcontroller.signup;
    opens logic.viewcontroller.signup to javafx.fxml;
    exports logic.viewcontroller.signup.signupchef;
    opens logic.viewcontroller.signup.signupchef to javafx.fxml;
    exports logic.viewcontroller.settings;
    opens logic.viewcontroller.settings to javafx.fxml;
    exports logic.viewcontroller.resultsearch;
    opens logic.viewcontroller.resultsearch to javafx.fxml;
    exports logic.viewcontroller.visithomechef;
    opens logic.viewcontroller.visithomechef to javafx.fxml;
    exports logic.viewcontroller.book;
    opens logic.viewcontroller.book to javafx.fxml;
    exports logic.viewcontroller.chat;
    opens logic.viewcontroller.chat to javafx.fxml;
    exports logic.viewcontroller.initialsearchandchat;
    opens logic.viewcontroller.initialsearchandchat to javafx.fxml;
    exports logic.viewcontroller.booklist;
    opens logic.viewcontroller.booklist to javafx.fxml;
    exports logic.viewcontroller.homepagechef;
    opens logic.viewcontroller.homepagechef to javafx.fxml;
    exports logic.connection;
    exports logic.beans;
    exports logic.appcontroller;
    exports logic.dao;
    exports logic.model;
    exports logic.viewcontroller.signup.signupcustomer;
    opens logic.viewcontroller.signup.signupcustomer to javafx.fxml;
    exports logic.patterns;
    opens logic.patterns to javafx.fxml;
    exports logic.dao.rowmapper;
    opens logic.beans to javafx.fxml;
    exports logic.homechefutil;
    opens logic.homechefutil to javafx.fxml;
    exports logic.exceptions;
    opens logic.viewcontroller.booklistchef to javafx.fxml;
    exports logic.viewcontroller.booklistchef;


}