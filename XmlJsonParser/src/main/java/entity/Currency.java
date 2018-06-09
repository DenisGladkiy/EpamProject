package entity;

/**
 * Created by Denis on 08.06.2018.
 */
public class Currency {
    private String name;
    private float rate;
    private String id;

    public Currency() {
    }

    public Currency(String name, float rate, String id) {
        this.name = name;
        this.rate = rate;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
