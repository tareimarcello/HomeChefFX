package logic.patterns;


import logic.viewcontroller.chat.ChatViewController;

public class ChatObserver {
    private Updater updater;

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

}
