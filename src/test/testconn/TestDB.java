package testconn;

import logic.appcontroller.SignupController;
import logic.beans.Customerbean;
import org.junit.jupiter.api.Test;

class TestDB {

    @Test
    void assertCustomerInsert(){

        Customerbean customer = new Customerbean ("Marcello","Tarei","mtarei@gmail.com","1234");
        SignupController controller = new SignupController();

        controller.signup(customer);
    }
}
