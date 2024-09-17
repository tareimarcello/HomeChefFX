package logic.viewcontroller.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;

public class ChatInterf1 {
    private PageMenu pageswitch;
    @FXML
    private Text chefName;
    @FXML
    private TextArea inputmsg;
    @FXML
    private AnchorPane message;
    @FXML
    private ScrollPane scrollpane;
    protected Decorator graphics;
    protected  boolean initializated;

    public ChatInterf1() {
        pageswitch = new PageMenu();
        graphics = new Decorator(true);
        initializated = false;
    }

    public void initialize() {
        //metti nome giusto sopra la chat
    }

    @FXML
    protected void goBack() {
        pageswitch.backTo();
    }

    @FXML
    protected void sendMsg() {
        recivemsgArr();
        //parte di controllo da aggiungere
    }

    public void recivemsgArr() {
        String messageTry = inputmsg.getText();     //prova per vedere se funziona la chat senza controller applicativo altra
                                                    //parte di controllo da aggiungere
        Label textmsg;
        graphics.setText(messageTry);
        textmsg = graphics.getMessageSended();
        message.getChildren().add(textmsg);
        message.setPrefHeight(graphics.getAumenta());
        scrollpane.setVvalue(1.0);
        initializated=true;
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHome(event);
    }
    @FXML
    protected void goToBook(){

    }
}
