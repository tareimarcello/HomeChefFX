package logic.viewcontroller.booklist;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.HashMap;


public class BookListViewControllerInterf1 extends BookListViewController{


    public BookListViewControllerInterf1(){
        pageSwitch = new PageMenu();
        super.bookList = ViewSetter.getBookList();
        bookBeanMap = new HashMap<>();
        g1Index=10;
        g2Index=11;
        g3Index=12;
        g4Index=13;

    }


    public void initialize(){

        // Inizialize first 4 chef of the result list search
        lastIndexBook = 0;
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.loadNext.setVisible(false);
        this.loadPrevious.setVisible(false);

        this.setNextFourBook();

    }

    @FXML
    protected void goToHome(ActionEvent event) {
        pageSwitch.switchToHome(event);
    }
    @FXML
    protected void goToBookList(ActionEvent event) {

        pageSwitch.switchToBookList(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageSwitch.switchToISCUser(event);
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageSwitch.switchToSettings(event);
    }

}
