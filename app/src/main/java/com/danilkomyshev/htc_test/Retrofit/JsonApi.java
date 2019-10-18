package com.danilkomyshev.htc_test.Retrofit;

import com.danilkomyshev.htc_test.Models.Company;
import com.danilkomyshev.htc_test.Models.Employee;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JsonApi {

    @GET("company")
    Observable<Company> getCompany();

    Observable<List<Employee>> getEmployees();
}