package logic.patterns;

import logic.beans.*;

import java.util.List;

public class ViewSetter {


    private static HomeChefBean hcbean;
    private static HomeChefBean hcvisitbean;
    private static List<ResultSearchBean> chefList;
    private static SessionParamBean sessionParam;

    private static IsHomeVisitBean isHomeVisitBean;

    private static ISCBean openChat;
    private static List<ISCBean> chatList;
    private static List<BookBean> bookList;
    private static final ChatObserver observer = new ChatObserver();
    public enum Mode{
        SMARTPHONE,
        DESKTOP
    };
    private static Mode mode;

    private ViewSetter() {

    }

    public static HomeChefBean getHcbean() {
        return hcbean;
    }

    public static void setHcbean(HomeChefBean hcbean) {
        ViewSetter.hcbean = hcbean;
    }

    public static HomeChefBean getHcvisitbean() {
        return hcvisitbean;
    }

    public static void setHcvisitbean(HomeChefBean hcvisitbean) {
        ViewSetter.hcvisitbean = hcvisitbean;
    }

    public static List<ResultSearchBean> getChefList() {
        return chefList;
    }

    public static void setChefList(List<ResultSearchBean> chefList) {
        ViewSetter.chefList = chefList;
    }

    public static SessionParamBean getSessionParam() {
        return sessionParam;
    }

    public static void setSessionParam(SessionParamBean sessionParam) {
        ViewSetter.sessionParam = sessionParam;
    }

    public static IsHomeVisitBean getIsHomeVisitBean() {
        return isHomeVisitBean;
    }

    public static void setIsHomeVisitBean(IsHomeVisitBean isHomeVisitBean) {
        ViewSetter.isHomeVisitBean = isHomeVisitBean;
    }

    public static ISCBean getOpenChat() {
        return openChat;
    }

    public static void setOpenChat(ISCBean openChat) {
        ViewSetter.openChat = openChat;
    }

    public static List<BookBean> getBookList() {
        return bookList;
    }

    public static void setBookList(List<BookBean> bookList) {
        ViewSetter.bookList = bookList;
    }

    public static List<ISCBean> getChatList() {
        return chatList;
    }

    public static void setChatList(List<ISCBean> chatList) {
        ViewSetter.chatList = chatList;
    }

    public static ChatObserver getObserver() {
        return observer;
    }

    public static Mode getMode() {
        return mode;
    }

    public static void setMode(Mode mode) {
        ViewSetter.mode = mode;
    }
}
