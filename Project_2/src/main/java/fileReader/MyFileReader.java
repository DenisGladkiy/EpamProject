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

//    public String getNextLine() throws IOException {
//        String line = null;
//        if(bufferedReader != null){
//            line = bufferedReader.readLine();
//        }
//        return line;
//    }

    public String readFile() throws IOException {
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line + " ");
        }
        return builder.toString();
    }
}
