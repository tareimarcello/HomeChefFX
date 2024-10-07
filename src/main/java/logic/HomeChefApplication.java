package logic;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import logic.exceptions.Exceptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Optional;

public class HomeChefApplication extends Application {
    private enum ScreenSize{
        LAPTOP,SMARTPHONE
    }
    private static ScreenSize size;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root;
        try {
            if (size == ScreenSize.LAPTOP) {
                root = FXMLLoader.load(HomeChefApplication.class.getResource("login/interf2.fxml"));
            } else {
               root = FXMLLoader.load(HomeChefApplication.class.getResource("login/interf1.fxml"));
            }
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.setResizable(false);
            //Alert in fase di uscita dall'applicazione
            stage.setOnCloseRequest((WindowEvent windowEvent) ->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit Confirmation");
                alert.setHeaderText("Are you sure to exit program?");
                alert.setContentText("If you want to exit you'll be logged out from application.");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.isPresent() && result.get() == ButtonType.OK){
                    //vediamo come chiudere la connessione
                }
                else{
                    windowEvent.consume();
                }
            });
            stage.show();
        } catch (Exception e) {
        Exceptions.exceptionPageOccurred();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}