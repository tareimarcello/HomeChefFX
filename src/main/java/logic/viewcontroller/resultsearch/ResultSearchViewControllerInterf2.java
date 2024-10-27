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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSearchViewControllerInterf2 {
    private PageMenu pageSwitch;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button loadNext;
    @FXML
    private Button loadPrevious;
    private int lastIndexChef;
    private static final int MAXCHEFVIEWED = 4;
    private static final int G1INDEX = 2;
    private static final int G2INDEX = 3;
    private static final int G3INDEX = 4;
    private static final int G4INDEX = 5;
    private static final int SUBGROUPINDEX = 1;
    private static final int SPECIALIZEDINDEX = 0;
    private static final int RESTAURANTINDEX = 2;
    private static final int CHEFNAMEINDEX = 1;

    private final List<ResultSearchBean> chefList = ViewSetter.getInstance().getChefList();
    private final Map<String,ResultSearchBean> chefBeanMap = new HashMap<>();

    public void initialize(){

        // Inizialize first 4 chef of the result list search
        lastIndexChef = 0;
        resetGroupOpacity();
        this.loadNext.setVisible(false);
        this.loadPrevious.setVisible(false);


        this.setNextFourChef();
        ObservableList<Node> cList = this.anchorPane.getChildren();
        int i = 0;
        for (Node n : cList) {

            System.out.println(n);
            System.out.println("INDICE: "+i);

            i++;

        }
    }

    public ResultSearchViewControllerInterf2(){
        pageSwitch = new PageMenu();
    }
    @FXML
    protected void outputVal(){

    }
    @FXML
    protected void visit(ActionEvent event){
        pageSwitch.switchTo("visithomepagechef/interf2.fxml",event,"Homepage");
    }

    private void resetGroupOpacity(){

        ObservableList<Node> children = anchorPane.getChildren();

        children.get(G1INDEX).setOpacity(0.0);
        children.get(G2INDEX).setOpacity(0.0);
        children.get(G3INDEX).setOpacity(0.0);
        children.get(G4INDEX).setOpacity(0.0);
    }

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
}
