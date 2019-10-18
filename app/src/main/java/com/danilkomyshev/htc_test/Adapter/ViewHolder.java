package com.danilkomyshev.htc_test.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.R;

class ViewHolder extends RecyclerView.ViewHolder {
    TextView companyName, name, phone, skills, age, competences;

    private LayoutInflater inflater;
    private ViewGroup container;

    ViewHolder(View itemView){
        super(itemView);
        companyName = itemView.findViewById(R.id.companyName);
        age  = itemView.findViewById(R.id.age);
        competences = itemView.findViewById(R.id.competences);
        itemView = inflater.inflate(R.layout.employee, container, false);
        name = itemView.findViewById(R.id.name);
        phone = itemView.findViewById(R.id.phone);
        skills = itemView.findViewById(R.id.skills);
    }
}