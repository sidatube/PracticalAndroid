package com.t2008m.practical;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class},version = 1)
public abstract class AppDatabase  extends RoomDatabase {
    public static  AppDatabase appDatabase;
    public abstract EmployeeDao employeeDao();
    public static AppDatabase getAppDatabase(Context context){
        if (appDatabase==null){
            appDatabase= Room.databaseBuilder(context,AppDatabase.class,"PracticalDatabase").allowMainThreadQueries().build();
        }
        return appDatabase;
    }

}
