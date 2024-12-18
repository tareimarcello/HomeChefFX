package logic.viewcontroller.booklist;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.HashMap;


public class BookLIstViewControllerInterf2 extends BookListViewController{
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){

        initList();
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }

    public BookLIstViewControllerInterf2(){
        pageSwitch = new PageMenu();
        super.bookList = ViewSetter.getBookList();
        bookBeanMap = new HashMap<>();
        g1Index=13;
        g2Index=14;
        g3Index=15;
        g4Index=16;
    }
}
