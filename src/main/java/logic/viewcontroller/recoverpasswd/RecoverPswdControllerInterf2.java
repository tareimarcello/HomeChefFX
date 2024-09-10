package logic.viewcontroller.recoverpasswd;

import logic.pageswitch.Page;
import javafx.fxml.FXML;

public class RecoverPswdControllerInterf2 {

    @FXML
    protected void sendMail(){

    }


    @FXML
    protected void backToLogin(){
        Page pageSwitch=new Page();
        pageSwitch.backTo();
    }
}
