package com.example.homechef.viewController.recoverpasswd;

import com.example.homechef.pageSwitch.Page;
import javafx.fxml.FXML;

public class RecoverPswdControllerInterf1 {



    @FXML
    protected void sendMail(){

    }


    @FXML
    protected void backToLogin(){
        Page pageSwitch=new Page();
        pageSwitch.backTo();
    }

}
