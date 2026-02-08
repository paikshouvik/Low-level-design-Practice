package org.example.LLD_Design_pattern.Observer.Stock_Market_Updates;

// The Subject Interface
interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
