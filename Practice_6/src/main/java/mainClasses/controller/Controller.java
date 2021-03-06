package mainClasses.controller;

import mainClasses.model.Patient;
import mainClasses.model.Storage;
import mainClasses.view.Menu;
import mainClasses.view.UserInterface;
import mainClasses.serializer.PatientReader;
import mainClasses.serializer.PatientWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Denis on 01.03.2018.
 */
public class Controller {
    private UserInterface userInterface;
    private Storage storage;
    Patient[] requestedPatients;

    public Controller(Storage storage){
        this.storage = storage;
        userInterface = new UserInterface(this);
    }

    public String handle(String request) throws IOException {
        String filepath;
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
                filepath = userInterface.askFilePath();
                PatientWriter patientWriter = new PatientWriter(createFile(filepath));
                if(requestedPatients == null){
                    requestedPatients = storage.showAllPatients();
                }
                if(patientWriter.writePatients(requestedPatients)) return "OK";
                break;
            case "5":
                filepath = userInterface.askFilePath();
                PatientReader patientReader = new PatientReader(createFile(filepath));
                requestedPatients = patientReader.readPatients();
                break;
            default:
                System.out.println(Menu.UNKNOWN);
        }
        if(requestedPatients != null) {
            return Arrays.toString(requestedPatients);
        }else{
            return Menu.NO_RESULT;
        }
    }

    public void showMenu(){
        userInterface.makeMenu();
    }

    private File createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if(file.canRead() && file.canWrite()){
            return file;
        }else if(file.getParentFile() != null) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        if(!file.canWrite()) throw new IOException("File path wrong");
        return file;
    }
}
