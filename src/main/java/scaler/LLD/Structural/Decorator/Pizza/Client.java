package scaler.LLD.Structural.Decorator.Pizza;

import scaler.LLD.Structural.Decorator.Pizza.crust.ThinCrust;
import scaler.LLD.Structural.Decorator.Pizza.topping.*;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new ThinCrust(new ThinCrust());
        pizza = new Chicken(pizza);
        pizza = new Chicken(pizza);
        pizza = new Jalapenos(pizza);
        pizza = new Corn(pizza);
        pizza = new Paneer(pizza);
        pizza = new Peperoni(pizza);
        System.out.println(pizza.getCost() + "," + pizza.getCrustCount() + "," + pizza.getDescription());


    }
}
