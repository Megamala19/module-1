import java.util.*;

interface Observer {
    void update(double price);
}

interface Stock {
    void register(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void register(Observer o) {
        observers.add(o);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price);
        }
    }
}

class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket s = new StockMarket();

        s.register(new MobileApp());

        s.setPrice(2500);
    }
}
