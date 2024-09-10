package logic;

import logic.pageswitch.Exceptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
                root = FXMLLoader.load(HomeChefApplication.class.getResource("login/interf2.fxml"));
            } else {
                //root = FXMLLoader.load(HomeChefApplication.class.getResource("buttonBarInterf2.fxml"));
               root = FXMLLoader.load(HomeChefApplication.class.getResource("login/interf1.fxml"));
            }
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.setResizable(false);
            stage.show();
    } catch (Exception e) {
        Exceptions.exceptionPageOccurred();
    }
    }

    public static void main(String[] args) {
        launch();
    }
}