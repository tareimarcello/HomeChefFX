package logic.viewcontroller.book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.appcontroller.BookController;
import logic.beans.BookBean;
import logic.beans.BookListBean;
import logic.exceptions.ChefNotAvailableException;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.model.Book;
import logic.pageswitch.PageMenu;


public class BookViewController {
    protected static final BookController controller = new BookController();
    protected PageMenu pageSwitch;
    @FXML
    protected Text bookDone;
    @FXML
    protected Text bookFail;
    @FXML
    protected DatePicker dateRes;
    @FXML
    protected TextField bookPlace;
    @FXML
    protected TextField bookCity;
    @FXML
    protected ComboBox<String> whenBook;

    public BookViewController() {
        pageSwitch = new PageMenu();
    }

    @FXML
    protected void backTo() {
        pageSwitch.backTo();
    }

    public void initialize() {
        ObservableList<String> comboItems = FXCollections.observableArrayList(
                "LUNCH",
                "DINNER"
        );
        whenBook.setItems(comboItems);
        bookDone.setOpacity(0.0);
        bookFail.setOpacity(0.0);
    }

    @FXML
    protected void confirmBook() {
        bookDone.setOpacity(0.0);
        bookFail.setOpacity(0.0);
        BookBean bean = new BookBean();
        if (!bean.setDataIn(dateRes.getValue())) {
            bookFail.setOpacity(1.0);
            bookFail.setText("The field date is empty or date is equal or before today. ");
        } else if (!bean.setCityIn(bookCity.getText().toUpperCase())) {
            bookFail.setOpacity(1.0);
            bookFail.setText("The field city is empty. ");
        } else if (whenBook.getValue() == null) {
            bookFail.setOpacity(1.0);
            bookFail.setText("The field meal is empty. ");
        } else if (!bean.setViaIn(bookPlace.getText().toUpperCase())) {
            bookFail.setOpacity(1.0);
            bookFail.setText("The field route is empty. ");
        } else {
            bean.setMeal(Book.BookMeal.valueOf(whenBook.getValue()));
            try {
                controller.saveBook(bean);
                bookDone.setOpacity(1.0);
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            } catch (ChefNotAvailableException e) {
                bookFail.setOpacity(1.0);
                bookFail.setText(e.getMessage());
            }
        }
    }

    @FXML
    protected void goToSettings(ActionEvent event) {
        pageSwitch.switchToSettings(event);
    }
    @FXML
    protected  void goToBook(ActionEvent event) {
        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        pageSwitch.switchToHome(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageSwitch.switchToISCUser(event);
    }
}
