package logic.homechefutil;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.HomeChefApplication;
import logic.beans.*;
import logic.dao.DAOUserImpl;
import logic.exceptions.ConnectionException;
import logic.model.User;
import logic.patterns.ViewSetter;

import java.io.IOException;
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

    public static User getUserByID (long id) throws ConnectionException {
        DAOUserImpl userDao = new DAOUserImpl();
        return userDao.get(id);
    }


    public static void disEnButtonNext(Button butt, int index, int size){
        butt.setVisible(index < size);
    }

    public static void disEnButtonPrev(Button butt, int index, int size){
        butt.setVisible(index > size);
    }

    public static void linkButtonBarInterf2(AnchorPane buttonBar){
        if(ViewSetter.getInstance().getSessionParam().getUserType()== SessionParamBean.UserType.CUSTOMER) {
            try {
                buttonBar.getChildren().removeAll(buttonBar.getChildren());
                buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml")));
            } catch (IOException e) {
                buttonBar.getChildren().removeAll(buttonBar.getChildren());
            }
        }else{
            try {
                buttonBar.getChildren().removeAll(buttonBar.getChildren());
                buttonBar.getChildren().add((Node) FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarChefInterf2.fxml")));
            } catch (IOException e) {
                buttonBar.getChildren().removeAll(buttonBar.getChildren());
            }
        }
    }
}
