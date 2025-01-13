package logic.viewcontroller.recoverpasswd;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.appcontroller.RecPswdController;
import logic.beans.RecPswdBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.MailNotInDBException;
import logic.pageswitch.Page;
import javafx.fxml.FXML;

public class RecoverPswdViewController {
    protected RecPswdController controller ;
    @FXML
    protected Label show;
    @FXML
    protected TextField email;

    public RecoverPswdViewController() {
        controller = new RecPswdController();
    }

    @FXML
    protected void sendMail(){
        RecPswdBean bean = new RecPswdBean("");
        if(!bean.setEmail(email.getText())){
            show.setText("The field is empty or \n Invalid Format");
            show.setOpacity(1.0);
        }else{
            try{
                controller.checkEmail(bean);
                show.setText("Password sended via mail");
                show.setOpacity(1.0);
            }catch(ConnectionException e){
                Exceptions.exceptionConnectionOccurred();
            }catch(MailNotInDBException e){
                show.setOpacity(1.0);
                show.setText(e.getMessage());
            }
        }
    }


    @FXML
    protected void backToLogin(){
        Page pageSwitch=new Page();
        pageSwitch.backTo();
    }

}
