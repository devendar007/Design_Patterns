 import java.util.*;

interface StockObservable {
    void add(Observer obj);
    void remove(Observer obj);
    void notifyObservers();
    void setData(int data);
    int getData();
}

class IphoneStockObservable implements StockObservable {
    private int data;
    private List<Observer> list = new ArrayList<>();

    @Override
    public void add(Observer obj) {
        list.add(obj);
    }

    @Override
    public void remove(Observer obj) {
        list.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : list) {
            obj.update();
        }
    }

    @Override
    public void setData(int data) {
        boolean wasOutOfStock = this.data == 0;
        this.data += data;
        if (wasOutOfStock && this.data > 0) {
            notifyObservers();
        }
    }

    @Override
    public int getData() {
        return data;
    }
}

interface Observer {
    void update();
}

class IphoneObserver implements Observer {
    private StockObservable observable;

    IphoneObserver(StockObservable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Notification: iPhone stock available = " + observable.getData());
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockObservable iphone = new IphoneStockObservable();

        Observer obj1 = new IphoneObserver(iphone);
        Observer obj2 = new IphoneObserver(iphone);

        iphone.add(obj1);
        iphone.add(obj2);

        iphone.setData(2);
    }
}
 
