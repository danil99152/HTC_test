package com.danilkomyshev.htc_test.Models;

import com.google.gson.annotations.SerializedName;

public class Employee {

    public String name;

    @SerializedName("phone_number")
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
