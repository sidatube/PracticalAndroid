package com.t2008m.practical;

import android.app.Activity;
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
    private ItemClickListener itemClickListener;


    public EmployeeAdapter(Activity activity, List<Employee> employees) {
        this.activity = activity;
        this.employees = employees;
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        this.itemClickListener = clickListener;
    }

    public void reloadData(List<Employee> employees) {
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

        vh.tvName.setText(model.getName());
        vh.tvDesign.setText(model.getDesign());
        vh.tvSalary.setText(model.getSalary() + "");
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDesign, tvSalary;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onClick(view,getAdapterPosition(),false);
                }
            });
            tvName = itemView.findViewById(R.id.tvName);
            tvDesign = itemView.findViewById(R.id.tvDesign);
            tvSalary = itemView.findViewById(R.id.tvSalary);
        }


    }
}
