package dao.entity;

/**
 * Created by Denis on 23.04.2018.
 */
public class Task implements Entity {
    private int number;
    private String description;
    private int employeeNumber;

    public Task(int number, String description, int employeeNumber) {
        this.number = number;
        this.description = description;
        this.employeeNumber = employeeNumber;
    }

    public Task() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                ", description='" + description + '\'' +
                ", employeeNumber=" + employeeNumber +
                '}';
    }
}
