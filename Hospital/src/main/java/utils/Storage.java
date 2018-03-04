package utils;

import mainClasses.Patient;

/**
 * Created by Denis on 01.03.2018.
 */
public class Storage {

    private static Patient[] patients;

    public void initializeStorage(int size){
        if(null == patients){
            patients = new Patient[size];
        }
    }

    public void addPatient(Patient patient){
        int index = 0;
        for(int i = 0; i < patients.length; i++){
            if(null == patients[i]){
                index = i;
                break;
            }
        }
        patients[index] = patient;
        if(index == patients.length - 1){
            patients = doubleArrayLength(patients);
        }
    }

    public static Patient[] getPatients(){
        return patients;
    }

    private Patient[] doubleArrayLength(Patient[] patients){
        Patient[] newPatients = new Patient[patients.length * 2];
        System.arraycopy(patients, 0, newPatients, 0, patients.length);
        return newPatients;
    }

}
