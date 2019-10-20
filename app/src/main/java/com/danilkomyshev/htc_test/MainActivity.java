package com.danilkomyshev.htc_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.Adapter.CompanyAdapter;
import com.danilkomyshev.htc_test.Adapter.ItemEmployee;
import com.danilkomyshev.htc_test.Models.Employee;
import com.danilkomyshev.htc_test.Models.JsonObject;
import com.danilkomyshev.htc_test.Retrofit.JsonApi;
import com.danilkomyshev.htc_test.Retrofit.NetworkService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    JsonApi api;
    RecyclerView company;
    ListView employees;
    EmployeeAdapter employeeAdapter;
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = NetworkService.getInstance();
        api = retrofit.create(JsonApi.class);

        company = findViewById(R.id.recycler_posts);
        company.setHasFixedSize(true);
        company.setLayoutManager(new LinearLayoutManager(this));

        employees = findViewById(R.id.employees);
        employeeAdapter = new EmployeeAdapter(this, R.layout.employee);

        fetchData();

    }

    private void fetchData() {
        disposable.add(api.getCompany()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JsonObject>() {
                    @Override
                    public void accept(JsonObject company) throws Exception {
                        loadData(company);
                        displayData(company);
                    }
                }));
    }

    private void displayData(JsonObject company) {
        CompanyAdapter companyAdapter = new CompanyAdapter(company);
        this.company.setAdapter(companyAdapter);

        employees.setAdapter(employeeAdapter);
    }

    private void loadData(JsonObject company){
        List<Employee> mEmployees = company.getCompany().employees;
        Collections.sort(mEmployees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.name.compareTo(o2.name) > 0){
                    return 1;
                }else
                    return -1;
            }
        });
        for (Employee employee: mEmployees) {
            employeeAdapter.add(new ItemEmployee(employee.name, employee.phoneNumber, employee.skills));
        }
    }

    public class EmployeeAdapter extends ArrayAdapter<ItemEmployee> {


        EmployeeAdapter(Context context, int resource) {
            super(context, resource);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            @SuppressLint("ViewHolder") final View view = getLayoutInflater().inflate(R.layout.employee, null);
            final ItemEmployee item = getItem(position);
            TextView name = view.findViewById(R.id.name);
            assert item != null;
            name.setText(item.name);
            TextView phone = view.findViewById(R.id.phone);
            phone.setText(item.phone);
            TextView skills = view.findViewById(R.id.skills);
            skills.setText(Arrays.toString(item.skills));
            return view;
        }
    }

    @Override
    protected void onStop(){
        disposable.clear();
        super.onStop();
    }
}