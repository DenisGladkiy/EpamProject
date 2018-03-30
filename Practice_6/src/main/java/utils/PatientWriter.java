package utils;

import mainClasses.model.Patient;

import java.io.*;

/**
 * Created by Denis on 30.03.2018.
 */
public class PatientWriter {
    private File file;

    public PatientWriter(File file){
        this.file = file;
    }

    public boolean writePatients(Patient[] patients){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))){
            os.writeObject(patients);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
