package testlog;

import logic.appcontroller.LoginController;
import logic.beans.Logbean;
import logic.exceptions.LoginErrorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestDB {

    public boolean logTestSucc(){
        LoginController controller = new LoginController();
        Logbean log = new Logbean();
        log.setEmail("mtarei@gmail.com");
        log.setPassword("1234");
        try{
            controller.loginUser(log);
        }catch(LoginErrorException e){
            return false;
        }
        return true;
    }

    public boolean logTestFailed(){
        LoginController controller = new LoginController();
        Logbean log = new Logbean();
        log.setEmail("mtarei@gmail.com");
        log.setPassword("1245");
        try{
            controller.loginUser(log);
        }catch(LoginErrorException e){
            return false;
        }
        return true;
    }
    //testare poi altri tipi di controlli che andremo a inserire, tipo un check della mail o della formattazione della mail
    @Test
    void testLoginSuccess(){
        assertTrue(logTestSucc());
    }

    @Test
    void testLoginFail(){
        assertFalse(logTestFailed());
    }
}
