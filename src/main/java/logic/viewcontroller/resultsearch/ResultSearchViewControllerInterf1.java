package logic.viewcontroller.resultsearch;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.beans.ResultSearchBean;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.ArrayList;
import java.util.List;

public class ResultSearchViewControllerInterf1 {
    private PageMenu pageSwitch;
    private int lastIndexChef;
    private static final int MAXCHEFVIEWED = 4;
    private static final int G1INDEX = 11;
    private static final int G2INDEX = 12;
    private static final int G3INDEX = 13;
    private static final int G4INDEX = 14;
    private static final int SUBGROUPINDEX = 1;
    private static final int SPECIALIZEDINDEX = 0;
    private static final int RESTAURANTINDEX = 2;
    private static final int CHEFNAMEINDEX = 1;

    private static final List<ResultSearchBean> chefList = ViewSetter.getInstance().getChefList();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button loadNext;


    public ResultSearchViewControllerInterf1(){
        pageSwitch = new PageMenu();
    }

    public void initialize(){

        // Inizialize first 4 chef of the result list search
        lastIndexChef = 0;

        ObservableList<Node> children = anchorPane.getChildren();

        children.get(G1INDEX).setOpacity(0.0);
        children.get(G2INDEX).setOpacity(0.0);
        children.get(G3INDEX).setOpacity(0.0);
        children.get(G4INDEX).setOpacity(0.0);

        this.loadNext.setDisable(true);

        this.setNextFourChef();

        /*for (Node n : children) {
            System.out.println (n);
            System.out.println ("ID:"+n.getId());
            index++;
            System.out.println("Current index: "+index);
        }*/


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
    }
    @FXML
    protected void visit(ActionEvent event){
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
        while (index < 4 && lastIndexChef < chefList.size()) {

            ResultSearchBean resBean = chefList.get(lastIndexChef);
            Group current = (Group) anchorPane.getChildren().get(G1INDEX+index);
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
            this.loadNext.setDisable(false);
        else
            this.loadNext.setDisable(true);

    }

}
