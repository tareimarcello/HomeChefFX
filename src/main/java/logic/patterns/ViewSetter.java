package logic.patterns;

import logic.beans.*;

import java.util.List;

public class ViewSetter {

    private static ViewSetter setter;

    private HomeChefBean hcbean;
    private HomeChefBean hcvisitbean;
    private List<ResultSearchBean> chefList;
    private SessionParamBean sessionParam;

    private IsHomeVisitBean isHomeVisitBean;

    private ISCBean openChat;
    private List<ISCBean> chatList;

    private ViewSetter (){


    }

    public static ViewSetter getInstance(){

        if (setter==null)
           setter = new ViewSetter();

        return setter;
    }

    public IsHomeVisitBean getIsHomeVisitBean() {
        return isHomeVisitBean;
    }

    public void setIsHomeVisitBean(IsHomeVisitBean isHomeVisitBean) {
        this.isHomeVisitBean = isHomeVisitBean;
    }

    public ISCBean getOpenChat() {
        return openChat;
    }

    public void setOpenChat(ISCBean openChat) {
        this.openChat = openChat;
    }
    public HomeChefBean getHcbean() {
        return hcbean;
    }

    public void setHcbean(HomeChefBean hcbean) {
        this.hcbean = hcbean;
    }

    public List<ResultSearchBean> getChefList() {
        return chefList;
    }

    public void setChefList(List<ResultSearchBean> chefList) {
        this.chefList = chefList;
    }

    public HomeChefBean getHcvisitbean() {
        return hcvisitbean;
    }

    public void setHcvisitbean(HomeChefBean hcvisitbean) {
        this.hcvisitbean = hcvisitbean;
    }

    public SessionParamBean getSessionParam() {
        return sessionParam;
    }

    public void setSessionParam(SessionParamBean sessionParam) {
        this.sessionParam = sessionParam;
    }

    public List<ISCBean> getChatList() {
        return chatList;
    }

    public void setChatList(List<ISCBean> chatList) {
        this.chatList = chatList;
    }


}
