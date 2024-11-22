package testlog;

import logic.beans.MessageBean;
import logic.dao.DAOMessageImplFileSystem;
import logic.model.Message;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestFS {
    public boolean messageDaoFsTest() {
        MessageBean msgBean = new MessageBean();
        msgBean.setIdChat(12);
        msgBean.setIdSender(4);
        msgBean.setIdReceiver(7);
        msgBean.setText("Ciao sono test file system");
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        Message msg = new Message(-1, msgBean.getIdSender(), msgBean.getIdReceiver(), msgBean.getText(), new Timestamp(System.currentTimeMillis()), msgBean.getIdChat());
        msgDao.save(msg);
        return true;
    }

    public boolean messageDaoFsGet(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        return msgDao.get(20) != null;
    }

    public boolean messageDaoFsUpdate(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        MessageBean msgBean = new MessageBean();
        msgBean.setIdChat(6);
        msgBean.setIdSender(4);
        msgBean.setIdReceiver(44);
        msgBean.setText("Ciao sono test update file system");
        Message msg = new Message(29, msgBean.getIdSender(), msgBean.getIdReceiver(), msgBean.getText(), new Timestamp(System.currentTimeMillis()), msgBean.getIdChat());
        try {
            msgDao.update(msg);
        }catch(IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public boolean messageDaoFsDelete(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        Message msg = new Message(29, 0, 0, "", new Timestamp(System.currentTimeMillis()), 0);
        msgDao.delete(msg);
        return true;
    }



    @Test
    void testMessageDaoFsTest(){
        assertTrue(messageDaoFsTest());
    }

    @Test
    void testMessageDaoFsGet(){
        assertTrue(messageDaoFsGet());
    }
    @Test
    void testMessageDaoFsUpdate(){
        assertTrue(messageDaoFsUpdate());
    }
    @Test
    void testMessageDaoFsDelete(){
        assertTrue(messageDaoFsDelete());
    }
}
