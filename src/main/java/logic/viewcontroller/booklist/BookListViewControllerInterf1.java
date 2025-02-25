package logic.viewcontroller.booklist;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.appcontroller.BookListController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;


import java.util.HashMap;


public class BookListViewControllerInterf1 extends BookListViewController{


    public BookListViewControllerInterf1(){
        controller = new BookListController();
        pageSwitch = new PageMenu();
        bookBeanMap = new HashMap<>();
        g1Index=10;
        g2Index=11;
        g3Index=12;
        g4Index=13;

    }



    @FXML
    protected void goToHome(ActionEvent event) {
        pageSwitch.switchToHome(event);
    }
    @FXML
    protected void goToBookList(ActionEvent event) {
        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageSwitch.switchToISCUser(event);
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageSwitch.switchToSettings(event);
    }

}
