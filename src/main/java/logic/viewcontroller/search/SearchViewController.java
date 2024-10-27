package logic.viewcontroller.search;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.beans.SearchBean;

public abstract class SearchViewController {
    @FXML
    protected TextField eatName;
    @FXML
    protected TextField chefName;
    @FXML
    protected TextField cityChef;

    protected SearchBean setBean(){
        SearchBean searchBean = new SearchBean();
        searchBean.setChefCity(this.cityChef.getText().toUpperCase());
        searchBean.setChefName(this.chefName.getText().toUpperCase());
        searchBean.setChefBestDish(this.eatName.getText().toUpperCase());
        return searchBean;
    }
}
