package scaler.LLD.SOLIDPrinciples.Bird;

public class PigeonFlyingBehavior extends FlyingBehavior implements FlyingBehaviorInterface{
    @Override
    public void makeFly() {
        System.out.println("flying now as pigeon");
    }
}
