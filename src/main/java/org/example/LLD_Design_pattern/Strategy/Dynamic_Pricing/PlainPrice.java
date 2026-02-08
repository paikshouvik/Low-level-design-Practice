package org.example.LLD_Design_pattern.Strategy.Dynamic_Pricing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlainPrice implements Price {

    @Override
    public String getDescription() {
        return "Price";
    }

    @Override
    public double price() {
        return 10;
    }


}
