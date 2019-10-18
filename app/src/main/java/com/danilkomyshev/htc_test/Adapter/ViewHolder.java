package com.danilkomyshev.htc_test.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.R;

class ViewHolder extends RecyclerView.ViewHolder {
    TextView companyName, name, phone, skills, age, competences;
    ViewHolder(View itemView){
        super(itemView);
        companyName = itemView.findViewById(R.id.companyName);
        age  = itemView.findViewById(R.id.age);
        competences = itemView.findViewById(R.id.competences);
//        name = itemView.findViewById(R.id.name);
//        phone = itemView.findViewById(R.id.phone);
//        skills = itemView.findViewById(R.id.skills);
    }
}
