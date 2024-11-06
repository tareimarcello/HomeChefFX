package logic.viewcontroller.book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;

public abstract  class BookViewController {
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
    protected ComboBox<String> whenBook;

    @FXML
    protected void backTo() {
        pageSwitch.backTo();
    }

    public void initialize(){
        ObservableList<String> comboItems = FXCollections.observableArrayList(
                "Lunch",
                "Dinner"
        );
        whenBook.setItems(comboItems);
        bookDone.setOpacity(0.0);
        bookFail.setOpacity(0.0);
    }
}
