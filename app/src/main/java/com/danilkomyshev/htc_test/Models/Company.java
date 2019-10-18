package com.danilkomyshev.htc_test.Models;

public class Company {
    public String name;
    public int age;
    public String[] competences;
    public Employee[] employees;

    public Company(){
    }


    public Company(String name, int age, String[] competences, Employee[] employees) {
        this.name = name;
        this.age = age;
        this.competences = competences;
        this.employees = employees;
    }
}
