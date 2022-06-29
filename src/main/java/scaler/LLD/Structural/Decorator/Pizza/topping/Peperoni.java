package scaler.LLD.Structural.Decorator.Pizza.topping;

import scaler.LLD.Structural.Decorator.Pizza.Pizza;

public class Peperoni implements Pizza {
    Pizza pizza;

    public Peperoni(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return this.pizza.getCost() + 0.99;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + "Peperoni ";
    }

    @Override
    public int getCrustCount() {
        return this.pizza.getCrustCount();
    }
}
