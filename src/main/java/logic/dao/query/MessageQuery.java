package logic.dao.query;

public class MessageQuery {

    public String getSelectAllMessage(){
        return "SELECT * FROM message";
    }

    public String getSelectMessageById(long idmessage){
        return String.format("SELECT * FROM message WHERE idmessage=%d", idmessage);
    }

    public String getSelectByChatId(long idChat){
        return String.format("SELECT * FROM message WHERE chat = %d ORDER BY timestamp", idChat);
    }

    public String insertMessageQuery(long sender, long receiver, String text, long chat){

        return String.format("INSERT INTO message (sender,receiver,text,timestamp,chat) VALUES (%d,%d,'%s',CURRENT_TIMESTAMP,%d)",sender,receiver,text,chat);
    }

    public String updateQuery(long sender, long receiver, String text, long chat,long idmessage){
        return String.format("UPDATE message SET sender = %d, receiver = %d,text = '%s',CURRENT_TIMESTAMP, chat = %d WHERE idmessage = %d",sender,receiver,text,chat, idmessage);
    }

    public String deleteQuery(long idmessage){
        return String.format("DELETE FROM message WHERE idmessage = %d", idmessage);
    }
}
