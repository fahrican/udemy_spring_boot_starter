package com.example.udemy_spring_boot_starter.controller;

import com.example.udemy_spring_boot_starter.entity.Student;
import com.example.udemy_spring_boot_starter.request.CreateStudentRequest;
import com.example.udemy_spring_boot_starter.request.InQueryRequest;
import com.example.udemy_spring_boot_starter.request.UpdateStudentRequest;
import com.example.udemy_spring_boot_starter.response.StudentResponse;
import com.example.udemy_spring_boot_starter.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/student/")
public class StudentController {

    @Autowired
    private StudentService service;

    @Value("${app.name:Spring Boot Video Course}")
    public String appName;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("getAllStudents")
    public List<StudentResponse> getAllStudents() {

        logger.error("Inside error");
        logger.info("Inside info");
        logger.warn("Inside warning");
        logger.debug("Inside debug");
        logger.trace("Inside trace");

        List<Student> students = service.getAllStudents();
        List<StudentResponse> responses = new ArrayList();

        students.forEach(student -> responses.add(new StudentResponse(student)));

        return responses;
    }

    @GetMapping("student")
    public String getStudent() {
        //return new StudentResponse(new Student(new CreateStudentRequest()));
        return "Hello";
    }


    @PostMapping("create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest studentRequest) {
        Student student = service.createStudent(studentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest studentRequest) {
        Student student = service.updateStudent(studentRequest);
        return new StudentResponse(student);
    }

    @DeleteMapping("delete")
    public String deleteStudent(@RequestParam Long id) {
        return service.deleteStudent(id);
    }

    @DeleteMapping("delete/{id}")
    public String removeStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }

    @GetMapping("getStudentByFirstName/{firstName}")
    public List<StudentResponse> getStudentByFirstName(@PathVariable String firstName) {
        List<Student> students = service.getStudentByFirstName(firstName);
        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        return studentResponses;
    }

    @GetMapping("getStudentByFullName/{firstName}/{lastName}")
    public StudentResponse getStudentByFullName(@PathVariable String firstName, @PathVariable String lastName) {
        Student student = service.getStudentByFirstNameAndLastName(firstName, lastName);
        return new StudentResponse(student);
    }

    @GetMapping("getFirstNameOrLastName/{firstName}/{lastName}")
    public List<StudentResponse> getFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName) {
        List<Student> students = service.getFirstNameOrLastName(firstName, lastName);
        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        return studentResponses;
    }

    @GetMapping("getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest) {

        logger.info("inQueryRequest = " + inQueryRequest);

        List<Student> students = service.getByFirstNameIn(inQueryRequest);
        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        logger.info("studentResponses = " + studentResponses);

        return studentResponses;
    }

    @GetMapping("getAllWithPagination")
    public List<StudentResponse> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
        List<Student> students = service.getAllWithPagination(pageNo, pageSize);
        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        return studentResponses;
    }

    @GetMapping("getAllWithSorting")
    public List<StudentResponse> getAllWithSorting() {
        List<Student> students = service.getAllWithSorting();
        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        return studentResponses;
    }

    @GetMapping("like/{letters}")
    public List<StudentResponse> getAllNamesLike(@PathVariable String letters) {
        List<Student> students = service.getAllNamesLike(letters);
        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        return studentResponses;
    }

    @GetMapping("startingWith/{letters}")
    public List<StudentResponse> getAllNamesStartingWith(@PathVariable String letters) {
        List<Student> students = service.getAllNamesStartingWith(letters);
        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        return studentResponses;
    }

    @PutMapping("updateFirstName/{id}/{firstName}")
    public String updateFirstNameWithJpql(@PathVariable Long id, @PathVariable String firstName) {
        return service.updateFirstNameWithJpql(id, firstName) + " Student updated.";
    }

    @DeleteMapping("deleteByLastName/{lastName}")
    public String deleteByLastNameWithJpql(@PathVariable String lastName) {
        return service.deleteByLastNameWithJpql(lastName) + " Student(s) deleted.";
    }

    @GetMapping("getByCity/{city}")
    public List<StudentResponse> getByCity(@PathVariable String city) {
        List<Student> students = service.getByCity(city);

        List<StudentResponse> studentResponses = new ArrayList();

        students.forEach(student -> studentResponses.add(new StudentResponse(student)));

        return studentResponses;
    }
}
