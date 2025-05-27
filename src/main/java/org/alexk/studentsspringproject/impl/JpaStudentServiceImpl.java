package org.alexk.studentsspringproject.impl;

import lombok.RequiredArgsConstructor;
import org.alexk.studentsspringproject.model.Student;
import org.alexk.studentsspringproject.repo.StudentRepository;
import org.alexk.studentsspringproject.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaStudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> GetStudentsList() {
        return studentRepository.findAll();
    }

    @Override
    public Student GetStudentById(int id) {
        return studentRepository.findById(id).orElse(null); // теперь по внешнему ID
    }

    @Override
    public boolean SaveStudent(Student student) {
        if (student.getId() == null) {
            // генерируем внешний id (можно автоинкрементом — пока просто timestamp)
            student.setId((int) (System.currentTimeMillis() / 1000));
        }
        studentRepository.save(student);
        return true;
    }


    @Override
    public boolean UpdateStudent(Student student) {
        if (student.getId() != null && studentRepository.existsById(student.getId())) {
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public void DeleteStudent(int id) {
        studentRepository.deleteById((long) id);
    }
}
