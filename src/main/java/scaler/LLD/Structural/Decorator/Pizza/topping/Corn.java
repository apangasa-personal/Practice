package scaler.LLD.Structural.Decorator.Pizza.topping;

import scaler.LLD.Structural.Decorator.Pizza.Pizza;

public class Corn implements Pizza{
    Pizza pizza;

    public Corn(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return this.pizza.getCost() + 0.59;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "Sweet Corn ";
    }

    @Override
    public int getCrustCount() {
        return this.pizza.getCrustCount();
    }
}
