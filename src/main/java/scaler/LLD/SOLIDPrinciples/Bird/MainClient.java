package scaler.LLD.SOLIDPrinciples.Bird;

public class MainClient {
    public static void main(String[] args) {

        Penguin penguin = new Penguin();

        Ostrich ostrich = new Ostrich();

        Pigeon pigeon = new Pigeon(new PigeonFlyingBehavior());

        Sparrow sparrow = new Sparrow(new CrowSparrowFlyingBehavior());

        Crow crow = new Crow(new CrowSparrowFlyingBehavior());

    }
}
