package scaler.LLD.Bird;

public class Crow extends Bird implements CanEat, FlyableBird, MakeSound{
    FlyingBehavior flyingBehavior;

    public Crow(FlyingBehavior flyingBehavior) {
        this.flyingBehavior = flyingBehavior;
    }

    @Override
    public void eat() {
        System.out.println("eating grains as crow");
    }

    @Override
    public void fly() {
        flyingBehavior.makeFly();
    }

    @Override
    public void makeSound() {
        System.out.println("making sound as crow");
    }
}
