package com.example.SpringDemo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student studentOne = new Student(
                    "Minh Quân",
                    LocalDate.of(2000, Month.SEPTEMBER, 9),
                    "tranminhquanvo@gmail.com");

            Student studentTwo = new Student(
                    "Võ Trần",
                    LocalDate.of(2001, Month.SEPTEMBER, 9),
                    "vtmquan0909@gmail.com");

            studentRepository.saveAll(List.of(studentOne, studentTwo));
        };
    }
}
