package logic.viewcontroller.search;

import logic.appcontroller.SearchController;
import logic.beans.SearchBean;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private TextField chefName;
    @FXML
    private TextField eatName;
    @FXML
    private TextField cityChef;

    public SearchViewControllerInterf1(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToISC(ActionEvent event){
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

        SearchBean searchBean = new SearchBean();
        searchBean.setChefCity(this.cityChef.getText().toUpperCase());
        searchBean.setChefName(this.chefName.getText().toUpperCase());
        searchBean.setChefBestDish(this.eatName.getText().toUpperCase());

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
