package com.example.eregistrar;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class StudentDataLoader {

    @Bean
    public CommandLineRunner loadSampleStudents(StudentRepository studentRepository) {
        return args -> {
            if (studentRepository.count() == 0) {
                studentRepository.save(new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.78, LocalDate.of(2019, 5, 12), false));
                studentRepository.save(new Student("000-61-0002", "Bob", null, "Johnson", 3.21, LocalDate.of(2020, 8, 23), true));
            }
        };
    }
}
