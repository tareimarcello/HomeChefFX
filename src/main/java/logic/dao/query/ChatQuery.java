package logic.dao.query;

public class ChatQuery {


    public String selectAllChatQuery() {
        return "SELECT * FROM chat";
    }

    public String selectQueryByChef(long chef) {
        return String.format("SELECT * FROM chat WHERE chef=%d", chef);
    }

    public String selectQueryByCustomer(long customer) {
        return String.format("SELECT * FROM chat WHERE customer=%d", customer);
    }

    public String selectChat(long idchat) {
        return String.format("SELECT * FROM chat WHERE idchat=%d", idchat);
    }

    public String insertQuery(long idChef, long idCustomer) {
        return String.format("INSERT INTO chat (customer,chef) VALUES (%d,%d)",idCustomer,idChef);
    }

    public String updateChatQuery(long idCustomer, long idChef, long idChat) {
        return String.format("UPDATE chat SET customer = %d,chef = %d  WHERE idchat = %d",idCustomer,idChef,idChat);
    }

    public String deleteQuery(long idChat){
       return String.format("DELETE FROM chat WHERE idchat=%d", idChat);
    }

    public String getSelectChatByChefcust(long idCustomer, long idChef) {
        return String.format("SELECT * FROM chat WHERE customer = %d && chef = %d", idCustomer, idChef);
    }
}
