package controller;

import exception.FormatException;
import model.Model;
import model.Student;
import utils.StudentParser;
import mvc.view.ConsoleReader;
import mvc.view.ConsoleWriter;


/**
 * Created by Denis on 23.03.2018.
 */
public class Controller {
    Model model;
    ConsoleReader reader;
    ConsoleWriter writer;
    StudentParser parser;

    public Controller(Model model){
        this.model = model;
        reader = new ConsoleReader();
        writer = new ConsoleWriter();
        parser = new StudentParser();
    }

    public void hello(){
        writer.showOptions();
        writer.askStudent();
    }

    public void readLine(){
        String line;
        Student student;
        while(true){
            line = reader.readLine();
            if(line.equalsIgnoreCase("exit")) {
                break;
            }
            if(line.equalsIgnoreCase("all")) {
                showAllList();
                continue;
            }
            if((student = parseLine(line)) != null) {
                model.addStudent(student);
            }
        }
    }

    public Student parseLine(String line){
        Student st = null;
        try {
            st = parser.parseStudent(line);
            writer.confirm();
            writer.askStudent();
        } catch (FormatException e) {
            e.printStackTrace();
            writer.askStudent();
        }
        return st;
    }

    public void showAllList(){
        writer.writeConsole(model.getStudents().toString());
    }
}
