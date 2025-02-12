package logic.dao.query;

public class MessageQuery {


    public String getSelectByChatId(long idChat){
        return String.format("SELECT * FROM message WHERE chat = %d ORDER BY timestamp", idChat);
    }

    public String insertMessageQuery(long sender, long receiver, String text, long chat){

        return String.format("INSERT INTO message (sender,receiver,text,timestamp,chat) VALUES (%d,%d,'%s',CURRENT_TIMESTAMP,%d)",sender,receiver,text,chat);
    }

}
