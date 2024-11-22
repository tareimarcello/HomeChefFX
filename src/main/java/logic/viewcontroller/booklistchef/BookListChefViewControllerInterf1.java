package logic.viewcontroller.booklistchef;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;
import logic.viewcontroller.booklist.BookListViewController;

import java.util.HashMap;

public class BookListChefViewControllerInterf1 extends BookListViewController {

    public void initialize() {
        lastIndexBook = 0;
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.loadNext.setVisible(false);
        this.loadPrevious.setVisible(false);
        this.setNextFourBook();
    }

    public BookListChefViewControllerInterf1(){
        pageSwitch = new PageMenu();
        super.bookList = ViewSetter.getBookList();
        bookBeanMap = new HashMap<>();
        g1Index=9;
        g2Index=10;
        g3Index=11;
        g4Index=12;

    }


    @FXML
    protected void goToHomeChef(ActionEvent event) {
        pageSwitch.switchToHomeChef(event);
    }
    @FXML
    protected void goToBookListChef(ActionEvent event) {
        pageSwitch.switchToChefBookList(event);
    }
    @FXML
    protected void goToISCChef(ActionEvent event) {
        pageSwitch.switchToISCChef(event);
    }
    @FXML
    protected void goToSettingsChef(ActionEvent event) {
        pageSwitch.switchToSettingsChef(event);
    }

}
