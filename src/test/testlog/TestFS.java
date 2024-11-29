package testlog;

import logic.beans.MessageBean;
import logic.dao.DAOMessageImplFileSystem;
import logic.model.Message;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class TestFS {      //Tarei Marcello
    public boolean messageDaoFsTest() {
        MessageBean msgBean = new MessageBean();
        msgBean.setIdChat(12);
        msgBean.setIdSender(4);
        msgBean.setIdReceiver(7);
        msgBean.setText("Ciao sono test file system 5");
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        Message msg = new Message(-1, msgBean.getIdSender(), msgBean.getIdReceiver(), msgBean.getText(), new Timestamp(System.currentTimeMillis()), msgBean.getIdChat());
        msgDao.save(msg);
        List<Message> messages = msgDao.getAll();
        long lastId = 0;
        for (int i=0;i<messages.size()-1;i++) {
            if(messages.get(i).getIdMsg() > messages.get(i+1).getIdMsg()){
                lastId = messages.get(i).getIdMsg();
            }else{
                lastId = messages.get(i+1).getIdMsg();
            }
        }
        if(msgDao.get(lastId).getSender()==msgBean.getIdSender() && msgDao.get(lastId).getReceiver()==msgBean.getIdReceiver() && msgDao.get(lastId).getText().equals(msgBean.getText()) && msgDao.get(lastId).getIdChat()==msgBean.getIdChat()){
            return true;
        }else{
            return false;
        }
    }

    public boolean messageDaoFsGet(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        if (msgDao.get(20) != null){
            Message msg= msgDao.get(20);
            if(msg.getSender()==4 && msg.getReceiver()==7 && msg.getText().equals("ciao") && msg.getIdChat()==4 && msg.getTime().equals(Timestamp.valueOf("2024-11-18 19:17:37.923"))){
                return true;
            }
        }
        return false;
    }

    public boolean messageDaoFsUpdate(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        MessageBean msgBean = new MessageBean();
        msgBean.setIdChat(6);
        msgBean.setIdSender(4);
        msgBean.setIdReceiver(44);
        msgBean.setText("Ciao sono test update file system 3");
        Message msg = new Message(30, msgBean.getIdSender(), msgBean.getIdReceiver(), msgBean.getText(), new Timestamp(System.currentTimeMillis()), msgBean.getIdChat());
        try {
            msgDao.update(msg);
            if(msgDao.get(30).getText().equals(msgBean.getText())){
                return true;
            }else{
                return false;
            }
        }catch(IllegalArgumentException e){
            return false;
        }
    }

    public boolean messageDaoFsDelete(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        Message msg = new Message(29, 0, 0, "", new Timestamp(System.currentTimeMillis()), 0);
        if(msgDao.get(29)==null){
            return false;
        }
        msgDao.delete(msg);
        return true;
    }

    public boolean getBySendRecTest(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        return msgDao.getBySendRec(4,7)!=null;
    }

    public boolean getByIdChatTest(){
        DAOMessageImplFileSystem msgDao = new DAOMessageImplFileSystem();
        return msgDao.getAllByChat(12)!=null;
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
    @Test
    void testMessageDaoFsTestGet(){
        assertTrue(getBySendRecTest());
    }
    @Test
    void testMessageDaoFsTestGetByChatId(){
        assertTrue(getByIdChatTest());
    }
}
