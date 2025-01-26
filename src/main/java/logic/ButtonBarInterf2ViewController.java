package logic;

import javafx.scene.control.Button;
import logic.appcontroller.ISCController;
import logic.beans.IsHomeVisitBean;
import logic.beans.SessionParamBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.patterns.Setter;

public class ButtonBarInterf2ViewController {
    private PageMenu pageSwitch;
    @FXML
    protected Button book;
    public ButtonBarInterf2ViewController(){
        pageSwitch=new PageMenu();
    }

    public void initialize(){
        if(Setter.getSessionParam().getBookNot() && Setter.getSessionParam().getUserType()== SessionParamBean.UserType.CUSTOMER){
            book.setOpacity(1.0);
        }else{
            book.setOpacity(0.5);
        }
    }

    @FXML
    protected void goToIsc(ActionEvent actionEvent) {
        ISCController controller = new ISCController();
        try {
            Setter.setChatList(controller.getISCToChef());
            if(Setter.getIsHomeVisitBean()==null){
                IsHomeVisitBean bean = new IsHomeVisitBean();
                bean.setHome(false);
                Setter.setIsHomeVisitBean(bean);
            }else{
                Setter.getIsHomeVisitBean().setHome(false);
            }
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        pageSwitch.switchTo("chatuser/interf2.fxml",actionEvent,"Search and Chat");
    }
    @FXML
    protected void goToSettings(ActionEvent actionEvent) {
        pageSwitch.switchToSettings(actionEvent);
    }
    @FXML
    protected void goToHome(ActionEvent actionEvent) {
        pageSwitch.switchToHome(actionEvent);
    }
    @FXML
    protected void goToBookList(ActionEvent actionEvent) {
        try {
            HomeChefUtil.changeNot();
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        pageSwitch.switchToBookList(actionEvent);
    }
    @FXML
    protected void goToIscChef(ActionEvent actionEvent) {
        ISCController controller = new ISCController();
        try {
            Setter.setChatList(controller.getISCToUser());
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        pageSwitch.switchTo("chatchef/interf2.fxml",actionEvent,"Search and Chat");
    }
    @FXML
    protected void goToSettingsChef(ActionEvent actionEvent) {
        pageSwitch.switchToSettingsChef(actionEvent);
    }
    @FXML
    protected void goToHomeChef(ActionEvent actionEvent) {
        pageSwitch.switchToHomeChef(actionEvent);
    }
    @FXML
    protected void goToBookListChef(ActionEvent actionEvent) {
        pageSwitch.switchToChefBookList(actionEvent);
    }
}
