package org.kepler;

import lombok.*;
import java.util.*;


@ToString
public class University {
    List<Student> students;

    public void addStudent(Student student) {
        if(students == null) {
            students = new ArrayList<Student>();
        }
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void badListStudents() {
        Student nonExistStudent = students.get(1000); // error!
    }
}