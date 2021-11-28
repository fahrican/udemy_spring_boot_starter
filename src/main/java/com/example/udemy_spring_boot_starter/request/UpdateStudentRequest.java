package com.example.udemy_spring_boot_starter.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStudentRequest {

    @NotNull(message = "Student id is required")
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
}
