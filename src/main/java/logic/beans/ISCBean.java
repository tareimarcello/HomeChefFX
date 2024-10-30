package logic.beans;

import logic.model.Chat;
import logic.model.Message;
import logic.model.User;

import java.util.ArrayList;
import java.util.List;

public class ISCBean {

    private Chat chat;
    private User destUser;
    private final List<Message> chatMessages = new ArrayList<>();

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getDestUser() {
        return destUser;
    }

    public void setDestUser(User destUser) {
        this.destUser = destUser;
    }

    public List<Message> getChatMessages() {
        return chatMessages;
    }

}
