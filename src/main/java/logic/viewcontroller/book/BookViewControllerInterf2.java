package logic.viewcontroller.book;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;

public class BookViewControllerInterf2 {
    private PageMenu pageSwitch;
    @FXML
    private Text bookDone;
    @FXML
    private Text bookFail;
    @FXML
    private DatePicker dateRes;
    @FXML
    private TextField bookPlace;
    @FXML
    private ComboBox<String> whenBook;

    public BookViewControllerInterf2(){
        pageSwitch = new PageMenu();
    }

    public void initialize(){
        bookDone.setOpacity(0.0);
        bookFail.setOpacity(0.0);
    }

    @FXML
    protected void backTo() {
        pageSwitch.backTo();
    }
}
