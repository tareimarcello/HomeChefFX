package com.example.homechef.viewController.signupchef;

import com.example.homechef.pageSwitch.Page;
import javafx.fxml.FXML;

public class SignupChefViewControllerInterf1 {


    @FXML
    protected void goToLogin(){

        Page pageSwitch=new Page();
        pageSwitch.backTo();

    }


    @FXML
    protected void save(){

        // Controllo valori
        // In caso di errore set opacity label
        // If ok salvataggio bean

    }
}
