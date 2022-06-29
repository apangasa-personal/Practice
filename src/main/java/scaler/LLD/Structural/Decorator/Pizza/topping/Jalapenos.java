package scaler.LLD.Structural.Decorator.Pizza.topping;

import scaler.LLD.Structural.Decorator.Pizza.Pizza;

public class Jalapenos implements Pizza {
    Pizza pizza;

    public Jalapenos(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return this.pizza.getCost() + 0.29;
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + "Jalepenos ";
    }

    @Override
    public int getCrustCount() {
        return this.pizza.getCrustCount();
    }
}
