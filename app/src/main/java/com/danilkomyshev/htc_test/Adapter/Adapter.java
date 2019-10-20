package com.danilkomyshev.htc_test.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.MainActivity;
import com.danilkomyshev.htc_test.Models.Employee;
import com.danilkomyshev.htc_test.Models.JsonObject;
import com.danilkomyshev.htc_test.R;
import com.danilkomyshev.htc_test.databinding.EmployeeBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private JsonObject company;

    public Adapter(JsonObject company) {
        this.company = company;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.companyName.setText(String.valueOf(company.getCompany().name));
        holder.age.setText(String.valueOf(company.getCompany().age));
        holder.competences.setText(Arrays.toString(company.getCompany().competences));
        List<Employee> employees = company.getCompany().employees;
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.name.compareTo(o2.name) > 0){
                    return 1;
                }else
                    return -1;
            }
        });
        for (Employee employee: employees) {
            Employee employee2 = new Employee(employee.name, employee.phoneNumber, employee.skills);
            EmployeeBinding binding = DataBindingUtil.setContentView(new MainActivity(), R.layout.employee);
            binding.setEmployee(employee2);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
