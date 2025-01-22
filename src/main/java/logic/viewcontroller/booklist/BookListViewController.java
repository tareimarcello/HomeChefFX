package logic.viewcontroller.booklist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.appcontroller.BookListController;
import logic.beans.BookListBean;
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

public class BookListViewController {
    protected BookListController controller;
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

    @FXML
    protected Label accBook;
    @FXML
    protected Label rejBook;

    protected List<BookListBean> bookList;
    protected Map<String, BookListBean> bookBeanMap;

    protected PageMenu pageSwitch;

    @FXML
    protected void outputValPrevious(){
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        lastIndexBook-=(MAXBOOKVIEWED+elementViewed);
        if(ViewSetter.getSessionParam().getUserType() == SessionParamBean.UserType.CHEF){
            accBook.setOpacity(0.0);
            rejBook.setOpacity(0.0);
        }
        this.setNextFourBook();
    }
    @FXML
    protected void outputVal(){
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        if(ViewSetter.getSessionParam().getUserType() == SessionParamBean.UserType.CHEF){
            accBook.setOpacity(0.0);
            rejBook.setOpacity(0.0);
        }
        this.setNextFourBook();
    }
    @FXML
    protected void refBook(ActionEvent event){
        accBook.setOpacity(0.0);
        Button clicked = (Button) event.getSource();
        BookListBean bean = this.bookBeanMap.get(clicked.getParent().getParent().getId());
        bean.setBookState(Book.BookStatus.REJECTED);
        try {
            controller.updateChefBook(bean);
            clicked.setVisible(false);
            clicked.getParent().getChildrenUnmodifiable().get(4).setVisible(false);
            rejBook.setOpacity(1.0);
            controller.loadBookList();
            bookList=ViewSetter.getBookList();
        }catch(ConnectionException e){
            Exceptions.exceptionConnectionOccurred();
        }

    }
    @FXML
    protected void acceptBook(ActionEvent event){
        rejBook.setOpacity(0.0);
        Button clicked = (Button) event.getSource();
        BookListBean bean = this.bookBeanMap.get(clicked.getParent().getParent().getId());
        bean.setBookState(Book.BookStatus.APPROVED);
        try {
            controller.updateChefBook(bean);
            clicked.setVisible(false);
            clicked.getParent().getChildrenUnmodifiable().get(3).setVisible(false);
            accBook.setOpacity(1.0);
            controller.loadBookList();
            bookList=ViewSetter.getBookList();
        }catch(ConnectionException e){
            Exceptions.exceptionConnectionOccurred();
        }
    }
    protected void setNextFourBook(){

        int index = 0;
        while (index < MAXBOOKVIEWED && lastIndexBook < bookList.size()) {

            BookListBean bookBean = bookList.get(lastIndexBook);
            Group current = (Group) anchorPane.getChildren().get(g1Index+index);
            this.bookBeanMap.put(current.getId(),bookBean);
            if(ViewSetter.getSessionParam().getUserType()== SessionParamBean.UserType.CUSTOMER) {
                List<Text> textList = HomeChefUtil.getListGroup(current, SUBGROUPINDEXBOOK, STATUSINDEX, CHEFNAMEINDEX, DATEINDEX);
                textList.get(0).setText(bookBean.getBookState().toString());
                textList.get(1).setText(bookBean.getChefBean().getName() + " " + bookBean.getChefBean().getSurname());
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                textList.get(2).setText(df.format(bookBean.getData()) + " - " + bookBean.getMeal());
            }else{
                List<Text> textList = HomeChefUtil.getListGroup(current, SUBGROUPINDEXBOOK, MEALINDEX, CITYROUTEINDEX, DATEINDEX);
                textList.get(0).setText(bookBean.getVia());
                textList.get(1).setText(bookBean.getCitta());
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                textList.get(2).setText(df.format(bookBean.getData()) + " - " + bookBean.getMeal());
                Group subGroupBook = (Group) current.getChildren().get(SUBGROUPINDEXBOOK);
                if(bookBean.getBookState().equals(Book.BookStatus.APPROVED)){
                    subGroupBook.getChildren().get(3).setVisible(false);
                    subGroupBook.getChildren().get(4).setVisible(false);
                }else{
                    subGroupBook.getChildren().get(3).setVisible(true);
                    subGroupBook.getChildren().get(4).setVisible(true);
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

    protected void initList(){
        lastIndexBook = 0;
        HomeChefUtil.resetGroupOpacity(this.anchorPane, this.g1Index,this.g2Index,this.g3Index,this.g4Index);
        this.loadNext.setVisible(false);
        this.loadPrevious.setVisible(false);
        this.setNextFourBook();
    }

}
