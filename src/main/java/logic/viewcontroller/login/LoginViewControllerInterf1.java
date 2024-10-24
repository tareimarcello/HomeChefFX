package logic.viewcontroller.login;

import javafx.scene.control.Label;
import logic.patterns.ViewSetter;
import logic.appcontroller.LoginController;
import logic.beans.HomeChefBean;
import logic.beans.Logbean;
import logic.model.Chef;
import logic.model.Customer;
import logic.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.pageswitch.PageMenu;

import java.util.NoSuchElementException;

public class LoginViewControllerInterf1 {

        private final PageMenu pageSwitch;
        @FXML
        private Button loginButton;
        @FXML
        private TextField labUser;
        @FXML
        private PasswordField labPassword;
        @FXML
        private Button switchUiButton;
        @FXML
        private Button showPasswdButton;
        @FXML
        private Label show;

        public LoginViewControllerInterf1(){
            pageSwitch =new PageMenu();
            //clicked=false;
        }
        @FXML
        protected void switchToHomePage(ActionEvent event) {

                // TO BE IMPLEMENTED
                // - prende le credenziali

                Logbean logBean = new Logbean();
                if (this.labUser.getText() == null
                        || this.labUser.getText().equals("")
                        || this.labPassword.getText() == null
                        || this.labPassword.getText().equals("")) {

                        this.show.setText("EMAIL e PASSWORD obbligatorie");
                        return;
                }
                // - Creazione bean utente
                logBean.setEmail(this.labUser.getText());
                logBean.setPassword(this.labPassword.getText());

                LoginController controller = new LoginController();

                try {
                        // - Invocazione check sul controller utenza.
                        User user = controller.loginUser(logBean);
                        user = controller.checkType(user.getID());
                        // - aprire la pagina corretta

                        if (user instanceof Customer)
                                pageSwitch.switchToHome(event);
                        else if (user instanceof Chef) {
                                HomeChefBean hcbean = new HomeChefBean();
                                hcbean.setName(user.getName()+" "+user.getSurname());
                                hcbean.setCity(((Chef) user).getCitta());
                                hcbean.setDish(((Chef) user).getBestDish());
                                hcbean.setRes(((Chef) user).getRestaurant());
                                ViewSetter.getInstance().setHcbean(hcbean);
                                pageSwitch.switchToHomeChef(event);
                        }

                } catch (Exception e) {

                        if (e instanceof NoSuchElementException) {
                                this.show.setText("User not found");
                        } else {
                                this.show.setText(e.getMessage());

                        }
                        this.show.setOpacity(1.0);
                }
        }

        @FXML
        protected void switchToSignup(ActionEvent event) {
            pageSwitch.switchTo("signup/interf1.fxml",event,"Signup");
        }

        @FXML
        protected void switchToRecoverPswd(ActionEvent event) {
                pageSwitch.switchTo("recoverpassword/interf1.fxml",event,"RecoverPsw");
        }

        @FXML
        protected void switchToSignUpChef(ActionEvent event) {
                pageSwitch.switchTo("signupChef/interf1.fxml",event,"SignupChef");
        }

        @FXML
        protected void resize(ActionEvent event) {
            pageSwitch.setSize("login/interf1.fxml",event);
        }



}
