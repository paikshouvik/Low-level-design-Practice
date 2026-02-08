package org.example.LLD_Design_pattern.Observer.Stock_Market_Updates;

public class StockSystem {
    public static void main(String[] args) {
        // 1. Create the Subject (Apple Stock)
        StockMarket appleStock = new StockMarket("AAPL", 145.00);

        // 2. Create Observers
        Observer phoneApp = new MobileAppDisplay();
        Observer bot = new TradingBot();

        // 3. Register Observers
        appleStock.registerObserver(phoneApp);
        appleStock.registerObserver(bot);

        // 4. Simulate Price Changes
        appleStock.setPrice(148.50);
        appleStock.setPrice(152.00); // This should trigger the Bot's sell logic

        // 5. Unregister an observer and update again
        appleStock.removeObserver(phoneApp);
        appleStock.setPrice(155.00);
    }
}