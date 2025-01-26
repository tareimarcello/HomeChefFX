package logic.pageswitch;

import javafx.event.ActionEvent;
import logic.appcontroller.BookListController;
import logic.appcontroller.ISCController;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.homechefutil.HomeChefUtil;
import logic.patterns.Setter;

public  class PageMenu extends Page {
    public void switchToBookList(ActionEvent event)  {
        BookListController controller = new BookListController();
        try {
            HomeChefUtil.changeNot();
            controller.loadBookList();
        } catch (ConnectionException e) {

            Exceptions.exceptionConnectionOccurred();
        }
        this.switchTo("booklist/interf1.fxml",event,"Book list");
    }
    public void switchToChefBookList(ActionEvent event)  {
        BookListController controller = new BookListController();
        try {
            controller.loadBookList();
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }

        this.switchTo("booklistchef/interf1.fxml",event,"Book list Chef");

    }
    public void switchToHome(ActionEvent event){
        this.switchTo("search/interf1.fxml",event,"Homepage");
    }
    public void switchToHomeChef(ActionEvent event){this.switchTo("homepagechef/interf1.fxml",event,"Homepage");}
    public void switchToISCUser(ActionEvent event)  {
        ISCController controller = new ISCController();
        try {
            Setter.setChatList(controller.getISCToChef());
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        this.switchTo("initialSearchAndChatUser/interf1.fxml",event,"Search and chat  ");
    }
    public void switchToISCChef(ActionEvent event)  {
        ISCController controller = new ISCController();
        try {
            Setter.setChatList(controller.getISCToUser());
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        this.switchTo("initialSearchAndChatChef/interf1.fxml",event,"Search and chat  ");
    }
    public void switchToSettings(ActionEvent event)  {
        this.switchTo("settings/interf1.fxml",event,"Settings");
    }
    public void switchToSettingsChef(ActionEvent event)  {
        this.switchTo("settingschef/interf1.fxml",event,"Settings");
    }
}

