package entity;

/**
 * Created by Denis on 08.06.2018.
 */
public class Currency {
    private String name;
    private float rate;

    public Currency() {
    }

    public Currency(String name, float rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
