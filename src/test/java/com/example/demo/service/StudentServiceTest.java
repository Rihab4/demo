package com.example.demo.service;

import com.example.demo.infra.StudentRepository;
import com.example.demo.infra.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    void getStudentsOlderThan18() {
        // GIVEN
        List<Student> students = Arrays.asList(
                Student.builder()
                        .age(19)
                        .build(),
                Student.builder()
                        .age(17)
                        .build()
        );
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        // WHEN
        List<Student> studentsOlderThan18=studentService.getStudentsOlderThan18();
        // THEN
        Assertions.assertEquals(1,studentsOlderThan18.size());

    }
}