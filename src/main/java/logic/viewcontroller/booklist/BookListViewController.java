package logic.viewcontroller.booklist;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.beans.BookBean;
import logic.beans.ResultSearchBean;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;

import java.awt.print.Book;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class BookListViewController {


    @FXML
    protected AnchorPane anchorPane;
    @FXML
    protected Button loadNext;
    @FXML
    protected Button loadPrevious;
    protected int lastIndexChef;
    protected int elementViewed;
    protected static final int MAXCHEFVIEWED = 4;
    protected   int g1Index;
    protected   int g2Index;
    protected   int g3Index;
    protected   int g4Index;
    protected static final int SUBGROUPINDEX = 1;
    protected static final int STATUSINDEX = 0;
    protected static final int DATEINDEX = 1;
    protected static final int CHEFNAMEINDEX = 2;

    protected List<BookBean> bookList;
    protected Map<String, BookBean> bookBeanMap;

    protected PageMenu pageSwitch;

    @FXML
    protected void refBook(){
        //metodo che rifiuta una prenotazione
    }
    @FXML
    protected void acceptBook(){
        //metodo che accetta una prenotazione
    }
    @FXML
    protected void outputValPrevious(){
        //to be implemented
    }
    @FXML
    protected void outputVal(){
        //To be implemented
    }
    protected void setNextFourBook(){

        int index = 0;
        while (index < MAXCHEFVIEWED && lastIndexChef < bookList.size()) {

            BookBean bookBean = bookList.get(lastIndexChef);
            Group current = (Group) anchorPane.getChildren().get(g1Index+index);
            this.bookBeanMap.put(current.getId(),bookBean);
            Group subGroup = (Group) current.getChildren().get(SUBGROUPINDEX);
            ObservableList<Node> paramList = subGroup.getChildren();
            Text status = (Text)paramList.get(STATUSINDEX);
            Text nameChef = (Text)paramList.get(CHEFNAMEINDEX);
            Text bookDate = (Text)paramList.get(DATEINDEX);
            status.setText(bookBean.getBookState().toString());
            nameChef.setText(bookBean.getChef().getName()+" "+bookBean.getChef().getSurname());
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
            bookDate.setText(df.format(bookBean.getData()));
            current.setOpacity(1.0);
            index++;
            lastIndexChef++;
        }
        this.elementViewed=index;
        HomeChefUtil.disEnButtonNext(this.loadNext,lastIndexChef,bookList.size());
        HomeChefUtil.disEnButtonPrev(this.loadPrevious,lastIndexChef,MAXCHEFVIEWED);
    }
}
