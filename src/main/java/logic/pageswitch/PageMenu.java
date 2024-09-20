package logic.pageswitch;

import javafx.event.ActionEvent;

public  class PageMenu extends Page {
    public void switchToBookList(ActionEvent event)  {
        this.switchTo("booklist/interf1.fxml",event,"Book list");
    }
    public void switchToBookListChef(ActionEvent event)  {
        this.switchTo("booklist/interf1.fxml",event,"Book list");
    }
    public void switchToHome(ActionEvent event){
        this.switchTo("search/interf1.fxml",event,"Homepage");
    }
    public void switchToHomeChef(ActionEvent event){this.switchTo("homepagechef/interf1.fxml",event,"Homepage");}
    public void switchToISCUser(ActionEvent event)  {
        this.switchTo("initialSearchAndChatUser/interf1.fxml",event,"Search and chat  ");
    }
    public void switchToISCChef(ActionEvent event)  {
        this.switchTo("initialSearchAndChatChef/interf1.fxml",event,"Search and chat  ");
    }
    public void switchToSettings(ActionEvent event)  {
        this.switchTo("settings/interf1.fxml",event,"Settings");
    }
    public void switchToSettingsChef(ActionEvent event)  {
        this.switchTo("settingschef/interf1.fxml",event,"Settings");
    }
}

