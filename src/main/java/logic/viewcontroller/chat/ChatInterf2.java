package logic.viewcontroller.chat;

import logic.pageswitch.PageMenu;
import logic.patterns.Decorator;
import logic.patterns.Setter;

public class ChatInterf2 extends ChatViewController{
    public ChatInterf2() {
        Setter.getObserver().setChatViewController(this);
        pageswitch = new PageMenu();
        graphics = new Decorator(false);
    }

}
