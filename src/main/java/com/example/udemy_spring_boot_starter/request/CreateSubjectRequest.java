package com.example.udemy_spring_boot_starter.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSubjectRequest {

    private String subjectName;

    private Double marksObtained;
}
