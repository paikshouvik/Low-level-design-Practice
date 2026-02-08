package org.example.LLD_Design_pattern.Strategy.Dynamic_Pricing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SurgePrice implements Price {

    private Price price;

    @Override
    public String getDescription() {
        return "Surge " +  price.getDescription();
    }

    @Override
    public double price() {
        return 1.1 *  price.price();
    }

}
