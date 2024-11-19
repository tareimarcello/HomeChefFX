package logic.viewcontroller.book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.appcontroller.BookController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;


public class BookViewControllerInterf1 extends BookViewController{

    public BookViewControllerInterf1(){
        pageSwitch = new PageMenu();
    }


    @FXML
    protected void goToSettings(ActionEvent event) {
        pageSwitch.switchToSettings(event);
    }
    @FXML
    protected  void goToBook(ActionEvent event) {
        BookController controller = new BookController();
        try {
            controller.loadBookList();
        } catch (ConnectionException e) {

            Exceptions.exceptionConnectionOccurred();
        }
        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        pageSwitch.switchToHome(event);
    }
}
