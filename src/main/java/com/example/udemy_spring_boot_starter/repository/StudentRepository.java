package com.example.udemy_spring_boot_starter.repository;

import com.example.udemy_spring_boot_starter.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByFirstName(String firstName);

    Student findStudentsByFirstNameAndAndLastName(String firstName, String lastName);

    List<Student> findStudentsByFirstNameOrLastName(String firstName, String lastName);

    List<Student> findStudentsByFirstNameIn(List<String> firstNames);

    List<Student> findStudentsByFirstNameContains(String letters);

    List<Student> findStudentsByFirstNameStartingWith(String letters);

    List<Student> findStudentsByFirstNameEndingWith(String letters);

    @Query("from Student WHERE firstName = :firstName AND lastName = :lastName")
    Student getStudentsByFirstNameAndAndLastName(String firstName, String lastName);

    @Modifying
    @Transactional
    @Query("UPDATE Student SET firstName = :firstName WHERE id = :id")
    Integer updateFirstName(Long id, String firstName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student WHERE lastName = :lastName")
    Integer deleteByLastName(String lastName);

    @Query("from Student WHERE  address.city = :city")
    List<Student> getByAddressCity(String city);
}
