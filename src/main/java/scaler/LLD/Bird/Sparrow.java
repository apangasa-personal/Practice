package scaler.LLD.Bird;

public class Sparrow extends Bird implements CanEat, FlyableBird, MakeSound{
    FlyingBehavior flyingBehavior;

    public Sparrow(FlyingBehavior flyingBehavior) {
        this.flyingBehavior = flyingBehavior;
    }

    @Override
    public void eat() {
        System.out.println("eating grains as sparrow");
    }

    @Override
    public void fly() {
        flyingBehavior.makeFly();
    }

    @Override
    public void makeSound() {
        System.out.println("making sound as sparrow");
    }
}
