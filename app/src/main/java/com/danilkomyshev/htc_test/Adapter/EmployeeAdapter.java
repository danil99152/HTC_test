package com.danilkomyshev.htc_test.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.Models.Company;
import com.danilkomyshev.htc_test.Models.Employee;
import com.danilkomyshev.htc_test.R;

import java.util.Arrays;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private List<Employee> employees;
    private Company company;
    public EmployeeAdapter(Company company) {
        this.company = company;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.name.setText(Arrays.toString(company.employees));
//        holder.name.setText(String.valueOf(employees.get(position).name));
//        holder.phone.setText(String.valueOf(employees.get(position).phoneNumber));
//        holder.skills.setText(Arrays.toString(employees.get(position).skills));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
