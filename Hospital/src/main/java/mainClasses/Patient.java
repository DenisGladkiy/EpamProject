package mainClasses;

import java.util.Arrays;

/**
 * Created by Denis on 01.03.2018.
 */
public class Patient {

    private String surname;
    private String name;
    private String secondName;
    private String address;
    private String phone;
    private int number;
    private String illness;

    public Patient(String[] patient) {
        surname = patient[0];
        name = patient[1];
        secondName = patient[2];
        address = patient[3];
        phone = patient[4];
        number = Integer.parseInt(patient[5]);
        illness = patient[6];
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return
                "\n " + number +
                " " +surname +
                " " + name +
                " " + secondName + "\n" +
                " " + address + "\n" +
                " " + phone + "\n" +
                " " + illness + "\n";
    }
}
