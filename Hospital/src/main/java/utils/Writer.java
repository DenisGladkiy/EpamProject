package utils;

import mainClasses.Patient;

import java.util.Arrays;

/**
 * Created by Denis on 28.02.2018.
 */
public class Writer {
    public void write(String result){
        System.out.println(result);
    }

    public void write(int result){
        System.out.println(result);
    }

    public void write(Patient[] patients){
        for(Patient patient : patients){
            if(null != patient) {
                System.out.println(patient);
            }
        }
    }
}
