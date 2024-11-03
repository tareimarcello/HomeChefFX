package logic.viewcontroller.book;

import logic.pageswitch.PageMenu;

public class BookViewControllerInterf2 extends BookViewController{

    public BookViewControllerInterf2(){
        pageSwitch = new PageMenu();
    }

    public void initialize(){
        bookDone.setOpacity(0.0);
        bookFail.setOpacity(0.0);
    }

}
