package logic.viewcontroller.search;

import logic.appcontroller.ISCController;
import logic.appcontroller.SearchController;
import logic.beans.SearchBean;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.patterns.ViewSetter;

public class SearchViewControllerInterf1 extends SearchViewController{
    private PageMenu pageSwitch;

    public SearchViewControllerInterf1(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToISC(ActionEvent event){

        ISCController controller = new ISCController();
        ViewSetter.getInstance().setChatList(controller.getISCToChef());

        pageSwitch.switchToISCUser(event);
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
    protected void search(ActionEvent event){

        SearchBean searchBean = setBean();

        /* Invocazione back end recupero lista chef */

        SearchController controller = new SearchController();

        controller.searchChefList(searchBean);

        pageSwitch.switchTo("resultsearch/interf1.fxml",event,"ResultSearch");
    }

    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }

}
