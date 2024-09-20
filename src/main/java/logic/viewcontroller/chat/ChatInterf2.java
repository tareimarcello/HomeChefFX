package logic.viewcontroller.chat;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;

public class ChatInterf2 extends ChatViewController{
    private PageMenu pageswitch;
    @FXML
    private Text chatUserName;

    public ChatInterf2() {
        pageswitch = new PageMenu();
        graphics = new Decorator(false);
    }

    public void initialize() {
        //metti nome giusto sopra la chat
    }

}
