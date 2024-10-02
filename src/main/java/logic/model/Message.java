package logic.model;

import java.sql.Timestamp;

public class Message {
    private long idMsg;
    private long sender;
    private long receiver;
    private String text;
    private Timestamp time;

    public Message(long idMsg, long sender, long receiver, String text, Timestamp time) {
        this.idMsg = idMsg;
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.time = time;
    }

    public long getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(long idMsg) {
        this.idMsg = idMsg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getReceiver() {
        return receiver;
    }

    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }
}
