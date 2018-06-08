package entity;

/**
 * Created by Denis on 08.06.2018.
 */
public class Person {
    private int id;
    private String name;
    private String address;
    private int cash;
    private String education;

    public Person() {
    }

    public Person(int id, String name, String address, int cash, String education) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cash = cash;
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cash=" + cash +
                ", education='" + education + '\'' +
                '}';
    }
}
