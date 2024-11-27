package logic.patterns;


import logic.viewcontroller.chat.ChatViewController;

public class ChatObserver {
    private Updater updater;
    private ChatViewController chatViewController;

    public void addUpdater(Updater updater){
        this.updater=updater;
    }
    public void delUpdater(){
        this.updater=null;
    }

    public void notifyMsgISC(){
        updater.update();
    }
    public void setUpdater(Updater updater){
        delUpdater();
        addUpdater(updater);
    }

    public ChatViewController getChatViewController() {
        return chatViewController;
    }

    public void setChatViewController(ChatViewController chatViewController) {
        this.chatViewController = chatViewController;
    }
}
