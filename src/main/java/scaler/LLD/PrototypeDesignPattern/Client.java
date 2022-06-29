package scaler.LLD.PrototypeDesignPattern;

public class Client {

    public static void main(String[] args) {
        Burger burger = new Burger();
        burger.setCost(20);
        burger.setPrice(30);

        AlooTikki alooTikki = new AlooTikki();
        alooTikki.setCost(15);
        alooTikki.setPrice(30);

        McVeggie mcVeggie = new McVeggie();
        mcVeggie.setCost(70);
        mcVeggie.setPrice(90);

        BurgerRegistry burgerRegistry = new BurgerRegistry();
        McVeggie mcVeggieExtraMayo = new McVeggie();
        mcVeggie.setCost(80);
        mcVeggie.setPrice(100);
        mcVeggieExtraMayo.setSauces("Thousand Island, Double Mayo, Chipotle, Vinegratti");

        AlooTikki alooTikkiSpicy = new AlooTikki();
        alooTikkiSpicy.setPrice(30);
        alooTikkiSpicy.setCost(20);
        alooTikkiSpicy.setTikki("Extra spicy potato tikki");

        burgerRegistry.registerBurger("mcVeggieExtraMayo", mcVeggieExtraMayo);
        burgerRegistry.registerBurger("alooTikkiSpicy", alooTikkiSpicy);

        Burger mcVeggieExtraMayo2 = burgerRegistry.getBurger("mcVeggieExtraMayo");
        Burger alooTikkiSpicy2 = burgerRegistry.getBurger("alooTikkiSpicy");
        AlooTikki a = (AlooTikki)alooTikkiSpicy2;
        System.out.println(a.getTikki());
        System.out.println("done");

    }
}
