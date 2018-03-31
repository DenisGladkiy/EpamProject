package mainClasses.controller;

import mainClasses.model.Patient;
import mainClasses.model.Storage;
import mainClasses.view.UserInterface;
import mainClasses.serializer.PatientReader;
import mainClasses.serializer.PatientWriter;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Denis on 01.03.2018.
 */
public class Controller {
    private UserInterface userInterface;
    private PatientWriter patientWriter;
    private PatientReader patientReader;
    private Storage storage;
    private File file = new File("Practice_6/src/main/java/mainClasses/model/data");
    Patient[] requestedPatients;


    public Controller(Storage storage){
        this.storage = storage;
        userInterface = new UserInterface(this);
        patientWriter = new PatientWriter(file);
        patientReader = new PatientReader(file);
    }

    public String handle(String request){
        switch (request){
            case "0" :
                requestedPatients = storage.showAllPatients();
                break;
            case "1" :
                String illness = userInterface.askIllness();
                requestedPatients = storage.selectByIllness(illness);
                break;
            case "2" :
                int[] numbers = userInterface.askNumbers();
                requestedPatients = storage.selectByNumber(numbers);
                break;
            case "3" :
                requestedPatients = storage.sortArray();
                break;
            case "4":
                if(patientWriter.writePatients(requestedPatients)){
                    return "OK";
                }
                break;
            case "5":
                requestedPatients = patientReader.readPatients();
                break;
            default:
                System.out.println("Неизвестный запрос");
        }
        if(requestedPatients != null) {
            return Arrays.toString(requestedPatients);
        }else{
            return "Запрос не вернул результатов";
        }
    }
    public void showMenu(){
        userInterface.makeMenu();
    }
}
