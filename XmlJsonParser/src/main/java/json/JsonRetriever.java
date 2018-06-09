package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Denys_Hladkyi on 6/8/2018.
 */
public class JsonRetriever {

    public String retrieveJson(String url){
        String jsonText = null;
        try (InputStream inputStream = new URL(url).openStream()){
            jsonText = readJson(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonText;
    }

    private String readJson(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        Scanner scanner =  new Scanner(inputStream);
        while (scanner.hasNext()){
            builder.append(scanner.nextLine());
        }
        return builder.toString();
    }
}
