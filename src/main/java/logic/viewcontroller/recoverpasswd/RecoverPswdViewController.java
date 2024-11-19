package logic.viewcontroller.recoverpasswd;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.appcontroller.RecPswdController;
import logic.beans.RecPswdBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.MailNotInDBException;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.Page;
import javafx.fxml.FXML;

public class RecoverPswdViewController {
    protected static final RecPswdController controller = new RecPswdController();
    @FXML
    protected Label show;
    @FXML
    protected TextField email;

    @FXML
    protected void sendMail(){
        if(email.getText().equals("")){
            show.setText("The field is empty");
        }else if(!HomeChefUtil.isValidEmail(email.getText())) {
            show.setText("The email format is incorrect");
        }else{
            RecPswdBean bean = new RecPswdBean(email.getText());
            try{
                controller.checkEmail(bean);
            }catch(ConnectionException e){
                Exceptions.exceptionConnectionOccurred();
            }catch(MailNotInDBException e){
                show.setOpacity(1.0);
                show.setText(e.getMessage());
            }
        }
        show.setText("Password sended via mail");
        show.setOpacity(1.0);
    }


    @FXML
    protected void backToLogin(){
        Page pageSwitch=new Page();
        pageSwitch.backTo();
    }

}
