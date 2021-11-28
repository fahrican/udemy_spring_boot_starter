package com.example.udemy_spring_boot_starter.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class CreateStudentRequest {

    @JsonProperty("first_name")
    @NotBlank(message = "First name can't be empty")
    private String firstName;

    @JsonProperty("last_name")
    @NotBlank(message = "Last name can't be empty")
    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<CreateSubjectRequest> subjectRequests;
}
