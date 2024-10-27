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

public class ResultSearchViewControllerInterf1{
    private PageMenu pageSwitch;
    private int lastIndexChef;
    private static final int MAXCHEFVIEWED = 4;
    private static final int G1INDEX = 10;
    private static final int G2INDEX = 11;
    private static final int G3INDEX = 12;
    private static final int G4INDEX = 13;
    //private static final int GROUPBUTTONINDEX = 0;
    private static final int SUBGROUPINDEX = 1;
    private static final int SPECIALIZEDINDEX = 0;
    private static final int RESTAURANTINDEX = 2;
    private static final int CHEFNAMEINDEX = 1;

    private final List<ResultSearchBean> chefList = ViewSetter.getInstance().getChefList();
    private final Map<String,ResultSearchBean> chefBeanMap = new HashMap<>();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button loadNext;

    @FXML
    private Button loadPrevious;


    public ResultSearchViewControllerInterf1(){
        pageSwitch = new PageMenu();
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
     * Populate next four chef from the list result of the search
     */
    private void setNextFourChef(){

        int index = 0;
        while (index < MAXCHEFVIEWED && lastIndexChef < chefList.size()) {

            ResultSearchBean resBean = chefList.get(lastIndexChef);
            Group current = (Group) anchorPane.getChildren().get(G1INDEX+index);
            this.chefBeanMap.put(current.getId(),resBean);
            Group subGroup = (Group) current.getChildren().get(SUBGROUPINDEX);
            ObservableList<Node> paramList = subGroup.getChildren();
            Text specialized = (Text)paramList.get(SPECIALIZEDINDEX);
            Text nameChef = (Text)paramList.get(CHEFNAMEINDEX);
            Text restaurant = (Text)paramList.get(RESTAURANTINDEX);
            specialized.setText(resBean.getBestDish());
            nameChef.setText(resBean.getNameChef());
            restaurant.setText(resBean.getRestaurant());
            current.setOpacity(1.0);
            index++;
            lastIndexChef++;
        }

        if (lastIndexChef<chefList.size())
            this.loadNext.setVisible(true);
        else
            this.loadNext.setVisible(false);

        if (lastIndexChef>MAXCHEFVIEWED)
            this.loadPrevious.setVisible(true);
        else
            this.loadPrevious.setVisible(false);

    }

    /**
     * this method reset the opacity of the main groups of the view
     *
     */
    private void resetGroupOpacity(){

        ObservableList<Node> children = anchorPane.getChildren();

        children.get(G1INDEX).setOpacity(0.0);
        children.get(G2INDEX).setOpacity(0.0);
        children.get(G3INDEX).setOpacity(0.0);
        children.get(G4INDEX).setOpacity(0.0);
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
