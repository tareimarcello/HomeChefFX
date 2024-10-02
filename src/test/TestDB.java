import logic.appcontroller.SignupController;
import logic.beans.Customerbean;
import logic.connection.ConfigFileReader;
import org.junit.jupiter.api.Test;

public class TestDB {

    @Test
    public void testConfigFile(){

        ConfigFileReader conf = new ConfigFileReader();

    }
    @Test
    public void testCustomerInsert(){

        Customerbean customer = new Customerbean ("Marcello","Tarei","mtarei@gmail.com","1234");
        SignupController controller = new SignupController();

        controller.signup(customer);
    }
}
