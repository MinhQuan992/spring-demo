package com.example.SpringDemo.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepository);
    }

    @Test
    void canGetAllStudents() {
        // when
        underTest.getStudents();
        // then
        verify(studentRepository).findAll();
    }

    @Test
    void canAddNewStudent() {
        // given
        Student student = new Student(
                "Minh Quân",
                LocalDate.of(2000, Month.SEPTEMBER, 9),
                "tranminhquanvo@gmail.com"
        );

        // when
        underTest.addNewStudent(student);

        // then
        ArgumentCaptor<Student> argumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(argumentCaptor.capture());
        Student captureStudent = argumentCaptor.getValue();
        assertThat(captureStudent).isEqualTo(student);
    }

    @Test
    void willThrowErrorWhenEmailIsTaken() {
//        // given
//        Student student = new Student(
//                "Minh Quân",
//                LocalDate.of(2000, Month.SEPTEMBER, 9),
//                "tranminhquanvo@gmail.com"
//        );
//        given(studentRepository.findStudentByEmail(student.getEmail()).isPresent())
//                .willReturn(true);
//
//        // when
//        // then
//        assertThatThrownBy(() -> underTest.addNewStudent(student))
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessageContaining("Email taken!");
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateStudent() {
    }
}