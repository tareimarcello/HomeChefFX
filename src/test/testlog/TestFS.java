package testlog;

import logic.beans.MessageBean;
import logic.dao.DAOMessageImplFileSystem;
import logic.model.Message;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFS {
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

    @Test
    void testMessageDaoFsTest(){
        assertTrue(messageDaoFsTest());
    }
}
