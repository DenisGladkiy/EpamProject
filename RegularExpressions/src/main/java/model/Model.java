package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 23.03.2018.
 */
public class Model {
    List<Student> students;

    public Model(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents(){
        return students;
    }
}
