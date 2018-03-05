package mainClasses;

import utils.PatientComparator;
import utils.Storage;
import utils.Writer;

import java.util.Arrays;

/**
 * Created by Denis on 01.03.2018.
 */
public class Controller {

    private Patient[] patients;
    private Patient[] requestedPatients;
    private UserInterface userInterface;

    public Controller(UserInterface userInterface){
        this.userInterface = userInterface;
        patients = Storage.getPatients();
        requestedPatients = new Patient[patients.length];
    }

    public String handle(String request){
        switch (request){
            case "0" : {
                return prepareReply(patients);
            }
            case "1" : {
                String illness = userInterface.askIllness();
                return selectByIllness(illness);
            }
            case "2" : {
                int[] numbers = userInterface.askNumbers();
                if(isInRange(numbers)) {
                    return selectByNumber(numbers[0], numbers[1]);
                }else{
                    return "Запрошенные номера за пределами доступного диапазона";
                }
            }
            case "3" : {
                return sortArray();
            }
            default:{
                System.out.println("Неизвестный запрос");
            }
        }
        return "";
    }

    private String selectByIllness(String illness){
        Arrays.fill(requestedPatients, null);
        int arrIndex = 0;
        for(Patient p : patients){
            if((null != p) && (p.getIllness().equalsIgnoreCase(illness))){
                requestedPatients[arrIndex] = p;
                arrIndex++;
            }
        }
        if(null != requestedPatients[0]) {
            return Arrays.toString(Arrays.copyOf(requestedPatients, arrIndex));
        }else{
            return "Нет пациентов с таким диагнозом";
        }
    }

    private String selectByNumber(int from, int to){
        Arrays.fill(requestedPatients, null);
        int arrIndex = 0;
        for(Patient p : patients){
            if(null != p) {
                int pNumber = p.getNumber();
                if (pNumber >= (from) && pNumber <= to) {
                    requestedPatients[arrIndex] = p;
                    arrIndex++;
                }
            }
        }
        return Arrays.toString(Arrays.copyOf(requestedPatients,arrIndex));
    }

    private String sortArray(){
        int index = 0;
        while(null != patients[index]) {
            index++;
        }
        requestedPatients = Arrays.copyOf(patients, index);
        Arrays.sort(requestedPatients, new PatientComparator());
        return Arrays.toString(requestedPatients);
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

    private String prepareReply(Patient[] patients){
        StringBuilder stringBuilder = new StringBuilder();
        for(Patient patient : patients){
            if(null != patient){
                stringBuilder.append(patient.toString());
            }
        }
        return stringBuilder.toString();
    }


}
