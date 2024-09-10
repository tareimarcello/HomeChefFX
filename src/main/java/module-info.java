module com.example.homechef {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens logic to javafx.fxml;
    exports logic;
    exports logic.viewController.login;
    opens logic.viewController.login to javafx.fxml;
    exports logic.viewController.recoverpasswd;
    opens logic.viewController.recoverpasswd to javafx.fxml;
    exports logic.viewController.search;
    opens logic.viewController.search to javafx.fxml;
    exports logic.viewController.signup;
    opens logic.viewController.signup to javafx.fxml;
    exports logic.viewController.signupchef;
    opens logic.viewController.signupchef to javafx.fxml;
    exports logic.viewController.settings;
    opens logic.viewController.settings to javafx.fxml;
}