package logic.viewcontroller.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;

public class ChatInterf1 extends ChatViewController{
    private PageMenu pageswitch;
    @FXML
    private Text chefName;

    public ChatInterf1() {
        pageswitch = new PageMenu();
        graphics = new Decorator(true);
    }

    public void initialize() {
        //metti nome giusto sopra la chat
    }

    @FXML
    protected void goBack() {
        pageswitch.backTo();
    }

    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHome(event);
    }
    @FXML
    protected void goToBook(ActionEvent event) {
        pageswitch.switchToBookList(event);
    }
    @FXML
    protected void goToHomeChef(ActionEvent event){
        pageswitch.switchToHomeChef(event);
    }
    @FXML
    protected void goToBookListChef(ActionEvent event){

    }
}
