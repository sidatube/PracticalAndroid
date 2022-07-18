package com.t2008m.practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edName, edDesign, edSalary;
    Button addBtn, updateBtn, deleteBtn;
    AppDatabase db;
    RecyclerView recyclerView;
    Employee employee;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        edName = findViewById(R.id.edName);
        edDesign = findViewById(R.id.edDesign);
        edSalary = findViewById(R.id.edSalary);
        addBtn = findViewById(R.id.addBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        addBtn.setOnClickListener(this);
        recyclerView = findViewById(R.id.rcv);
        List<Employee> employees = db.employeeDao().findAll();
        adapter = new EmployeeAdapter(this, employees);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addBtn:
                add();
                break;
            case R.id.updateBtn:
                update();
                break;
            case R.id.deleteBtn:
                delete();
                break;
            default:
                break;
        }
    }

    private void delete() {
        if (employee == null) {
            Toast.makeText(this, "No Employee", Toast.LENGTH_SHORT).show();

        }
        if (db.employeeDao().delete(employee) > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            employee = null;
            reloadData();
        }
    }

    private void update() {
        if (employee == null) {
            Toast.makeText(this, "No Employee", Toast.LENGTH_SHORT).show();

        }
        if (db.employeeDao().update(employee) > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            employee = null;
            reloadData();

        }
    }

    private void add() {
        int salary = 0;
        if (Integer.parseInt(edSalary.getText().toString()) > 0) {
            salary = Integer.parseInt(edSalary.getText().toString());
        }
        employee = new Employee(edName.getText().toString(), edDesign.getText().toString(), salary);
        long id = db.employeeDao().insert(employee);
        if (id > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            employee = null;
            reloadData();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }
    }

    public void reloadData() {
        List<Employee> employees = db.employeeDao().findAll();
        adapter.reloadData(employees);
        adapter.notifyDataSetChanged();

    }

    public void getInfoEmployee(int id) {
        employee = db.employeeDao().findById(id);
        edName.setText(employee.getName());
        edDesign.setText(employee.getDesign());
        edSalary.setText(employee.getSalary());
    }

    public void reset(int id) {
        employee = db.employeeDao().findById(id);
        edName.setText("");
        edDesign.setText("");
        edSalary.setText("");
    }
}