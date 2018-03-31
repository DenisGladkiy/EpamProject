package mainClasses.serializer;

import mainClasses.model.Patient;

import java.io.*;

/**
 * Created by Denis on 30.03.2018.
 */
public class PatientReader {
    private File file;

    public PatientReader(File file){
        this.file = file;
    }

    public Patient[] readPatients(){
        Patient[] patients = null;
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))){
            patients = (Patient[])is.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
