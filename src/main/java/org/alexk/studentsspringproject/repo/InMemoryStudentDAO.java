package org.alexk.studentsspringproject.repo;

import lombok.Getter;
import org.alexk.studentsspringproject.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class InMemoryStudentDAO {
    @Getter
    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public Student GetStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public boolean SaveStudent(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
        }
        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            return false;
        }

        students.add(student);
        return true;
    }

    public boolean UpdateStudent(Student student) {
        if (students.stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            DeleteStudent(student.getId());
            students.add(student);
            return true;
        }
        return false;
    }

    public void DeleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
