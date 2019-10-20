package com.danilkomyshev.htc_test.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.R;

class CompanyViewHolder extends RecyclerView.ViewHolder {
    TextView companyName, age, competences;

    CompanyViewHolder(View itemView){
        super(itemView);
        companyName = itemView.findViewById(R.id.companyName);
        age  = itemView.findViewById(R.id.age);
        competences = itemView.findViewById(R.id.competences);
    }
}