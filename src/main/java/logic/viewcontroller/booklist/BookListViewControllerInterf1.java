package logic.viewcontroller.booklist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import logic.pageswitch.PageMenu;


public class BookListViewControllerInterf1 {
    private PageMenu pageswitch;
    @FXML
    private Group group1;
    @FXML
    private Group group2;
    @FXML
    private Group group3;
    @FXML
    private Group group4;
    @FXML
    private Group group5;
    @FXML
    private Group group6;
    @FXML
    private Group group7;
    @FXML
    private Group group8;

    public BookListViewControllerInterf1(){
        pageswitch = new PageMenu();
    }

    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHome(event);
    }
    @FXML
    protected void goToBookList(ActionEvent event) {
        pageswitch.switchToBookList(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageswitch.switchToISCUser(event);
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageswitch.switchToSettings(event);
    }
    @FXML
    protected void outputVal(){

    }
}
