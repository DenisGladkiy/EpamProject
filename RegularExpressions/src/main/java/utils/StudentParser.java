package utils;

import exception.FormatException;
import model.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Denis on 23.03.2018.
 */
public class StudentParser implements ParserPatterns {

    public Student parseStudent(String string) throws FormatException{
        Pattern namePattern = Pattern.compile(NAME_STRING_PATTERN);
        Pattern birthdayPattern = Pattern.compile(BIRTHDAY_STRING_PATTERN);
        Pattern phonePattern = Pattern.compile(PHONE_STRING_PATTERN);
        Pattern addressPattern = Pattern.compile(ADDRESS_STRING_PATTERN);
        Matcher mName = namePattern.matcher(string);
        Matcher mBirthday = birthdayPattern.matcher(string);
        Matcher mPhone = phonePattern.matcher(string);
        Matcher mAddress = addressPattern.matcher(string);
        String last, first, date, phone, address;
        if(mName.find()) {
            last = mName.group(2);
            first = mName.group(3);
        }else{
            throw new FormatException("Name format mistake");
        }
        if(mBirthday.find()){
            date = mBirthday.group(1);
        }else{
            throw new FormatException("Birthday format mistake");
        }
        if(mPhone.find()){
            phone = mPhone.group(1);
        }else{
            throw new FormatException("Phone format mistake");
        }
        if(mAddress.find()){
            address = mAddress.group(1);
        }else{
            throw new FormatException("Address format mistake");
        }
        return new Student(last, first, date, phone, address);
    }
}
