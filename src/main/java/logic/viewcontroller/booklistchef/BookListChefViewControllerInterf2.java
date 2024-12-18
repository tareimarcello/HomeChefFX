package logic.viewcontroller.booklistchef;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;
import logic.viewcontroller.booklist.BookListViewController;

import java.util.HashMap;

public class BookListChefViewControllerInterf2 extends BookListViewController {
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){
        initList();
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }

    public BookListChefViewControllerInterf2(){
        pageSwitch = new PageMenu();
        super.bookList = ViewSetter.getBookList();
        bookBeanMap = new HashMap<>();
        g1Index=12;
        g2Index=13;
        g3Index=14;
        g4Index=15;
    }
}
