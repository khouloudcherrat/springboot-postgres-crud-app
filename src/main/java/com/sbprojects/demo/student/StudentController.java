package com.sbprojects.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
		return studentService.getStudents();
    }

    @PostMapping
    public void RegisterNewStudent(@RequestBody Student student) { // The request body is mapped to student
      studentService.AddNewStudent(student);
    }

    @PutMapping("/{id}")
    public void UpdateStudent(
      @PathVariable Integer id, 
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
        studentService.UpdateStudent(id, name, email); 
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable Integer id){
      studentService.DeleteStudent(id);
    }
    
    

    
}
