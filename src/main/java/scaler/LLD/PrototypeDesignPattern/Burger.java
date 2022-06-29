package scaler.LLD.PrototypeDesignPattern;

public class Burger implements Cloneable<Burger>{
    private int price;
    private int cost;

    public Burger() {

    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Burger(Burger target){
        this.price = target.price;
        this.cost = target.cost;
    }

    @Override
    public Burger clone() {
       return new Burger(this);
    }
}
