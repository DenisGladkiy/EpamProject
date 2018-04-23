package dao.entity;

/**
 * Created by Denis on 23.04.2018.
 */
public class Department implements Entity {
    private int number;
    private String name;
    private String phone;

    public Department(int number, String name, String phone) {
        this.number = number;
        this.name = name;
        this.phone = phone;
    }

    public Department() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Department{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
