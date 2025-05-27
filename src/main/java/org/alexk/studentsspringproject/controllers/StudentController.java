package org.alexk.studentsspringproject.controllers;

import lombok.RequiredArgsConstructor;
import org.alexk.studentsspringproject.Service.StudentService;
import org.alexk.studentsspringproject.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studService;

    @GetMapping("")
    public List<Student> GetStudentsList() {
        return studService.GetStudentsList();
    }

    @GetMapping("/{id}")
    public Student GetStudentById(@PathVariable int id) {
        return studService.GetStudentById(id);
    }

    @PostMapping("/save_student")
    public boolean SaveStudent(@RequestBody Student student) {
        return studService.SaveStudent(student);
    }

    @PutMapping("/update_student")
    public boolean UpdateStudent(@RequestBody Student student) {
        return studService.UpdateStudent(student);
    }

    @DeleteMapping("/delete_student/{id}")
    public void delete_student(@PathVariable int id) {
        studService.DeleteStudent(id);
    }
}
