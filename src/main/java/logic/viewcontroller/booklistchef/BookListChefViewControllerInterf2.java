package logic.viewcontroller.booklistchef;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import logic.homechefutil.HomeChefUtil;
import logic.viewcontroller.booklist.BookListViewController;

public class BookListChefViewControllerInterf2 extends BookListViewController {
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }
}
