package logic.dao.query;


import logic.model.Book;

public class BookQuery {
    public String selectQueryBYId(long idBook){
        return String.format("select * from book WHERE idbook= %d", idBook);
    }

    public String selectAllQuery(){
        return "select * from book";
    }

    public String selectAllByOPenApproved(long idChef){
        return String.format("select * from book where chef= %d && (stato='APPROVED' OR stato='OPEN')", idChef);
    }

    public String insertQuery(long customer,long chef,
                String state, String meal,String citta,String via, String data){
        return String.format("insert into book (customer,chef,stato,data,pasto,citta,via) VALUES (%d,%d,'%s','%s','%s','%s','%s')", customer,chef,
                state,data, meal ,citta,via);
    }

    public String updateQuery(Book book, String data, long idBook){
        return String.format("UPDATE book SET customer = %d,chef = %d, stato='%s',data='%s',pasto='%s',citta='%s',via='%s'  WHERE idbook = %d", book.getCustomer(),book.getChef(),book.getBookState().toString(),data,book.getMeal().toString(),book.getCitta(),book.getVia(), idBook);
    }

    public String deleteQuery(long id){
        return String.format("DELETE book WHERE idbook = %d", id);
    }

    public String selectAllByCustQuery(long idCustomer){
        return String.format("SELECT * FROM book WHERE customer = %d", idCustomer);
    }

    public String getAllByChefDate(long idChef,String date){
        return String.format( "SELECT * FROM book WHERE chef = %d && data = '%s' && (stato= 'OPEN' OR stato = 'APPROVED')", idChef, date);
    }
}
