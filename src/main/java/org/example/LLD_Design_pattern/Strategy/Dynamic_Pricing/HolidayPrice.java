package org.example.LLD_Design_pattern.Strategy.Dynamic_Pricing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HolidayPrice implements Price {

    private Price price;

    @Override
    public String getDescription() {
        return "Holiday " +  price.getDescription();
    }

    @Override
    public double price() {
        return 1.05 *  price.price();
    }
    
}
