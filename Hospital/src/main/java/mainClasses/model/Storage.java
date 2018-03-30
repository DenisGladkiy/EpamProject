package mainClasses.model;

import utils.PatientComparator;
import java.util.Arrays;

/**
 * Created by Denis on 01.03.2018.
 */
public class Storage {

    private Patient[] patients;
    private Patient[] requestedPatients;

    public void initializeStorage(int size){
        patients = new Patient[size];
        requestedPatients = new Patient[size];
    }

    public void addPatient(Patient patient){
        int index = 0;
        for(; index < patients.length; index++){
            if(null == patients[index]){
                break;
            }
        }
        patients[index] = patient;
        if(index == patients.length - 1){
            patients = doubleArrayLength(patients);
        }
    }

    public Patient[] selectByIllness(String illness){
        Arrays.fill(requestedPatients, null);
        int arrIndex = 0;
        for(Patient p : patients){
            if((null != p) && (p.getIllness().equalsIgnoreCase(illness))){
                requestedPatients[arrIndex] = p;
                arrIndex++;
            }
        }
        if(null != requestedPatients[0]) {
            return Arrays.copyOf(requestedPatients, arrIndex);
        }else{
            return null;
        }
    }

    public Patient[] showAllPatients(){
        return Arrays.copyOf(patients, patients.length);
    }

    public Patient[] selectByNumber(int[] numbers){
        if(isInRange(numbers)) {
            Arrays.fill(requestedPatients, null);
            int arrIndex = 0;
            for (Patient p : patients) {
                if (null != p) {
                    int pNumber = p.getNumber();
                    if (pNumber >= (numbers[0]) && pNumber <= numbers[1]) {
                        requestedPatients[arrIndex] = p;
                        arrIndex++;
                    }
                } else {
                    break;
                }
            }
            return Arrays.copyOf(requestedPatients, arrIndex);
        }else{
            return null;
        }
    }

    public Patient[] sortArray(){
        int index = 0;
        while(null != patients[index]) {
            index++;
        }
        requestedPatients = Arrays.copyOf(patients, index);
        Arrays.sort(requestedPatients, new PatientComparator());
        return requestedPatients;
    }

    private boolean isInRange(int[] numbers){
        int num1 = numbers[0];
        int num2 = numbers[1];
        if((num1 >= 1) && (num1 <= patients.length-1)){
            if((num2 >= 1) && (num2 <= patients.length-1)){
                return true;
            }
        }
        return false;
    }

    private Patient[] doubleArrayLength(Patient[] patients){
        Patient[] newPatients = new Patient[patients.length * 2];
        System.arraycopy(patients, 0, newPatients, 0, patients.length);
        return newPatients;
    }
}
