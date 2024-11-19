package logic.patterns;

import logic.viewcontroller.initialsearchandchat.InitialSearchAndChatViewController;

public class ChatObserver {
    InitialSearchAndChatViewController updater;

    public void addUpdater(InitialSearchAndChatViewController updater){
        this.updater=updater;
    }
    public void delUpdater(){
        this.updater=null;
    }

    public void notifyMsgISC(){
        updater.updateLastMessage();
    }
}
