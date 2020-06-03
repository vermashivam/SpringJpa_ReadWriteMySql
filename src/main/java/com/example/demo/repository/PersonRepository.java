package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person , Integer> {
    List<Person> findByName(String name);
    List<Person> findByAge(int age);
    List<Person> findAll();
}
