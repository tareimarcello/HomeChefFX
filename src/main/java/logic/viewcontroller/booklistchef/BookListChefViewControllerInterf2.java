package logic.viewcontroller.booklistchef;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.BookListController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.Setter;
import logic.viewcontroller.booklist.BookListViewController;

import java.util.HashMap;

public class BookListChefViewControllerInterf2 extends BookListViewController {
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){
        try {
            controller.loadBookList();
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        initList();
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }

    public BookListChefViewControllerInterf2(){
        controller = new BookListController();
        pageSwitch = new PageMenu();
        super.bookList = Setter.getBookList();
        bookBeanMap = new HashMap<>();
        g1Index=12;
        g2Index=13;
        g3Index=14;
        g4Index=15;
    }
}
