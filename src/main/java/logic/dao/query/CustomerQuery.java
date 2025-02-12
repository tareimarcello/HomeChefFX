package logic.dao.query;

public class CustomerQuery {

    public String selectCustomerQuery(long id){
        return String.format("SELECT * FROM customer JOIN user ON (customer.idUser=user.iduser) WHERE customer.idUser=%d", id);
    }
    public String updateCustomerQuery(long id, boolean bookNot){
        return String.format("UPDATE customer SET bookNot = %b WHERE idUser=%d", bookNot, id);  //testa boolean
    }
}
