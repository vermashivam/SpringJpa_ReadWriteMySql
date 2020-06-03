package com.example.demo.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Person {
    @Id
    @GeneratedValue
    int pid;

    String name;
    int age;

    public Person() {
    }

    public Person(int pid, String name, int age) {
        this.pid = pid;
        this.name = name;
        this.age = age;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
