package logic.viewcontroller.booklistchef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.appcontroller.BookListController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;
import logic.patterns.Setter;
import logic.viewcontroller.booklist.BookListViewController;

import java.util.HashMap;

public class BookListChefViewControllerInterf1 extends BookListViewController {


    public void initialize() {
        try {
            super.bookList=controller.loadBookList();
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        initList();
    }

    public BookListChefViewControllerInterf1(){
        controller = new BookListController();
        pageSwitch = new PageMenu();
        super.bookList = Setter.getBookList();
        bookBeanMap = new HashMap<>();
        g1Index=9;
        g2Index=10;
        g3Index=11;
        g4Index=12;
    }


    @FXML
    protected void goToHomeChef(ActionEvent event) {
        pageSwitch.switchToHomeChef(event);
    }
    @FXML
    protected void goToBookListChef(ActionEvent event) {
        pageSwitch.switchToChefBookList(event);
    }
    @FXML
    protected void goToISCChef(ActionEvent event) {
        pageSwitch.switchToISCChef(event);
    }
    @FXML
    protected void goToSettingsChef(ActionEvent event) {
        pageSwitch.switchToSettingsChef(event);
    }

}
