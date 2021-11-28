package com.example.udemy_spring_boot_starter.entity;

import com.example.udemy_spring_boot_starter.request.CreateStudentRequest;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Transient
    private String fullName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Subject> learningSubjects;

    public Student(CreateStudentRequest studentRequest) {
        this.firstName = studentRequest.getFirstName();
        this.lastName = studentRequest.getLastName();
        this.email = studentRequest.getEmail();
        this.fullName = studentRequest.getFirstName() + " " + studentRequest.getLastName();
    }
}
