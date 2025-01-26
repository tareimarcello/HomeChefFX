package logic.beans;

public class SessionParamBean {

    public enum UserType {
        CUSTOMER,
        CHEF
    }
    private long currentUserId;

    private UserType userType;

    private boolean bookNot;
    
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

    public boolean getBookNot() {
        return bookNot;
    }

    public void setBookNot(boolean bookNot) {
        this.bookNot = bookNot;
    }
}
