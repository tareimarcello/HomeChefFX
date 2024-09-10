module com.example.homechef {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens logic to javafx.fxml;
    exports logic;
    exports logic.viewcontroller.login;
    opens logic.viewcontroller.login to javafx.fxml;
    exports logic.viewcontroller.recoverpasswd;
    opens logic.viewcontroller.recoverpasswd to javafx.fxml;
    exports logic.viewcontroller.search;
    opens logic.viewcontroller.search to javafx.fxml;
    exports logic.viewcontroller.signup;
    opens logic.viewcontroller.signup to javafx.fxml;
    exports logic.viewcontroller.signupchef;
    opens logic.viewcontroller.signupchef to javafx.fxml;
    exports logic.viewcontroller.settings;
    opens logic.viewcontroller.settings to javafx.fxml;
}