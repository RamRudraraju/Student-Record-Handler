package com.example.rrkr2016.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RRKR2016 on 11/17/2016.
 */



public class DbhandlerS extends SQLiteOpenHelper {



    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_table";

    public static final String COL_1 = "StudentID";
    public static final String COL_2 = "StudentFName";
    public static final String COL_3 = "StudentLName";
    public static final String COL_4 = "StudentMajor";
    public static final String COL_5 = "StudentGpa";
    public static final String COL_6 = "StudentAge";

    public DbhandlerS(Context context) {
        super(context, DATABASE_NAME, null, 1); // In constructor we have to create database.
        // SQLiteDatabase db = this.getWritableDatabase();
    }                                           // When ever the constructor is called Database is created.


    @Override
    public void onCreate(SQLiteDatabase db) {   // When ever onCreate method is called we have to create table

        // db.execSQL("CREATE TABLE "+ TABLE_NAME + "(StudentID INTEGER PRIMARY KEY AUTOINCREMENT, StudentFName TEXT, StudentLName TEXT, StudentMajor TEXT, StudentGPA DOUBLE, StudentAge INTEGER)" ); // db.execSQL(); it will execute the quirey which was passed in "()"
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(StudentID INTEGER PRIMARY KEY AUTOINCREMENT, StudentFName TEXT, StudentLName TEXT, StudentMajor TEXT, StudentGPA TEXT, StudentAge TEXT)"); // db.execSQL(); it will execute the quirey which was passed in "()"

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    // public boolean insertData(String fname, String lname, String major, Double gpa, int sage){
    public boolean insertData(String fname, String lname, String major, String gpa, String sage) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_2, fname);
        cv.put(COL_3, lname);
        cv.put(COL_4, major);
        cv.put(COL_5, gpa);
        cv.put(COL_6, sage);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null); // Cursor is an interface which provides random Read write access to our result.
        // Result of the query was stored in "res".
        return res;

    }

    public boolean updateData(String id, String fname, String lname, String major, String gpa, String age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, id);
        cv.put(COL_2, fname);
        cv.put(COL_3, lname);
        cv.put(COL_4, major);
        cv.put(COL_5, gpa);
        cv.put(COL_6, age);
        db.update(TABLE_NAME, cv, "StudentID = ?", new String[]{id});
        return true;
    }

    public  Integer deleteData (String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME, "StudentID = ?", new String[] {id});
    }



}