package com.t2008m.practical;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t2008m.practical.util.ItemClickListener;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Employee> employees;

    public EmployeeAdapter(Activity activity, List<Employee> employees) {
        this.activity = activity;
        this.employees = employees;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_employee, parent, false);

        return new EmployeeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder vh = (EmployeeHolder) holder;
        Employee model = employees.get(position);
        vh.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class EmployeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        private ItemClickListener itemClickListener;
        TextView tvName, tvDesign, tvSalary;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesign = itemView.findViewById(R.id.tvDesign);
            tvSalary = itemView.findViewById(R.id.tvSalary);
        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }
}
