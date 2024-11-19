package logic;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.WindowEvent;
import logic.exceptions.Exceptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.patterns.ViewSetter;


import java.io.IOException;

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
                ViewSetter.setMode(ViewSetter.Mode.DESKTOP);
                root = FXMLLoader.load(HomeChefApplication.class.getResource("login/interf2.fxml"));
            } else {
                ViewSetter.setMode(ViewSetter.Mode.SMARTPHONE);
               root = FXMLLoader.load(HomeChefApplication.class.getResource("login/interf1.fxml"));
            }

            Image iconImage = new Image(HomeChefApplication.class.getResource("photo/logo.png").toString());

            stage.getIcons().add(iconImage);
            stage.setScene(new Scene(root));

            stage.setTitle("Login");
            stage.setResizable(false);
            //Alert in fase di uscita dall'applicazione
            stage.setOnCloseRequest((WindowEvent windowEvent) ->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit Confirmation");
                alert.setHeaderText("Are you sure to exit program?");
                alert.setContentText("If you want to exit you'll be logged out from application.");
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