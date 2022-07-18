package com.t2008m.practical;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employees")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String design;
    @ColumnInfo
    private int salary;

    public Employee() {
    }

    public Employee(String name, String design, int salary) {
        this.name = name;
        this.design = design;
        this.salary = salary;
    }

    public Employee(int id, String name, String design, int salary) {
        this.id = id;
        this.name = name;
        this.design = design;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
