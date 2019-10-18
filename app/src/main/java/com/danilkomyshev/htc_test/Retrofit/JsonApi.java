package com.danilkomyshev.htc_test.Retrofit;

import com.danilkomyshev.htc_test.Models.Employee;
import com.danilkomyshev.htc_test.Models.JsonObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JsonApi {

    @GET("56fa31e0110000f920a72134/")
    Observable<JsonObject> getCompany();

    Observable<List<Employee>> getEmployees();
}