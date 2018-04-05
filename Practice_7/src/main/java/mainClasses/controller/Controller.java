package mainClasses.controller;

import mainClasses.model.Patient;
import mainClasses.model.Storage;
import mainClasses.serializer.PatientReader;
import mainClasses.serializer.PatientWriter;
import mainClasses.view.Menu;
import mainClasses.view.UserInterface;
import org.apache.log4j.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Denis on 01.03.2018.
 */
public class Controller {
    static Logger logger = Logger.getLogger(Controller.class);
    private UserInterface userInterface;
    private Storage storage;
    Patient[] requestedPatients;

    public Controller(Storage storage){
        this.storage = storage;
        userInterface = new UserInterface(this);
        loggerInit();
    }

    public String handle(String request) throws IOException {
        String filepath;
        switch (request){
            case "0" :
                requestedPatients = storage.showAllPatients();
                logger.info("option 0 selected");
                break;
            case "1" :
                String illness = userInterface.askIllness();
                requestedPatients = storage.selectByIllness(illness);
                logger.info("option 1 selected");
                break;
            case "2" :
                int[] numbers = userInterface.askNumbers();
                requestedPatients = storage.selectByNumber(numbers);
                logger.info("option 2 selected");
                break;
            case "3" :
                requestedPatients = storage.sortArray();
                logger.info("option 3 selected");
                break;
            case "4":
                logger.info("option 4 selected");
                filepath = userInterface.askFilePath();
                PatientWriter patientWriter = new PatientWriter(createFile(filepath));
                if(requestedPatients == null){
                    requestedPatients = storage.showAllPatients();
                }
                if(patientWriter.writePatients(requestedPatients)) {
                    logger.info("Write object to file successful");
                    return "OK";
                }
                break;
            case "5":
                logger.info("option 5 selected");
                filepath = userInterface.askFilePath();
                PatientReader patientReader = new PatientReader(createFile(filepath));
                requestedPatients = patientReader.readPatients();
                break;
            default:
                logger.debug("Unknown request");
                System.out.println(Menu.UNKNOWN);
        }
        if(requestedPatients != null) {
            return Arrays.toString(requestedPatients);
        }else{
            logger.debug("Result is empty");
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
        if(!file.canWrite()){
            logger.debug("Cannot write to file " + file);
            throw new IOException("File path wrong");
        }
        return file;
    }

    private void loggerInit(){
        try {
            FileAppender appender = new FileAppender(new SimpleLayout(), "log.txt");
            logger.addAppender(appender);
            logger.setLevel(Level.DEBUG);
        } catch (IOException e) {
            logger.error("logger init error");
            e.printStackTrace();
        }

    }
}
