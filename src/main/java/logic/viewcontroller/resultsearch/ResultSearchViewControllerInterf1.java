package logic.viewcontroller.resultsearch;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import logic.HomeChefUtil;
import logic.beans.HomeChefBean;
import logic.beans.ResultSearchBean;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;


import java.util.HashMap;

public class ResultSearchViewControllerInterf1 extends ResultSearchViewController{


    public ResultSearchViewControllerInterf1(){
        pageSwitch = new PageMenu();
        chefList = ViewSetter.getInstance().getChefList();
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

        Button clicked = (Button) event.getSource();
        Group parentGroup = (Group) clicked.getParent();
        ResultSearchBean rsb = this.chefBeanMap.get(parentGroup.getId());
        HomeChefBean hbvisit = new HomeChefBean();
        hbvisit.setRes(rsb.getRestaurant());
        hbvisit.setDish(rsb.getBestDish());
        hbvisit.setCity(rsb.getCity());
        hbvisit.setName(rsb.getNameChef());

        ViewSetter.getInstance().setHcvisitbean(hbvisit);
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
