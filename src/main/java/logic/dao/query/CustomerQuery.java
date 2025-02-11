package logic.dao.query;

public class CustomerQuery {

    public String selectCustomerQuery(long id){
        return String.format("SELECT * FROM customer JOIN user ON (customer.idUser=user.iduser) WHERE customer.idUser=%d", id);
    }

    public String selectAllCustomersQuery(){
        return String.format("SELECT * FROM customer");
    }

    public String updateCustomerQuery(long id, boolean bookNot){
        return String.format("UPDATE customer SET bookNot = %b WHERE idUser=%d", bookNot, id);  //testa boolean
    }
    public String deleteCustomerQuery(long id){
        return String.format("DELETE FROM customer WHERE idUser=%d", id);
    }
}
