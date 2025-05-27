package org.alexk.studentsspringproject.Service;

import org.alexk.studentsspringproject.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> GetStudentsList();
    Student GetStudentById(int id);
    boolean SaveStudent(Student student);
    boolean UpdateStudent(Student student);
    void DeleteStudent(int id);
}
