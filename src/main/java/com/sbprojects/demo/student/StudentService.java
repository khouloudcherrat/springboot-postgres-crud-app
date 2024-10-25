package com.sbprojects.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents(){
		return List.of(new Student(1, "khouloud", "khouloudch@gmail.com", LocalDate.of(2001, Month.OCTOBER, 15), 23));
    }
}
