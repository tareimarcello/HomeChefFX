package logic.viewcontroller.initialsearchandchat;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.appcontroller.ISCController;
import logic.beans.HomeChefBean;
import logic.beans.ReturnChefBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.homechefutil.HomeChefUtil;
import logic.beans.ISCBean;
import logic.model.Message;
import logic.pageswitch.PageMenu;
import logic.patterns.Updater;
import logic.patterns.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  abstract class  InitialSearchAndChatViewController implements Updater {
    protected PageMenu pageswitch;
    protected List<ISCBean> chatList;
    protected Map<String, ISCBean> iscBeanMap;
    protected Map<Integer, Group> subGroupMap;
    protected static final Map<Long,Group> keyChatMap = new HashMap<>();
    protected   int g1Index;
    protected   int g2Index ;
    protected   int g3Index;
    protected   int g4Index;
    @FXML
    protected AnchorPane anchorPane;
    @FXML
    protected Button loadNext;
    @FXML
    protected Button loadPrevious;
    @FXML
    protected Group group1;
    @FXML
    protected Group group2;
    @FXML
    protected Group group3;
    @FXML
    protected Group group4;

    protected int lastIndexChat;
    protected int elementViewed;
    protected static final int MAXCHATVIEWED = 4;

    private static final int CHATNAMEINDEX = 1;
    private static final int LASTMSGINDEX = 0;




    @FXML
    protected void outputValChat(ActionEvent event){

        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.setNextFourChat();

    }
    @FXML
    protected void outputValChatPrevious(ActionEvent event){

        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        lastIndexChat-=(MAXCHATVIEWED+elementViewed);
        this.setNextFourChat();

    }
    protected void setNextFourChat(){

        int index = 0;
        while (index < MAXCHATVIEWED && lastIndexChat < chatList.size()) {
            ISCBean resBean = chatList.get(lastIndexChat);
            Group current = (Group) anchorPane.getChildren().get(g1Index+index);
            this.iscBeanMap.put(current.getId(),resBean);
            Group subGroup =  subGroupMap.get(index);
            keyChatMap.put(resBean.getChat().getId(), subGroup);
            ObservableList<Node> paramList = subGroup.getChildren();
            Text lastMsg = (Text)paramList.get(LASTMSGINDEX);
            Text nameChat = (Text)paramList.get(CHATNAMEINDEX);

            lastMsg.setText(resBean.getChatMessages().getLast().getText());
            nameChat.setText(resBean.getDestUser().getName()+" "+resBean.getDestUser().getSurname());

            current.setOpacity(1.0);
            index++;
            lastIndexChat++;
        }
        this.elementViewed=index;
        HomeChefUtil.disEnButtonNext(this.loadNext, lastIndexChat,chatList.size());
        HomeChefUtil.disEnButtonPrev(this.loadPrevious, lastIndexChat,MAXCHATVIEWED);

    }

    @Override
    public void update(){
        ISCController controller = new ISCController();
        ISCBean currentChatBean = Setter.getOpenChat();
        try {
            Message msgLast = controller.getLastChatMessage(currentChatBean);
            currentChatBean.getChatMessages().add(msgLast);
            Group subGroupChatSelected = keyChatMap.get(currentChatBean.getChat().getId());
            ObservableList<Node> paramList = subGroupChatSelected.getChildren();
            Text lastMsg = (Text)paramList.get(LASTMSGINDEX);
            lastMsg.setText(msgLast.getText());
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }

    }

    protected void loadHcBeanVisitChat(ActionEvent event){
        Button clicked = (Button) event.getSource();
        Group parentGroup = (Group) clicked.getParent();
        ISCBean isc = this.iscBeanMap.get(parentGroup.getId());
        ISCController controller = new ISCController();
        ReturnChefBean bean = null;
        try {
            bean = controller.getChefVisit(isc);
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        HomeChefBean hbvisit = new HomeChefBean();
        assert bean != null;
        hbvisit.setRes((String) bean.getRetChef().getInfo(0));
        hbvisit.setDish((String) bean.getRetChef().getInfo(1));
        hbvisit.setCity((String) bean.getRetChef().getInfo(2));
        hbvisit.setName(bean.getRetChef().getName() + " " + bean.getRetChef().getSurname());
        hbvisit.setId(bean.getRetChef().getID());

        Setter.setHcvisitbean(hbvisit);
    }
    protected abstract void touchChat(ActionEvent event);
    protected abstract void touchChatChef(ActionEvent event);
}
