package testlog;

import logic.appcontroller.LoginController;
import logic.appcontroller.SearchController;
import logic.beans.Logbean;
import logic.beans.MessageBean;
import logic.beans.SearchBean;
import logic.dao.DAOMessageImpl;
import logic.dao.DAOMessageImplFileSystem;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.LoginErrorException;
import logic.exceptions.NoResultFoundException;
import logic.model.Message;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

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

    public boolean messageDaoFsTest(){
        MessageBean msgBean = new MessageBean();
        msgBean.setIdChat(12);
        msgBean.setIdSender(4);
        msgBean.setIdReceiver(7);
        msgBean.setText("Ciao sono test file system");
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        Message msg = new Message(37,msgBean.getIdSender(), msgBean.getIdReceiver(), msgBean.getText(), new Timestamp(System.currentTimeMillis()), msgBean.getIdChat());
        msgDao.save(msg);
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
    @Test
    void testMessageDaoFsTest(){
        assertTrue(messageDaoFsTest());
    }
}
