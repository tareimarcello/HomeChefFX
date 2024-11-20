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
import logic.beans.HomeChefBean;
import logic.exceptions.ChefNotAvailableException;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.model.Book;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

    public BookViewController(){
        pageSwitch = new PageMenu();
    }

    @FXML
    protected void backTo() {
        pageSwitch.backTo();
    }

    public void initialize(){
        ObservableList<String> comboItems = FXCollections.observableArrayList(
                "LUNCH",
                "DINNER"
        );
        whenBook.setItems(comboItems);
        bookDone.setOpacity(0.0);
        bookFail.setOpacity(0.0);
    }
    @FXML
    protected void confirmBook(){
        bookDone.setOpacity(0.0);
        bookFail.setOpacity(0.0);
        LocalDate bookDate = dateRes.getValue();
        LocalDate now = LocalDate.now();
        if(bookDate.isBefore(now) || bookDate.isEqual(now)){
            bookFail.setOpacity(1.0);
            bookFail.setText("The date is before or equal to the current date. ");
        }else {
            Instant instant = Instant.from(bookDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            String typeOfMeal = this.whenBook.getValue();
            String city = this.bookCity.getText();
            String place = this.bookPlace.getText();
            BookBean bean = new BookBean();
            bean.setVia(place);
            bean.setMeal(Book.BookMeal.valueOf(typeOfMeal));
            bean.setIdBook(-1);
            bean.setData(date);
            bean.setCitta(city);
            try {
                controller.saveBook(bean);
                bookDone.setOpacity(1.0);
            } catch (ConnectionException e) {
                Exceptions.exceptionConnectionOccurred();
            }catch(ChefNotAvailableException e){
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
}
