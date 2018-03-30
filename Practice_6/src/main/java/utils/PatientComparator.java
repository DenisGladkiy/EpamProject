package utils;

import mainClasses.model.Patient;

import java.util.Comparator;

/**
 * Created by Denis on 02.03.2018.
 */
public class PatientComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient p1, Patient p2) {
        String name1 = p1.getSurname();
        String name2 = p2.getSurname();
        return name1.compareTo(name2);
    }
}
