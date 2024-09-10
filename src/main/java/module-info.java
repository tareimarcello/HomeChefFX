module com.example.homechef {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.homechef to javafx.fxml;
    exports com.example.homechef;
    exports com.example.homechef.viewController.login;
    opens com.example.homechef.viewController.login to javafx.fxml;
    exports com.example.homechef.viewController.recoverpasswd;
    opens com.example.homechef.viewController.recoverpasswd to javafx.fxml;
    exports com.example.homechef.viewController.search;
    opens com.example.homechef.viewController.search to javafx.fxml;
    exports com.example.homechef.viewController.signup;
    opens com.example.homechef.viewController.signup to javafx.fxml;
    exports com.example.homechef.viewController.signupchef;
    opens com.example.homechef.viewController.signupchef to javafx.fxml;
    exports com.example.homechef.viewController.settings;
    opens com.example.homechef.viewController.settings to javafx.fxml;
}