package logic.patterns;

import logic.beans.*;

import java.util.List;

public class Setter {


    private static HomeChefBean hcbean;
    private static HomeChefBean hcvisitbean;
    private static List<ResultSearchBean> chefList;
    private static SessionParamBean sessionParam;

    private static IsHomeVisitBean isHomeVisitBean;

    private static ISCBean openChat;
    private static List<ISCBean> chatList;
    private static List<BookListBean> bookList;
    private static final ChatObserver observer = new ChatObserver();
    public enum Mode{
        SMARTPHONE,
        DESKTOP
    }

    private static Mode mode;

    private Setter() {

    }

    public static HomeChefBean getHcbean() {
        return hcbean;
    }

    public static void setHcbean(HomeChefBean hcbean) {
        Setter.hcbean = hcbean;
    }

    public static HomeChefBean getHcvisitbean() {
        return hcvisitbean;
    }

    public static void setHcvisitbean(HomeChefBean hcvisitbean) {
        Setter.hcvisitbean = hcvisitbean;
    }

    public static List<ResultSearchBean> getChefList() {
        return chefList;
    }

    public static void setChefList(List<ResultSearchBean> chefList) {
        Setter.chefList = chefList;
    }

    public static SessionParamBean getSessionParam() {
        return sessionParam;
    }

    public static void setSessionParam(SessionParamBean sessionParam) {
        Setter.sessionParam = sessionParam;
    }

    public static IsHomeVisitBean getIsHomeVisitBean() {
        return isHomeVisitBean;
    }

    public static void setIsHomeVisitBean(IsHomeVisitBean isHomeVisitBean) {
        Setter.isHomeVisitBean = isHomeVisitBean;
    }

    public static ISCBean getOpenChat() {
        return openChat;
    }

    public static void setOpenChat(ISCBean openChat) {
        Setter.openChat = openChat;
    }

    public static List<BookListBean> getBookList() {
        return bookList;
    }

    public static void setBookList(List<BookListBean> bookList) {
        Setter.bookList = bookList;
    }

    public static List<ISCBean> getChatList() {
        return chatList;
    }

    public static void setChatList(List<ISCBean> chatList) {
        Setter.chatList = chatList;
    }

    public static ChatObserver getObserver() {
        return observer;
    }

    public static Mode getMode() {
        return mode;
    }

    public static void setMode(Mode mode) {
        Setter.mode = mode;
    }
}
