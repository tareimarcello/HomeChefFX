package logic.viewcontroller.resultsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.HashMap;

public class ResultSearchViewControllerInterf2 extends ResultSearchViewController{


    public ResultSearchViewControllerInterf2(){
        pageSwitch = new PageMenu();
        chefList = ViewSetter.getInstance().getChefList();
        chefBeanMap = new HashMap<>();
        g1Index=2;
        g2Index=3;
        g3Index=4;
        g4Index=5;
    }

    @FXML
    protected void visit(ActionEvent event){
        pageSwitch.switchTo("visithomepagechef/interf2.fxml",event,"Homepage");
    }

}
