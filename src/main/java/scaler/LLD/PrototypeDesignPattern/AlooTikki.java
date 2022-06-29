package scaler.LLD.PrototypeDesignPattern;

public class AlooTikki extends Burger{
    public String getTikki() {
        return tikki;
    }

    private String tikki = "Potato";

    public String getBun() {
        return bun;
    }

    private String bun = "Plain Bun";
    private String veggies = "Onion, Tomato";

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

    private String sauces = "Thousand Island, Mayo";

    public AlooTikki(){};

    public AlooTikki(AlooTikki target) {
        super(target);
        this.tikki = target.tikki;
        this.bun = target.bun;
        this.sauces = target.sauces;
        this.veggies = target.veggies;
    }

    @Override
    public AlooTikki clone() {
        return new AlooTikki(this);
    }
}
