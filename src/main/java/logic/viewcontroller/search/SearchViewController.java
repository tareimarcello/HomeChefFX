package logic.viewcontroller.search;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.appcontroller.SearchController;
import logic.beans.SearchBean;

public abstract class SearchViewController {
    protected static final SearchController controller = new SearchController();
    @FXML
    protected TextField eatName;
    @FXML
    protected TextField chefName;
    @FXML
    protected TextField cityChef;
    @FXML
    protected Label errMsg;

    protected SearchBean setBean(){
        SearchBean searchBean = new SearchBean();
        searchBean.setChefCity(this.cityChef.getText().toUpperCase());
        searchBean.setChefName(this.chefName.getText());
        searchBean.setChefBestDish(this.eatName.getText().toUpperCase());
        return searchBean;
    }


}
