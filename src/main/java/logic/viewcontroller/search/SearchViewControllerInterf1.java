package logic.viewcontroller.search;

import javafx.scene.control.Button;
import logic.appcontroller.SearchController;
import logic.beans.SearchBean;
import logic.beans.SessionParamBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.NoResultFoundException;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.patterns.Setter;

public class SearchViewControllerInterf1 extends SearchViewController{
    private PageMenu pageSwitch;
    @FXML
    protected Button book;
    public SearchViewControllerInterf1(){
        pageSwitch=new PageMenu();
        controller = new SearchController();
    }

    public void initialize(){
        if(Setter.getSessionParam().getBookNot() && Setter.getSessionParam().getUserType()== SessionParamBean.UserType.CUSTOMER){
            book.setOpacity(1.0);
        }else{
            book.setOpacity(0.5);
        }
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
    @Override
    protected void search(ActionEvent event){
        errMsg.setOpacity(0.0);
        SearchBean searchBean = setBean();

        /* Invocazione back end recupero lista chef */


        try {
            controller.searchChefList(searchBean);
            pageSwitch.switchTo("resultsearch/interf1.fxml",event,"ResultSearch");
        } catch (ConnectionException e) {
           Exceptions.exceptionConnectionOccurred();
        }catch(NoResultFoundException ex){
            errMsg.setOpacity(1.0);
            errMsg.setText(ex.getMessage());
        }
    }

    @FXML
    protected void goToSettings(ActionEvent event){
        pageSwitch.switchToSettings(event);
    }

}
