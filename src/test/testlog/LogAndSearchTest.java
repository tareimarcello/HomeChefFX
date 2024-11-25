package testlog;

import logic.appcontroller.LoginController;
import logic.appcontroller.SearchController;
import logic.beans.Logbean;
import logic.beans.SearchBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.LoginErrorException;
import logic.exceptions.NoResultFoundException;
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

    public boolean searchTestSucc(){
        SearchController controller = new SearchController();
        SearchBean search = new SearchBean();
        search.setChefCity("Roma");
        search.setChefName("Tarei");
        search.setChefBestDish("Bocchettoni");
        try {
            controller.searchChefList(search);
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }catch(NoResultFoundException e){
            return false;
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
    @Test
    void testSearchSuccess(){
        assertTrue(searchTestSucc());
    }
    @Test
    void testSearchFail(){
        assertFalse(searchTestSucc());
    }
}
