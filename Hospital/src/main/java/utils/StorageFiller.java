package utils;

import mainClasses.Patient;
import java.io.*;
import java.util.Arrays;

/**
 * Created by Denis on 01.03.2018.
 */
public class StorageFiller {

    private static final String FILE = "Hospital/src/data";
    private Storage storage;
    private String[][] data;

    public StorageFiller(Storage storage){
        this.storage = storage;
    }

    public void fillStorage(){
        File myFile = new File(FILE);
        Patient patient;
        String[][] patientData = readFile(myFile);
        storage.initializeStorage(data.length);
        for(String[] line : patientData){
            if(null != line[0]) {
                patient = new Patient(line);
                storage.addPatient(patient);
            }
        }
    }

    private String[][] readFile(File file){
        data = new String[10][7];
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
            for (int j = 0; j < 6; j++) {
                newData[i][j] = data[i][j];
            }
        }
        return newData;
    }

}
