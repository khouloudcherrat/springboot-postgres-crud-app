package com.sbprojects.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student student1 = new Student(
                "khouloud", 
                "khouloudch@gmail.com", 
                LocalDate.of(2001, Month.OCTOBER, 15)
            );
            Student student2 = new Student(
                "meryeme", 
                "meryemech@gmail.com", 
                LocalDate.of(1992, Month.JUNE, 26)
            );
            repository.saveAll(List.of(student1, student2));
        };
    }
}
