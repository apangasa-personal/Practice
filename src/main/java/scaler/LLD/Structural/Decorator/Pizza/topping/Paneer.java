package scaler.LLD.Structural.Decorator.Pizza.topping;

import scaler.LLD.Structural.Decorator.Pizza.Pizza;

public class Paneer implements Pizza{
    Pizza pizza;

    public Paneer(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return this.pizza.getCost() + 0.49;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "Paneer ";
    }

    @Override
    public int getCrustCount() {
        return this.pizza.getCrustCount();
    }
}
