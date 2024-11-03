package logic.viewcontroller.booklist;

import javafx.fxml.FXML;
import javafx.scene.Group;

public abstract class BookListViewController {
    @FXML
    protected Group group1;
    @FXML
    protected Group group2;
    @FXML
    protected Group group3;
    @FXML
    protected Group group4;
    @FXML
    protected Group group5;
    @FXML
    protected Group group6;
    @FXML
    protected Group group7;
    @FXML
    protected Group group8;

    @FXML
    protected void refBook(){
        //metodo che rifiuta una prenotazione
    }
    @FXML
    protected void acceptBook(){
        //metodo che accetta una prenotazione
    }
    @FXML
    protected void outputValPrevious(){
        //to be implemented
    }
    @FXML
    protected void outputVal(){
        //To be implemented
    }
}
