package logic.beans;

public class SessionParamBean {

    public enum userType{
        CUSTOMER,
        CHEF
    }
   // private long currentChatId;
    private long currentUserId;



    private userType userType;


    
    public long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public SessionParamBean.userType getUserType() {
        return userType;
    }

    public void setUserType(SessionParamBean.userType userType) {
        this.userType = userType;
    }

}
