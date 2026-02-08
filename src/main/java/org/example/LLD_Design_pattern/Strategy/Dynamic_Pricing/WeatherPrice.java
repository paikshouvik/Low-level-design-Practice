package org.example.LLD_Design_pattern.Strategy.Dynamic_Pricing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherPrice implements Price {

    private Price price;

    @Override
    public String getDescription() {
        return "Weather " + (price!=null? price.getDescription():"");
    }

    @Override
    public double price() {
        return 1.2 *  price.price();
    }
    
}
