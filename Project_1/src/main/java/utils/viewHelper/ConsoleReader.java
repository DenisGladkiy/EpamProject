package utils.viewHelper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 01.04.2018.
 */
public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    public String readString(){
        return scanner.next();
    }

    public int readInt(){
        String strNumber = scanner.next();
        Pattern numbers = Pattern.compile("^\\d+$");
        Matcher matcher = numbers.matcher(strNumber);
        if(matcher.find()){
            return Integer.valueOf(strNumber);
        }
        return -1;
    }

    public String readLine(){
        return scanner.nextLine();
    }

    public int[] readRange(){
        int[] range = new int[2];
        String strRange = scanner.nextLine();
        Pattern rangePattern = Pattern.compile("(^\\d+)-(\\d+$)");
        Matcher matcher = rangePattern.matcher(strRange);
        if(matcher.find()){
            String[] rangeArr = strRange.split("-");
            int from = Integer.valueOf(rangeArr[0]);
            int to = Integer.valueOf(rangeArr[1]);
            if(from > to){
                int temp = from;
                from = to;
                to = temp;
            }
            range[0] = from;
            range[1] = to;
        }
        return range;
    }
}
