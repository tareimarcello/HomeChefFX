package logic.viewcontroller.login;

import javafx.scene.control.Label;
import logic.beans.SessionParamBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.LoginErrorException;
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
        private Label show;

        public LoginViewControllerInterf1(){
            pageSwitch =new PageMenu();
        }
        @FXML
        protected void switchToHomePage(ActionEvent event) {

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
                        User user = controller.loginUser(logBean).getReturnUser();
                        SessionParamBean sessionParam = new SessionParamBean();
                        sessionParam.setCurrentUserId(user.getID());
                        ViewSetter.setSessionParam(sessionParam);
                        user = controller.checkType(user.getID()).getReturnUser();
                        // - aprire la pagina corretta
                        switch (user) {
                                case Customer cu -> {
                                        ViewSetter.getSessionParam().setUserType(SessionParamBean.UserType.CUSTOMER);
                                        pageSwitch.switchToHome(event);

                                }
                                case Chef ch -> {
                                        HomeChefBean hcbean = new HomeChefBean();
                                        hcbean.setName(user.getName() + " " + user.getSurname());
                                        hcbean.setCity(ch.getCitta());
                                        hcbean.setDish(ch.getBestDish());
                                        hcbean.setRes(ch.getRestaurant());
                                        hcbean.setId(ch.getID());
                                        ViewSetter.setHcbean(hcbean);
                                        ViewSetter.getSessionParam().setUserType(SessionParamBean.UserType.CHEF);
                                        pageSwitch.switchToHomeChef(event);
                                }
                                default -> throw new IllegalArgumentException("User type not valid");
                        }
                } catch (ConnectionException e) {
                        Exceptions.exceptionConnectionOccurred();
                }catch(NoSuchElementException ex) {
                        this.show.setText("Email is incorrect");
                        this.show.setOpacity(1.0);
                }catch(LoginErrorException ex) {
                        this.show.setText(ex.getMessage());
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
