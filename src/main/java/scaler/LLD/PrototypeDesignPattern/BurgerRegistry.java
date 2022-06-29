package scaler.LLD.PrototypeDesignPattern;

import java.util.HashMap;

public class BurgerRegistry {
    private HashMap<String, Burger> burgerHashMap = new HashMap<>();

    public void registerBurger(String name, Burger burger){
        burgerHashMap.put(name, burger);
    }

    public Burger getBurger(String name){
        return burgerHashMap.get(name).clone();
    }
}
