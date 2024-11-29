package testlog;

import logic.appcontroller.SearchController;
import logic.beans.SearchBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.exceptions.NoResultFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchTest {

    public boolean searchTestSucc(){
        SearchController controller = new SearchController();
        SearchBean search = new SearchBean();
        search.setChefCity("Roma");
        search.setChefName("Tarei");
        search.setChefBestDish("Bocchettoni");
        try {
            controller.searchChefList(search);
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }catch(NoResultFoundException e){
            return false;
        }
        return true;
    }

    @Test
    void testSearchSuccess(){
        assertTrue(searchTestSucc());
    }
    @Test
    void testSearchFail(){
        assertFalse(searchTestSucc());
    }
}
