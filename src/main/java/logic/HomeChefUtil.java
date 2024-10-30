package logic;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import logic.dao.DAOUserImpl;
import logic.model.User;

public class HomeChefUtil {


    /**
            * this method reset the opacity of the main groups of the view
     *
             */
    public static void resetGroupOpacity(AnchorPane anchorPane, int g1Index, int g2Index, int g3Index, int g4Index){

        ObservableList<Node> children = anchorPane.getChildren();

        children.get(g1Index).setOpacity(0.0);
        children.get(g2Index).setOpacity(0.0);
        children.get(g3Index).setOpacity(0.0);
        children.get(g4Index).setOpacity(0.0);
    }

    public static User getUserByID (long id) {
        DAOUserImpl userDao = new DAOUserImpl();
        return userDao.get(id);
    }

}