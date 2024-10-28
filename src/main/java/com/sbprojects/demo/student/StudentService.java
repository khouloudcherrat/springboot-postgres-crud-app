package com.sbprojects.demo.student;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
  private final StudentRepository studentRepository;
  
  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents(){
		return studentRepository.findAll();
    }

  public void AddNewStudent(Student student) {
    
    Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
    if (studentByEmail.isPresent()){
      throw new IllegalStateException("Email taken."); 
    }
    studentRepository.save(student); 
  }

  @Transactional
  public void UpdateStudent(Integer id, String name, String email) {
    Student student = studentRepository.findById(id).
      orElseThrow(() -> new IllegalStateException(
        "student with id " + id + "does not exist"));
    
    if (name!= null && 
    !Objects.equals(student.getName(), name)){
      student.setName(name);
    }

    if(email!=null &&
    !Objects.equals(student.getEmail(), email)){
      Optional<Student> studentOptional = studentRepository.
      findStudentByEmail(email);
      if(studentOptional.isPresent()){
        throw new IllegalStateException("email taken");
      }
      student.setEmail(email);
    }

  }

  public void DeleteStudent(Integer id) {
    Boolean studentExists = studentRepository.existsById(id);
    if (studentExists) {
      studentRepository.deleteById(id);
    }
    else 
      throw new IllegalStateException("Student unfound"); 
  }
}
