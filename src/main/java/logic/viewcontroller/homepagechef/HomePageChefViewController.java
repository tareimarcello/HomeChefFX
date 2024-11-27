package logic.viewcontroller.homepagechef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.beans.HomeChefBean;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

public class HomePageChefViewController {
    protected PageMenu pageswitch;
    @FXML
    protected  TextField name;
    @FXML
    protected TextField dish;
    @FXML
    protected TextField res;
    @FXML
    protected TextField city;

    protected void setFields(){
        HomeChefBean hcbean = ViewSetter.getHcbean();

        if (hcbean!=null) {

            this.name.setText(hcbean.getName());
            this.dish.setText(hcbean.getDish());
            this.res.setText(hcbean.getRes());
            this.city.setText(hcbean.getCity());

        }
    }
}
