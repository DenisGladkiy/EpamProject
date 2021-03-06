package parser;

/**
 * Created by Denys_Hladkyi on 6/8/2018.
 */
public class ParserFactory {
    private enum Format {JSON,XML};

    public DocumentParser getParser(String strFormat){
        if(Format.valueOf(strFormat).equals(Format.JSON)){
            return new MyJsonParser();
        }else if(Format.valueOf(strFormat).equals(Format.XML)){
            return new MyXmlParser();
        }else {
            throw new RuntimeException("Unknown parser format");
        }
    }
}
