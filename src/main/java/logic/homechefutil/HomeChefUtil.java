package logic.homechefutil;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.beans.HomeChefBean;
import logic.beans.ResultSearchBean;
import logic.dao.DAOUserImpl;
import logic.model.User;
import logic.patterns.ViewSetter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeChefUtil {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";


    private HomeChefUtil(){
    }


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

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static User getUserByID (long id) throws Exception {
        DAOUserImpl userDao = new DAOUserImpl();
        return userDao.get(id);
    }


    public static void disEnButtonNext(Button butt, int index, int size){
        butt.setVisible(index < size);
    }

    public static void disEnButtonPrev(Button butt, int index, int size){
        butt.setVisible(index > size);
    }

}
