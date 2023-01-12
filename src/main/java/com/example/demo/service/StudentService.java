package com.example.demo.service;

import com.example.demo.infra.entities.Student;
import com.example.demo.infra.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void createNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.
                findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);

    }

    public List<Student> getStudents() {
        return studentRepository.findAll();


    }

    public List<Student> getStudentsOlderThan18() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .filter(student -> student.getAge()>18)
                .collect(Collectors.toList());
    }


}
