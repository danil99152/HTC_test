package com.danilkomyshev.htc_test.Models;

public class JsonObject {
    private Company company;

    public Company getCompany() {
        return company;
    }

    public JsonObject(Company company) {

        this.company = company;
    }
}