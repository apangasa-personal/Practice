package scaler.LLD.SOLIDPrinciples.Bird;

public class Penguin extends Bird implements CanEat, MakeSound{
    FlyingBehavior flyingBehavior;

    public Penguin(){
    }

    @Override
    public void eat() {
        System.out.println("eating grains as penguin");
    }

    @Override
    public void makeSound() {
        System.out.println("making sound as penguin");
    }
}
