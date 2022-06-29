package scaler.LLD.PrototypeDesignPattern;

public class McVeggie extends Burger{
    private String tikki = "Peas,Tomato,Potato,Carrot";
    private String bun = "Sesame Seed Bun";
    private String veggies = "Onion, Tomato, Lettuce";
    private String sauces = "Thousand Island, Mayo, Chipotle, Vinegratti";

    public void setTikki(String tikki) {
        this.tikki = tikki;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setVeggies(String veggies) {
        this.veggies = veggies;
    }

    public void setSauces(String sauces) {
        this.sauces = sauces;
    }


    public McVeggie(){};

    public McVeggie(McVeggie target) {
        super(target);
        this.tikki = target.tikki;
        this.bun = target.bun;
        this.sauces = target.sauces;
        this.veggies = target.veggies;
    }

    @Override
    public McVeggie clone() {
        return new McVeggie(this);
    }
}
