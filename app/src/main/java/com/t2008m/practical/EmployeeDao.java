package com.t2008m.practical;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    long insert(Employee employee);

    @Update
    int update(Employee employee);

    @Delete
    int delete(Employee employee);

    @Query("select * from employees")
    List<Employee> findAll();

    @Query("select * from employees where id = :id")
    Employee findById(int id);
}
