package testlog;

import logic.appcontroller.LoginController;
import logic.beans.Logbean;
import logic.exceptions.Exceptions;
import logic.exceptions.LoginErrorException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LogAndSearchTest {

    public boolean logTestSucc(){
        LoginController controller = new LoginController();
        Logbean log = new Logbean();
        log.setEmail("mtarei@gmail.com");
        log.setPassword("1234");
        try{
            controller.loginUser(log);
        }catch(LoginErrorException e){
            return false;
        } catch (Exception e) {
            Exceptions.exceptionConnectionOccurred();
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
        } catch (Exception e) {
            Exceptions.exceptionConnectionOccurred();
        }
        return true;
    }


    @Test
    void testLoginSuccess(){
        assertTrue(logTestSucc());
    }

    @Test
    void testLoginFail(){
        assertFalse(logTestFailed());
    }
}
