package com.example.demo.api;

import com.example.demo.infra.entities.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students/")
@Api(value = "StudentsControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)

public class StudentController {
    private final StudentService studentService;/* une reference sur la classe StudentService */

    @Autowired
    //each of those arguments (studentService) will be autowired with a matching bean in the Spring container.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.POST)
    @ApiOperation("register new student")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Student.class)})
    public void registerNewStudent(@RequestBody Student student) {
        studentService.createNewStudent(student);

    }

    @GetMapping

    public List<Student> getStudents() {
        return studentService.getStudents();
    }


}

