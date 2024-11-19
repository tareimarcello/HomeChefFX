package logic.viewcontroller.booklist;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.beans.BookBean;
import logic.homechefutil.HomeChefUtil;
import logic.pageswitch.PageMenu;

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
    protected int lastIndexBook;
    protected int elementViewed;
    protected static final int MAXBOOKVIEWED = 4;
    protected   int g1Index;
    protected   int g2Index;
    protected   int g3Index;
    protected   int g4Index;
    protected static final int SUBGROUPINDEXBOOK = 1;
    protected static final int STATUSINDEX = 0;
    protected static final int DATEINDEX = 1;
    protected static final int CHEFNAMEINDEX = 2;

    protected List<BookBean> bookList;
    protected Map<String, BookBean> bookBeanMap;

    protected PageMenu pageSwitch;

    @FXML
    protected void outputValPrevious(){
        //to be implemented
    }
    @FXML
    protected void outputVal(){
        //To be implemented
    }
    @FXML
    protected void refBook(){
        //metodo che rifiuta una prenotazione
    }
    @FXML
    protected void acceptBook(){
        //metodo che accetta una prenotazione
    }
    protected void setNextFourBook(){

        int index = 0;
        while (index < MAXBOOKVIEWED && lastIndexBook < bookList.size()) {

            BookBean bookBean = bookList.get(lastIndexBook);
            Group current = (Group) anchorPane.getChildren().get(g1Index+index);
            this.bookBeanMap.put(current.getId(),bookBean);
            List<Text> textList=HomeChefUtil.getListGroup(current,SUBGROUPINDEXBOOK,STATUSINDEX,CHEFNAMEINDEX,DATEINDEX);
            textList.get(0).setText(bookBean.getBookState().toString());
            textList.get(1).setText(bookBean.getChef().getName()+" "+bookBean.getChef().getSurname());
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
            textList.get(2).setText(df.format(bookBean.getData()));
            current.setOpacity(1.0);
            index++;
            lastIndexBook++;
        }
        this.elementViewed=index;
        HomeChefUtil.disEnButtonNext(this.loadNext,lastIndexBook,bookList.size());
        HomeChefUtil.disEnButtonPrev(this.loadPrevious,lastIndexBook,MAXBOOKVIEWED);
    }
}
