package logic.viewcontroller.search;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.appcontroller.SearchController;
import logic.beans.SearchBean;
import logic.homechefutil.HomeChefUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchViewController {
    protected SearchController controller ;
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
        List<String> paramSearch = new ArrayList<>();
        paramSearch.add(cityChef.getText().toUpperCase());
        paramSearch.add(chefName.getText().toUpperCase());
        paramSearch.add(eatName.getText().toUpperCase());
        paramSearch = HomeChefUtil.setFormat(paramSearch);
        paramSearch = HomeChefUtil.setAp(paramSearch);
        searchBean.setChefCity(paramSearch.get(0));
        searchBean.setChefName(paramSearch.get(1));
        searchBean.setChefBestDish(paramSearch.get(2));
        return searchBean;
    }

    protected abstract void search(ActionEvent event);
}
