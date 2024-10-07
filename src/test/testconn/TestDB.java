package testconn;

import logic.appcontroller.SignupController;
import logic.beans.Customerbean;
import org.junit.jupiter.api.Test;

class TestDB {

    @Test
    void testCustomerInsert(){
        //metti assert
        Customerbean customer = new Customerbean ("Marcello","Tarei","marcellotarei1@gmail.com","1234");
        SignupController controller = new SignupController();

        controller.signup(customer);
    }
}
