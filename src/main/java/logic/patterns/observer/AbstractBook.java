package logic.patterns.observer;

public class AbstractBook {

    private ObserverNotification observer;

    public void attach(ObserverNotification observer) {
        this.observer= observer;
    }

    public void detach(){
        this.observer = null;
    }

    public void notifyCustomer(){
        observer.update();
    }
}
