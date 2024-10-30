package logic.beans;

public class SessionParamBean {

    private long currentChatId;
    private long currentUserId;
    private long currentReceiverId;

    public long getCurrentChatId() {
        return currentChatId;
    }

    public void setCurrentChatId(long currentChatId) {
        this.currentChatId = currentChatId;
    }

    public long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public long getCurrentReceiverId() {
        return currentReceiverId;
    }

    public void setCurrentReceiverId(long currentReceiverId) {
        this.currentReceiverId = currentReceiverId;
    }
}
