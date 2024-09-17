package logic.viewcontroller.book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;

public class BookViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private Text bookDone;
    @FXML
    private Text bookFail;
    @FXML
    private DatePicker dateRes;

    public BookViewControllerInterf1(){
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
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageSwitch.switchToSettings(event);
    }
    @FXML
    protected  void goToBook(){

    }
    @FXML
    protected void goToHome(){

    }
}
