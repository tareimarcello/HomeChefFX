package logic.viewcontroller.resultsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import logic.beans.HomeChefBean;
import logic.beans.ResultSearchBean;
import logic.beans.SessionParamBean;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;


import java.util.HashMap;

public class ResultSearchViewControllerInterf1 extends ResultSearchViewController{


    public ResultSearchViewControllerInterf1(){
        pageSwitch = new PageMenu();
        chefList = ViewSetter.getChefList();
        chefBeanMap = new HashMap<>();
        g1Index=10;
        g2Index=11;
        g3Index=12;
        g4Index=13;
    }

    @FXML
    protected void goToBook(ActionEvent event){
        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToHome(ActionEvent event){
        pageSwitch.switchToHome(event);
    }

    @FXML
    protected void visit(ActionEvent event){

        loadHcBean(event);
        pageSwitch.switchTo("visithomepagechef/interf1.fxml",event,"Homepage");
    }
    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }
    @FXML
    protected void goToISC(ActionEvent event){
        pageSwitch.switchToISCUser(event);
    }


}
