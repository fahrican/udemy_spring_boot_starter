package com.example.udemy_spring_boot_starter.service;

import com.example.udemy_spring_boot_starter.entity.Address;
import com.example.udemy_spring_boot_starter.entity.Student;
import com.example.udemy_spring_boot_starter.entity.Subject;
import com.example.udemy_spring_boot_starter.repository.AddressRepository;
import com.example.udemy_spring_boot_starter.repository.StudentRepository;
import com.example.udemy_spring_boot_starter.repository.SubjectRepository;
import com.example.udemy_spring_boot_starter.request.CreateStudentRequest;
import com.example.udemy_spring_boot_starter.request.CreateSubjectRequest;
import com.example.udemy_spring_boot_starter.request.InQueryRequest;
import com.example.udemy_spring_boot_starter.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest studentRequest) {
        Student student = new Student(studentRequest);

        Address address = new Address();
        address.setStreet(studentRequest.getStreet());
        address.setCity(studentRequest.getCity());
        address = addressRepository.save(address);

        student.setAddress(address);
        student = studentRepository.save(student);

        List<Subject> subjects = new ArrayList<>();
        if (studentRequest.getSubjectRequests() != null) {
            for (CreateSubjectRequest subjectRequest : studentRequest.getSubjectRequests()) {
                Subject subject = new Subject();
                subject.setSubjectName(subjectRequest.getSubjectName());
                subject.setMarksObtained(subjectRequest.getMarksObtained());
                subject.setStudent(student);

                subjects.add(subject);
            }
            subjectRepository.saveAll(subjects);
        }
        student.setLearningSubjects(subjects);

        return student;
    }

    public Student updateStudent(UpdateStudentRequest studentRequest) {
        Student student = studentRepository.findById(studentRequest.getId()).get();

        if (studentRequest.getFirstName() != null && !studentRequest.getFirstName().isEmpty()) {
            student.setFirstName(studentRequest.getFirstName());
        }

        student = studentRepository.save(student);
        return student;
    }

    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student with id: " + id + " has been deleted.";
    }

    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepository.findStudentsByFirstName(firstName);
    }

    public Student getStudentByFirstNameAndLastName(String firstName, String lastName) {
        //return repository.findStudentsByFirstNameAndAndLastName(firstName, lastName);
        return studentRepository.getStudentsByFirstNameAndAndLastName(firstName, lastName);
    }

    public List<Student> getFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findStudentsByFirstNameOrLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
        return studentRepository.findStudentsByFirstNameIn(inQueryRequest.getFirstNames());
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return studentRepository.findAll(sort);
    }

    public List<Student> getAllNamesLike(String letters) {
        return studentRepository.findStudentsByFirstNameContains(letters);
    }

    public List<Student> getAllNamesStartingWith(String letters) {
        return studentRepository.findStudentsByFirstNameStartingWith(letters);
    }

    public Integer updateFirstNameWithJpql(Long id, String firstName) {
        return studentRepository.updateFirstName(id, firstName);
    }

    public Integer deleteByLastNameWithJpql(String lastName) {
        return studentRepository.deleteByLastName(lastName);
    }

    public List<Student> getByCity(String city) {
        return studentRepository.getByAddressCity(city);
    }
}
