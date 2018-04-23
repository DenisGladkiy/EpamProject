package dao.entity;

/**
 * Created by Denis on 23.04.2018.
 */
public class Employee implements Entity {
    private int number;
    private String surname;
    private String name;
    private String position;
    private int depNumber;

    public Employee(int number, String surname, String name, String position, int depNumber) {
        this.number = number;
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.depNumber = depNumber;
    }

    public Employee() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepNumber() {
        return depNumber;
    }

    public void setDepNumber(int depNumber) {
        this.depNumber = depNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "number=" + number +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", depNumber=" + depNumber +
                '}';
    }
}
