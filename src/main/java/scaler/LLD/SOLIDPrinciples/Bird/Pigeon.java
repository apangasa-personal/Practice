package scaler.LLD.SOLIDPrinciples.Bird;

public class Pigeon extends Bird implements CanEat, FlyableBird, MakeSound{
    FlyingBehavior flyingBehavior;

    public Pigeon(FlyingBehavior flyingBehavior) {
        this.flyingBehavior = flyingBehavior;
    }

    @Override
    public void eat() {
        System.out.println("eating grains as pigeon");
    }

    @Override
    public void fly() {
        flyingBehavior.makeFly();
    }

    @Override
    public void makeSound() {
        System.out.println("making sound as pigeon");
    }
}
