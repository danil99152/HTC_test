package com.danilkomyshev.htc_test.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.Models.JsonObject;
import com.danilkomyshev.htc_test.R;

import java.util.Arrays;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyViewHolder> {

    private JsonObject company;

    public CompanyAdapter(JsonObject company) {
        this.company = company;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        holder.companyName.setText(String.valueOf(company.getCompany().name));
        holder.age.setText(String.valueOf(company.getCompany().age));
        holder.competences.setText(Arrays.toString(company.getCompany().competences));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
