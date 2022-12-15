package com.sparta.sakilajpa.repositories;

import com.sparta.sakilajpa.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findByLastName(String lastName);
}