package scaler.LLD.Bird;

public class Ostrich extends Bird implements CanEat, MakeSound{
    FlyingBehavior flyingBehavior;

    public Ostrich() {

    }

    @Override
    public void eat() {
        System.out.println("eating grains as ostrich");
    }

    @Override
    public void makeSound() {
        System.out.println("making sound as ostrich");
    }
}
