package org.example.LLD_Design_pattern.Observer.Stock_Market_Updates;

class MobileAppDisplay implements Observer {


    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[Mobile App] Notification: " + stockSymbol + " price updated to $" + price);
    }



}

