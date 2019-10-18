package com.danilkomyshev.htc_test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.Adapter.EmployeeAdapter;
import com.danilkomyshev.htc_test.Models.Company;
import com.danilkomyshev.htc_test.Retrofit.JsonApi;
import com.danilkomyshev.htc_test.Retrofit.NetworkService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    JsonApi api;
    RecyclerView recycler_posts;
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init api
        Retrofit retrofit = NetworkService.getInstance();
        api = retrofit.create(JsonApi.class);

        //view
        recycler_posts = findViewById(R.id.recycler_posts);
        recycler_posts.setHasFixedSize(true);
        recycler_posts.setLayoutManager(new LinearLayoutManager(this));

        fetchData();

    }

    private void fetchData() {
        disposable.add(api.getCompany()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Company>() {
                    @Override
                    public void accept(Company employees) throws Exception {
                        displayData(employees);
                    }
                }));
    }

    private void displayData(Company company) {
        EmployeeAdapter adapter = new EmployeeAdapter(company);
        recycler_posts.setAdapter(adapter);
    }

    @Override
    protected void onStop(){
        disposable.clear();
        super.onStop();
    }
}