package logic.dao.query;

public class ChatQuery {

    public String selectQueryByChef(long chef) {
        return String.format("SELECT * FROM chat WHERE chef=%d", chef);
    }

    public String selectQueryByCustomer(long customer) {
        return String.format("SELECT * FROM chat WHERE customer=%d", customer);
    }


    public String insertQuery(long idChef, long idCustomer) {
        return String.format("INSERT INTO chat (customer,chef) VALUES (%d,%d)", idCustomer, idChef);
    }

    public String getSelectChatByChefcust(long idCustomer, long idChef) {
        return String.format("SELECT * FROM chat WHERE customer = %d && chef = %d", idCustomer, idChef);
    }
}
