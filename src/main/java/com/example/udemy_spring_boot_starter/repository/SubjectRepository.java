package com.example.udemy_spring_boot_starter.repository;

import com.example.udemy_spring_boot_starter.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
