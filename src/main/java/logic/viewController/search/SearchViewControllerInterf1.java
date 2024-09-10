package logic.viewController.search;

import logic.pageSwitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchViewControllerInterf1 {
    private PageMenu pageSwitch;
    @FXML
    private TextField chefName;
    @FXML
    private TextField eatName;

    public SearchViewControllerInterf1(){
        pageSwitch=new PageMenu();
    }

    @FXML
    protected void goToBook(){



    }
    @FXML
    protected void goToHome(){



    }

    @FXML
    protected void search(){

    }

    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }

    @FXML
    protected void goBack(){
        pageSwitch.backTo();
    }



}
