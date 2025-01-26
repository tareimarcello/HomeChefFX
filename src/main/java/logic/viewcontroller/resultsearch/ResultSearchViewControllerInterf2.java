package logic.viewcontroller.resultsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.Setter;

import java.util.HashMap;

public class ResultSearchViewControllerInterf2 extends ResultSearchViewController{


    public ResultSearchViewControllerInterf2(){
        pageSwitch = new PageMenu();
        chefList = Setter.getChefList();
        chefBeanMap = new HashMap<>();
        g1Index=2;
        g2Index=3;
        g3Index=4;
        g4Index=5;
    }

    public void initialize(){

       initResSearch();
    }

    @FXML
    @Override
    protected void visit(ActionEvent event){
        loadHcBean(event);
        pageSwitch.switchTo("visithomepagechef/interf2.fxml",event,"Homepage");
    }

}
