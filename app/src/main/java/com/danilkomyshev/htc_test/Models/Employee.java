package com.danilkomyshev.htc_test.Models;

public class Employee {
    public String name;
    public String phoneNumber;
    public String[] skills;

    public Employee(){

    }

    public Employee(String name, String phoneNumber, String[] skills) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
    }
}
