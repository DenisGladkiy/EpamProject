package utils;

import mainClasses.model.Patient;
import mainClasses.model.Storage;

import java.io.*;

/**
 * Created by Denis on 01.03.2018.
 */
public class StorageFiller {

    private static final String FILE = "Hospital/src/data";
    private Storage storage;

    public StorageFiller(Storage storage){
        this.storage = storage;
    }

    public void fillStorage(){
        File myFile = new File(FILE);
        Patient patient;
        String[][] patientData = readFile(myFile);
        storage.initializeStorage(patientData.length);
        for(String[] line : patientData){
            if(null != line[0]) {
                patient = new Patient(line);
                storage.addPatient(patient);
            }else{break;}
        }
    }

    private String[][] readFile(File file){
        String[][] data = new String[10][7];
        String[] lineArr;
        String line;
        int lineNumber = 0;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while (null != line){
                lineArr = line.split(";");
                data[lineNumber] = lineArr;
                line = bufferedReader.readLine();
                lineNumber++;
                if(lineNumber == data.length){
                    data = doubleArrayLength(data);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String[][] doubleArrayLength(String[][] data){
        String[][] newData = new String[data.length *2][7];
        for(int i=0; i < data.length; i++) {
            for (int j = 0; j < 7; j++) {
                newData[i][j] = data[i][j];
            }
        }
        return newData;
    }
}
