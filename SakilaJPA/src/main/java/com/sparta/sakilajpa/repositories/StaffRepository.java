package com.sparta.sakilajpa.repositories;

import com.sparta.sakilajpa.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Short> {
    @Query("SELECT s FROM Staff s WHERE LENGTH(s.username) = :usernameLength")
    List<Staff> findAllStaffWithShortNames(Integer usernameLength);
    @Query(value = "SELECT * FROM staff where length(username) = :usernameLength", nativeQuery = true)
    List<Staff> findUsingSQL(@Param("usernameLength") Integer usernameLength);
}