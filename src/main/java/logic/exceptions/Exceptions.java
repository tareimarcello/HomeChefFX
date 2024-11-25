package logic.exceptions;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import logic.pageswitch.Page;
import logic.pageswitch.PageMenu;

import java.util.Optional;

public final class Exceptions {
    private Exceptions(){
        //the other class can't edit Exceptions
    }
    public static void exceptionPageOccurred(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Invalid resources ");
        alert.setHeaderText("we found found some trouble during the execution of the program");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            System.exit(0);
        }
    }
    public static void exceptionConnectionOccurred(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Connection failed ");
        alert.setHeaderText("We found found some trouble during the getSTMT on the Database");
        alert.setContentText("Please retry your access");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            System.exit(0);
        }
    }
}

