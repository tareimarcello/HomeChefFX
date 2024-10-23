package testconn;

import logic.appcontroller.SearchController;
import logic.appcontroller.SignupController;
import logic.beans.Customerbean;
import logic.beans.SearchBean;
import org.junit.jupiter.api.Test;

class TestDB {

    @Test
    void testCustomerInsert(){
        //metti assert
        Customerbean customer = new Customerbean ("Marcello","Tarei","marcellotarei1@gmail.com","1234");
        SignupController controller = new SignupController();

        controller.signup(customer);
    }

    @Test
    void testChefSearch(){
        //metti assert
        SearchBean bean = new SearchBean();
        bean.setChefCity("ROMA");
        bean.setChefBestDish("lungarotti");
        bean.setChefName("CHEF4");
        SearchController controller = new SearchController();
        controller.searchChefList(bean);

    }
}
