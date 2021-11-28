package com.example.udemy_spring_boot_starter.repository;

import com.example.udemy_spring_boot_starter.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
