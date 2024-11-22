package logic.viewcontroller.booklist;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.appcontroller.BookController;
import logic.beans.BookBean;
import logic.beans.SessionParamBean;
import logic.exceptions.ConnectionException;
import logic.exceptions.Exceptions;
import logic.homechefutil.HomeChefUtil;
import logic.model.Book;
import logic.pageswitch.PageMenu;
import logic.patterns.ViewSetter;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class BookListViewController {
    protected  static final BookController controller = new BookController();
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
    protected static final int MEALINDEX = 0;
    protected static final int CITYROUTEINDEX = 2;

    protected List<BookBean> bookList;
    protected Map<String, BookBean> bookBeanMap;

    protected PageMenu pageSwitch;

    @FXML
    protected void outputValPrevious(){
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        lastIndexBook-=(MAXBOOKVIEWED+elementViewed);
        this.setNextFourBook();
    }
    @FXML
    protected void outputVal(){
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.setNextFourBook();
    }
    @FXML
    protected void refBook(){
        //metodo che rifiuta una prenotazione
    }
    @FXML
    protected void acceptBook(ActionEvent event){
        Button clicked = (Button) event.getSource();
        BookBean bean = this.bookBeanMap.get(clicked.getParent().getParent().getId());
        bean.setBookState(Book.BookStatus.APPROVED);
        try {
            controller.updateChefBook(bean);
            clicked.setVisible(false);
            clicked.getParent().getChildrenUnmodifiable().get(3).setVisible(false);
        }catch(ConnectionException e){
            Exceptions.exceptionConnectionOccurred();
        }
    }
    protected void setNextFourBook(){

        int index = 0;
        while (index < MAXBOOKVIEWED && lastIndexBook < bookList.size()) {

            BookBean bookBean = bookList.get(lastIndexBook);
            Group current = (Group) anchorPane.getChildren().get(g1Index+index);
            this.bookBeanMap.put(current.getId(),bookBean);
            if(ViewSetter.getSessionParam().getUserType()== SessionParamBean.UserType.CUSTOMER) {
                List<Text> textList = HomeChefUtil.getListGroup(current, SUBGROUPINDEXBOOK, STATUSINDEX, CHEFNAMEINDEX, DATEINDEX);
                textList.get(0).setText(bookBean.getBookState().toString());
                textList.get(1).setText(bookBean.getChef().getName() + " " + bookBean.getChef().getSurname());
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                textList.get(2).setText(df.format(bookBean.getData()) + " - " + bookBean.getMeal());
            }else{
                List<Text> textList = HomeChefUtil.getListGroup(current, SUBGROUPINDEXBOOK, MEALINDEX, CITYROUTEINDEX, DATEINDEX);
                textList.get(0).setText(bookBean.getVia());
                textList.get(1).setText(bookBean.getCitta());
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                textList.get(2).setText(df.format(bookBean.getData()) + " - " + bookBean.getMeal());
                if(bookBean.getBookState().equals(Book.BookStatus.APPROVED)){
                    Group subGroupBook = (Group) current.getChildren().get(SUBGROUPINDEXBOOK);
                    subGroupBook.getChildren().get(3).setVisible(false);
                    subGroupBook.getChildren().get(4).setVisible(false);
                }
            }
            current.setOpacity(1.0);
            index++;
            lastIndexBook++;
        }
        this.elementViewed=index;
        HomeChefUtil.disEnButtonNext(this.loadNext,lastIndexBook,bookList.size());
        HomeChefUtil.disEnButtonPrev(this.loadPrevious,lastIndexBook,MAXBOOKVIEWED);
    }
}
