package logic.viewcontroller.initialsearchandchat;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.homechefutil.HomeChefUtil;
import logic.beans.ISCBean;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.util.List;
import java.util.Map;

public  abstract class  InitialSearchAndChatViewController {

    protected PageMenu pageswitch;
    protected List<ISCBean> chatList;
    protected Map<String, ISCBean> iscBeanMap;
    protected Map<Integer, Group> subGroupMap;
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

            ObservableList<Node> paramList = subGroup.getChildren();

            Text lastMsg = (Text)paramList.get(LASTMSGINDEX);

            Text nameChat = (Text)paramList.get(CHATNAMEINDEX);

            lastMsg.setText(resBean.getChatMessages().getLast().getText());

            nameChat.setText(resBean.getDestUser().getName()+" "+resBean.getDestUser().getSurname());

            current.setOpacity(1.0);
            index++;
            lastIndexChat++;
        }
        HomeChefUtil.disEnButtonNext(this.loadNext, lastIndexChat,chatList.size());
        HomeChefUtil.disEnButtonPrev(this.loadPrevious, lastIndexChat,MAXCHATVIEWED);

    }

}
