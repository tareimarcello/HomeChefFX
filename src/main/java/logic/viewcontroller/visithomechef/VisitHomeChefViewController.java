package logic.viewcontroller.visithomechef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.beans.HomeChefBean;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

public abstract class VisitHomeChefViewController {
    protected PageMenu pageSwitch;
    @FXML
    protected TextField chefName;
    @FXML
    protected TextField bestDish;
    @FXML
    protected TextField res;
    @FXML
    protected TextField city;

    protected HomeChefBean hcbean;

    protected void downLoadHcBean(){
        hcbean  = ViewSetter.getInstance().getHcvisitbean();

        if (hcbean!=null) {

            this.chefName.setText(hcbean.getName());
            this.bestDish.setText(hcbean.getDish());
            this.res.setText(hcbean.getRes());
            this.city.setText(hcbean.getCity());

        }
    }
}
