package org.example.LLD_Design_pattern.Observer.Stock_Market_Updates;

import java.util.ArrayList;
import java.util.List;

class StockMarket implements Subject {
    private List<Observer> observers;
    private String stockSymbol;
    private double price;

    public StockMarket(String stockSymbol, double price) {
        this.observers = new ArrayList<>();
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    // Business logic: When price changes, trigger notification
    public void setPrice(double newPrice) {
        System.out.println("\n--- Stock Update: " + stockSymbol + " is now $" + newPrice + " ---");
        this.price = newPrice;
        notifyObservers();
    }
}