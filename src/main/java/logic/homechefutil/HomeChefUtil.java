package logic.homechefutil;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.HomeChefApplication;
import logic.beans.*;
import logic.dao.DAOChefImpl;
import logic.dao.DAOCustomerImpl;
import logic.dao.DAOUserImpl;
import logic.exceptions.ConnectionException;
import logic.model.Customer;
import logic.model.User;
import logic.patterns.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public static User getCustByID (long id) throws ConnectionException {
        DAOCustomerImpl userDao = new DAOCustomerImpl();
        return userDao.get(id);
    }

    public static User getChefById(long id) throws ConnectionException {
        DAOChefImpl userDao = new DAOChefImpl();
        return userDao.get(id);
    }


    public static void disEnButtonNext(Button butt, int index, int size){
        butt.setVisible(index < size);
    }

    public static void disEnButtonPrev(Button butt, int index, int size){
        butt.setVisible(index > size);
    }

    public static void linkButtonBarInterf2(AnchorPane buttonBar){
        if(Setter.getSessionParam().getUserType()== SessionParamBean.UserType.CUSTOMER) {
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
    public static List<Text> getListGroup(Group current,int subGroupIndex,int index1,int index2,int index3 ){
        List<Text> list = new ArrayList<>();
        Group subGroupBook = (Group) current.getChildren().get(subGroupIndex);
        ObservableList<Node> paramListBook = subGroupBook.getChildren();
        Text status = (Text)paramListBook.get(index1);
        Text nameChef = (Text)paramListBook.get(index2);
        Text bookDate = (Text)paramListBook.get(index3);
        list.add(status);
        list.add(nameChef);
        list.add(bookDate);
        return list;
    }
    public static List<String> setFormat(List<String> paramSearch){
        int i=0;
        for(String param: paramSearch) {
            while(param.endsWith(" ")){
                param = param.substring(0, param.length()-1);
            }
            paramSearch.set(i,param);
            i++;
        }
        return paramSearch;
    }

    public static List<String> setAp(List<String> paramSearch){
        String newparam ;
        int i=0;
        for(String param : paramSearch) {
            if(param.contains("'")){
                newparam = param.replace("'","''");
                paramSearch.set(i,newparam);
            }
            i++;
        }
        return paramSearch;
    }

    public static void changeNot() throws ConnectionException {
        DAOCustomerImpl dao = new DAOCustomerImpl();
        dao.setCustomerNot(Setter.getSessionParam().getCurrentUserId(),false);
        Setter.getSessionParam().setBookNot(false);
    }

}
