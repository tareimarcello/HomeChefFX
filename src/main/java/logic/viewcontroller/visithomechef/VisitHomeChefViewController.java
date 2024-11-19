package logic.viewcontroller.visithomechef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import logic.appcontroller.VisitHomeChefController;
import logic.beans.HomeChefBean;
import logic.beans.IsHomeVisitBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

public abstract class VisitHomeChefViewController {
    protected  static final VisitHomeChefController controller = new VisitHomeChefController();
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
        hcbean  = ViewSetter.getHcvisitbean();

        if (hcbean!=null) {

            this.chefName.setText(hcbean.getName());
            this.bestDish.setText(hcbean.getDish());
            this.res.setText(hcbean.getRes());
            this.city.setText(hcbean.getCity());

        }
    }

    protected void launchController(){
        try {
            controller.loadChat(this.hcbean);
        } catch (ConnectionException e) {
            Exceptions.exceptionConnectionOccurred();
        }
        IsHomeVisitBean ishBean = new IsHomeVisitBean();
        ishBean.setHome(true);
        ViewSetter.setIsHomeVisitBean(ishBean);
    }
}
