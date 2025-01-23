package logic.viewcontroller.chat;

import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;

public class ChatInterf2 extends ChatViewController{
    public ChatInterf2() {
        pageswitch = new PageMenu();
        graphics = new Decorator(false);
    }

}
