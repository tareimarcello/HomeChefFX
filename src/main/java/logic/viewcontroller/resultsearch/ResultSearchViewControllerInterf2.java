package logic.viewcontroller.resultsearch;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.HashMap;

public class ResultSearchViewControllerInterf2 extends ResultSearchViewController{
    private PageMenu pageSwitch;


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
        chefList = ViewSetter.getInstance().getChefList();
        chefBeanMap = new HashMap<>();
        g1Index=2;
        g2Index=3;
        g3Index=4;
        g4Index=5;
    }
    @FXML
    protected void outputVal(){
        this.resetGroupOpacity();
        this.setNextFourChef();
    }
    @FXML
    protected void visit(ActionEvent event){
        pageSwitch.switchTo("visithomepagechef/interf2.fxml",event,"Homepage");
    }

    private void resetGroupOpacity(){

        ObservableList<Node> children = anchorPane.getChildren();

        children.get(g1Index).setOpacity(0.0);
        children.get(g2Index).setOpacity(0.0);
        children.get(g3Index).setOpacity(0.0);
        children.get(g4Index).setOpacity(0.0);
    }
}
