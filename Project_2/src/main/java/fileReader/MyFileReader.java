package fileReader;

import java.io.*;

/**
 * Created by Denis on 12.04.2018.
 */
public class MyFileReader {
    private File file;
    private BufferedReader bufferedReader;

    public MyFileReader(String filePath){
        file = new File(filePath);
        init();
    }

    private void init(){
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readFile(){
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            if(bufferedReader != null) {
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line + " ");
                }
            }else return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
