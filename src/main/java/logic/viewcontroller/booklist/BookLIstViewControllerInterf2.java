package logic.viewcontroller.booklist;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import logic.homechefutil.HomeChefUtil;


public class BookLIstViewControllerInterf2 extends BookListViewController{
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }
}
