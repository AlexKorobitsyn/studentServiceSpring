package org.alexk.studentsspringproject.controllers;

import lombok.AllArgsConstructor;
import org.alexk.studentsspringproject.Service.StudentService;
import org.alexk.studentsspringproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studService;
    @GetMapping("")
    public List<Student> GetStudentsList(){
        return studService.GetStudentsList();
        //todo
    }
    @GetMapping("/{id}")
    public Student GetStudentById(@PathVariable String id){
        try
        {
            Integer ourId = Integer.parseInt(id.trim());
            return studService.GetStudentById(ourId);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @PostMapping("save_student")
    public boolean SaveStudent(@RequestBody Student student){
        return studService.SaveStudent(student);
    }
    @PutMapping("update_student")
    public boolean UpdateStudent(Student student){
        return studService.UpdateStudent(student);
    }
    @DeleteMapping("delete_student/{id}")
    public void delete_student(@PathVariable String id){
        try
        {
            Integer ourId = Integer.parseInt(id.trim());
            studService.DeleteStudent(ourId);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
