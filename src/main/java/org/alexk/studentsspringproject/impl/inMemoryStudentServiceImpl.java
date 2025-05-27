package org.alexk.studentsspringproject.impl;

import lombok.AllArgsConstructor;
import org.alexk.studentsspringproject.Service.StudentService;
import org.alexk.studentsspringproject.model.Student;
import org.springframework.stereotype.Service;
import org.alexk.studentsspringproject.repo.InMemoryStudentDAO;

import java.util.List;
@Service
@AllArgsConstructor
public class inMemoryStudentServiceImpl implements StudentService {
    private final InMemoryStudentDAO repo;
    @Override
    public List<Student> GetStudentsList() {
        return repo.getStudents();
    }

    @Override
    public Student GetStudentById(int id) {
        return repo.GetStudentById(id);
    }

    @Override
    public boolean SaveStudent(Student student) {
        return repo.SaveStudent(student);
    }

    @Override
    public boolean UpdateStudent(Student student) {
        return repo.UpdateStudent(student);
    }

    @Override
    public void DeleteStudent(int id) {
        repo.DeleteStudent(id);
    }
}
