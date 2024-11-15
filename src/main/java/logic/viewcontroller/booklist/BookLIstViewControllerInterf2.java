package logic.viewcontroller.booklist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.homechefutil.HomeChefUtil;

import java.io.IOException;

public class BookLIstViewControllerInterf2 extends BookListViewController{
    @FXML
    private AnchorPane buttonBar;

    public void initialize(){
        HomeChefUtil.linkButtonBarInterf2(buttonBar);
    }
}
