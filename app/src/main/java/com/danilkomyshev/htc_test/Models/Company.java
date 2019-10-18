package com.danilkomyshev.htc_test.Models;

import java.util.List;

public class Company {
    public String name;
    public int age;
    public String[] competences;
    public List<Employee> employees;

    public Company(){
    }


    public Company(String name, int age, String[] competences, List<Employee> employees) {
        this.name = name;
        this.age = age;
        this.competences = competences;
        this.employees = employees;
    }
}
