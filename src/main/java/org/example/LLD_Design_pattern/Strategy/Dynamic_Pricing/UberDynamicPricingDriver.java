package org.example.LLD_Design_pattern.Strategy.Dynamic_Pricing;

public class UberDynamicPricingDriver
{
    public static void main(String[] args)
    {
        Price price =
                new HolidayPrice(new WeatherPrice(new PlainPrice()));

        System.out.println("Price is " + price.price());
        System.out.println("Description :: " + price.getDescription());
    }
}
