package logic.viewcontroller.initialsearchandchat;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import logic.beans.ISCBean;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;
import java.util.HashMap;


public class InitialSearchAndChatViewControllerInterf1 extends InitialSearchAndChatViewController{

    public void initialize(){


        subGroupMap.put(0,this.group1);
        subGroupMap.put(1,this.group2);
        subGroupMap.put(2,this.group3);
        subGroupMap.put(3,this.group4);

        HomeChefUtil.resetGroupOpacity(this.anchorPane,this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.setNextFourChat();
    }

    public InitialSearchAndChatViewControllerInterf1() {
        pageswitch = new PageMenu();
        iscBeanMap = new HashMap<>();
        subGroupMap = new HashMap<>();
        chatList = ViewSetter.getInstance().getChatList();
        g1Index=13;
        g2Index=14;
        g3Index=15;
        g4Index=16;
        this.lastIndexChat=0;
    }
    @FXML
    protected void visit(ActionEvent event) {
        //parte di controllo
        pageswitch.switchTo("visithomepagechef/interf1.fxml",event,"Visit");
    }
    @FXML
    protected void touchChat(ActionEvent event){

        this.openChatToView(event);
        pageswitch.switchTo("chatuser/interf1.fxml",event,"Chat");
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        pageswitch.switchToSettings(event);
    }
    @FXML
    protected void goToISC(ActionEvent event) {
        pageswitch.switchToISCUser(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) {
        pageswitch.switchToHome(event);
    }
    @FXML
    protected void searchMessage(){
        //controllore per cercare messaggio tra le chat
    }
    @FXML
    protected void outputValChat(){
        //controllore per caricare altre chat
    }
    @FXML
    protected  void goToBook(ActionEvent event) {
        //metodo che va alle prenotazioni pendenti
        pageswitch.switchToBookList(event);
    }
    @FXML
    protected void touchChatChef(ActionEvent event){

        this.openChatToView(event);
        pageswitch.switchTo("chatchef/interf1.fxml",event,"Chat");
    }

    @FXML
    protected void goToSettingsChef(ActionEvent event) {
        pageswitch.switchToSettingsChef(event);
    }
    @FXML
    protected void goToISCChef(ActionEvent event) {
        pageswitch.switchToISCChef(event);
    }
    @FXML
    protected  void goToBookListChef(ActionEvent event) {
        //metodo che va alle prenotazioni pendenti
        pageswitch.switchToBookListChef(event);
    }
    @FXML
    protected void goToHomeChef(ActionEvent event){
        pageswitch.switchToHomeChef(event);
    }
    @FXML
    protected void outputValChatPrevious(){
        //to be implemented
    }

    private void openChatToView(ActionEvent event){

        Button clicked = (Button)event.getSource();
        Group parent = (Group) clicked.getParent();
        ISCBean selected = this.iscBeanMap.get(parent.getId());
        ViewSetter.getInstance().setOpenChat(selected);

    }

}
