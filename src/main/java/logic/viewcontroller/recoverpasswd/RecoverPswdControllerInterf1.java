package logic.viewcontroller.recoverpasswd;

import logic.pageswitch.Page;
import javafx.fxml.FXML;

public class RecoverPswdControllerInterf1 {



    @FXML
    protected void sendMail(){
        //to be implemented
    }


    @FXML
    protected void backToLogin(){
        Page pageSwitch=new Page();
        pageSwitch.backTo();
    }

}
