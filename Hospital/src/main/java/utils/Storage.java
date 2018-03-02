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
    }

    public static Patient[] getPatients(){
        return patients;
    }



}
