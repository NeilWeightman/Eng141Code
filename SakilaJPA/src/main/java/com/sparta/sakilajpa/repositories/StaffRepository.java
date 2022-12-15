package com.sparta.sakilajpa.repositories;

import com.sparta.sakilajpa.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Short> {
}