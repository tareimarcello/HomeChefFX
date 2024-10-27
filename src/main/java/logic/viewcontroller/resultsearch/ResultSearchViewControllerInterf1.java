package logic.viewcontroller.resultsearch;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.beans.HomeChefBean;
import logic.beans.ResultSearchBean;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSearchViewControllerInterf1 extends ResultSearchViewController{
    private PageMenu pageSwitch;

    public ResultSearchViewControllerInterf1(){
        pageSwitch = new PageMenu();
        chefList = ViewSetter.getInstance().getChefList();
        chefBeanMap = new HashMap<>();
        g1Index=10;
        g2Index=11;
        g3Index=12;
        g4Index=13;
    }

    public void initialize(){

        // Inizialize first 4 chef of the result list search
        lastIndexChef = 0;
        resetGroupOpacity();
        this.loadNext.setVisible(false);
        this.loadPrevious.setVisible(false);


        this.setNextFourChef();
        /*
      ObservableList<Node> cList = this.anchorPane.getChildren();
        int i = 0;
        for (Node n : cList) {

            System.out.println(n);
            System.out.println("INDICE: "+i);

            i++;

        }
         */



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
    protected void outputVal(ActionEvent event){

        this.resetGroupOpacity();
        this.setNextFourChef();

    }
    @FXML
    protected void outputValPrevious(ActionEvent event){

        this.resetGroupOpacity();
        this.lastIndexChef-=(MAXCHEFVIEWED+1);
        this.setNextFourChef();

    }
    @FXML
    protected void visit(ActionEvent event){

        Button clicked = (Button) event.getSource();
        Group parentGroup = (Group) clicked.getParent();
       /* Group subGroup = (Group) parentGroup.getChildren().get(SUBGROUPINDEX);
        ObservableList<Node> paramList = subGroup.getChildren();
        Text specialized = (Text)paramList.get(SPECIALIZEDINDEX);
        Text nameChef = (Text)paramList.get(CHEFNAMEINDEX);
        Text restaurant = (Text)paramList.get(RESTAURANTINDEX);*/
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


    /**
     * this method reset the opacity of the main groups of the view
     *
     */
    private void resetGroupOpacity(){

        ObservableList<Node> children = anchorPane.getChildren();

        children.get(g1Index).setOpacity(0.0);
        children.get(g2Index).setOpacity(0.0);
        children.get(g3Index).setOpacity(0.0);
        children.get(g4Index).setOpacity(0.0);
    }

   /* private void setMapKey (){

        String key = ((Group)anchorPane.getChildren().get(G1INDEX)).getId();
        this.chefBeanMap.put(key,null);
        key = ((Group)anchorPane.getChildren().get(G2INDEX)).getId();
        this.chefBeanMap.put(key,null);
        key = ((Group)anchorPane.getChildren().get(G3INDEX)).getId();
        this.chefBeanMap.put(key,null);
        key = ((Group)anchorPane.getChildren().get(G4INDEX)).getId();
        this.chefBeanMap.put(key,null);
    }*/

}
