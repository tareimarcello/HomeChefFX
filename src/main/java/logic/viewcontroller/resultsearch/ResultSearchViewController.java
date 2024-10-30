package logic.viewcontroller.resultsearch;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.HomeChefUtil;
import logic.beans.ResultSearchBean;
import logic.pageswitch.PageMenu;

import java.util.List;
import java.util.Map;

public abstract class ResultSearchViewController {
    @FXML
    protected AnchorPane anchorPane;
    @FXML
    protected Button loadNext;
    @FXML
    protected Button loadPrevious;
    protected int lastIndexChef;
    protected int elementViewed;
    protected static final int MAXCHEFVIEWED = 4;
    protected   int g1Index;
    protected   int g2Index;
    protected   int g3Index;
    protected   int g4Index;
    //private static final int GROUPBUTTONINDEX = 0;
    protected static final int SUBGROUPINDEX = 1;
    protected static final int SPECIALIZEDINDEX = 0;
    protected static final int RESTAURANTINDEX = 2;
    protected static final int CHEFNAMEINDEX = 1;

    protected List<ResultSearchBean> chefList;
    protected Map<String,ResultSearchBean> chefBeanMap;

    protected PageMenu pageSwitch;
    protected final HomeChefUtil util = new HomeChefUtil();

    public void initialize(){

        // Inizialize first 4 chef of the result list search
        lastIndexChef = 0;
        //resetGroupOpacity();
        util.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.loadNext.setVisible(false);
        this.loadPrevious.setVisible(false);

        this.setNextFourChef();


    }

    @FXML
    protected void outputVal(ActionEvent event){

        util.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.setNextFourChef();

    }
    @FXML
    protected void outputValPrevious(ActionEvent event){

        util.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        lastIndexChef-=(MAXCHEFVIEWED+elementViewed);
        this.setNextFourChef();

    }
    protected void setNextFourChef(){

        int index = 0;
        while (index < MAXCHEFVIEWED && lastIndexChef < chefList.size()) {

            ResultSearchBean resBean = chefList.get(lastIndexChef);
            Group current = (Group) anchorPane.getChildren().get(g1Index+index);
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
        this.elementViewed=index;
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
