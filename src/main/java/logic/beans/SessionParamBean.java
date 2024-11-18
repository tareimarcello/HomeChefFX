package logic.beans;

public class SessionParamBean {

    public enum UserType {
        CUSTOMER,
        CHEF
    }
    private long currentUserId;



    private UserType userType;


    
    public long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
