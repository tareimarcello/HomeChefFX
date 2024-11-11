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
        String [] words= this.chefName.getText().split(" ");
        searchBean.setChefCity(this.cityChef.getText().toUpperCase());
        searchBean.setChefName(words[0].toUpperCase());
        searchBean.setChefSurname(words[1].toUpperCase());
        searchBean.setChefBestDish(this.eatName.getText().toUpperCase());
        return searchBean;
    }
}
