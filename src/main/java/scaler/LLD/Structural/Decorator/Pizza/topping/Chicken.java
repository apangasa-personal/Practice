package scaler.LLD.Structural.Decorator.Pizza.topping;

import scaler.LLD.Structural.Decorator.Pizza.Pizza;

public class Chicken implements Pizza{
    Pizza pizza;

    public Chicken(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return this.pizza.getCost() + 0.79;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "Chicken ";
    }

    @Override
    public int getCrustCount() {
        return this.pizza.getCrustCount();
    }
}
