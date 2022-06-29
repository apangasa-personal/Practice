package scaler.LLD.Structural.Decorator.Pizza.crust;

import scaler.LLD.Structural.Decorator.Pizza.Pizza;

import java.security.InvalidParameterException;

public class PanCrust implements Pizza {
    Pizza pizza;
    public PanCrust(){

    }

    public PanCrust(Pizza pizza) {
        this.pizza = pizza;
        if(this.pizza.getCrustCount() == 2)
            throw new InvalidParameterException("Cannot add more than 2 base");

    }

    @Override
    public double getCost() {
        if(pizza == null)
            return .39;
        return this.pizza.getCost() + .39;
    }

    @Override
    public String getDescription() {
        if(pizza == null)
            return "Pan Crust ";
        return this.pizza.getDescription() + "Pan Crust ";
    }

    @Override
    public int getCrustCount() {
        if(pizza == null)
            return 1;
        return this.pizza.getCrustCount() + 1;
    }
}
