package org.example.LLD_Design_pattern.Observer.Stock_Market_Updates;

class TradingBot implements Observer {
    private double threshold = 150.00;

    @Override
    public void update(String stockSymbol, double price) {
        if (price > threshold) {
            System.out.println("[Trading Bot] Alert: Price above threshold! Selling " + stockSymbol);
        } else {
            System.out.println("[Trading Bot] Monitoring: " + stockSymbol + " at $" + price);
        }
    }
}
