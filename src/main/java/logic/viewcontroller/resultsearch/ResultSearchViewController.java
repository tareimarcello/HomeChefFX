package logic.viewcontroller.resultsearch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.beans.HomeChefBean;
import logic.homechefutil.HomeChefUtil;
import logic.beans.ResultSearchBean;
import logic.pageswitch.PageMenu;
import logic.patterns.Setter;

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
    protected static final int SUBGROUPINDEX = 1;
    protected static final int SPECIALIZEDINDEX = 0;
    protected static final int RESTAURANTINDEX = 2;
    protected static final int CHEFNAMEINDEX = 1;

    protected List<ResultSearchBean> chefList;
    protected Map<String,ResultSearchBean> chefBeanMap;

    protected PageMenu pageSwitch;

    public void initialize(){

        // Inizialize first 4 chef of the result list search
        lastIndexChef = 0;
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.loadNext.setVisible(false);
        this.loadPrevious.setVisible(false);

        this.setNextFourChef();


    }

    @FXML
    protected void outputVal(ActionEvent event){

        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.setNextFourChef();

    }
    @FXML
    protected void outputValPrevious(ActionEvent event){

        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        lastIndexChef-=(MAXCHEFVIEWED+elementViewed);
        this.setNextFourChef();

    }
    protected void setNextFourChef(){

        int index = 0;
        while (index < MAXCHEFVIEWED && lastIndexChef < chefList.size()) {

            ResultSearchBean resBean = chefList.get(lastIndexChef);
            Group current = (Group) anchorPane.getChildren().get(g1Index+index);
            this.chefBeanMap.put(current.getId(),resBean);
            List<Text> textList=HomeChefUtil.getListGroup(current,SUBGROUPINDEX,SPECIALIZEDINDEX,CHEFNAMEINDEX,RESTAURANTINDEX);
            textList.get(0).setText(resBean.getBestDish());
            textList.get(1).setText(resBean.getNameChef());
            textList.get(2).setText(resBean.getRestaurant());
            current.setOpacity(1.0);
            index++;
            lastIndexChef++;
        }
        this.elementViewed=index;
        HomeChefUtil.disEnButtonNext(this.loadNext,lastIndexChef,chefList.size());
        HomeChefUtil.disEnButtonPrev(this.loadPrevious,lastIndexChef,MAXCHEFVIEWED);
    }

    protected void loadHcBean(ActionEvent event){
        Button clicked = (Button) event.getSource();
        Group parentGroup = (Group) clicked.getParent();
        ResultSearchBean rsb = this.chefBeanMap.get(parentGroup.getId());
        HomeChefBean hbvisit = new HomeChefBean();
        hbvisit.setRes(rsb.getRestaurant());
        hbvisit.setDish(rsb.getBestDish());
        hbvisit.setCity(rsb.getCity());
        hbvisit.setName(rsb.getNameChef());
        hbvisit.setId(rsb.getIdChef());

        Setter.setHcvisitbean(hbvisit);
    }
    protected abstract void visit(ActionEvent event);
}
