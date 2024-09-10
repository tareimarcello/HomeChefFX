package logic.pageSwitch;

import javafx.event.ActionEvent;

public  class PageMenu extends Page {
    public void switchToChat(ActionEvent event)  {
        this.switchTo("chat/interf1.fxml",event,"Chat");
    }
    public void switchToBook(ActionEvent event)  {
        this.switchTo("clientBook/interf1.fxml",event,"Booking");
    }
    public void switchToHome(ActionEvent event){
        this.switchTo("search/interf1.fxml",event,"Homepage");
    }
    public void switchToHomeChef(ActionEvent event){this.switchTo("homeChef/interf1.fxml",event,"Homepage");}
    public void switchToISC(ActionEvent event)  {
        this.switchTo("initialSearchAndChat/interf1.fxml",event,"What do you need?  ");
    }
    public void switchToSettings(ActionEvent event)  {
        this.switchTo("settings/interf1.fxml",event,"Settings");
    }
    public void switchToSettingsChef(ActionEvent event)  {
        this.switchTo("settings/interf1.fxml",event,"Settings");
    }
    public void switchToSearch(ActionEvent event ){this.switchTo("search/interf1.fxml",event,"Search");}
}

