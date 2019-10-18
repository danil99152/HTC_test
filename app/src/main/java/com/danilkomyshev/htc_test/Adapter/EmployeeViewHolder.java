package com.danilkomyshev.htc_test.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.danilkomyshev.htc_test.R;

class EmployeeViewHolder extends RecyclerView.ViewHolder {
    TextView name, phone, skills;
    EmployeeViewHolder(View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.name);

//        name = itemView.findViewById(R.id.name);
//        phone = itemView.findViewById(R.id.phone);
//        skills = itemView.findViewById(R.id.skills);
    }
}
