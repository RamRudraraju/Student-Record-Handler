package com.example.rrkr2016.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by RRKR2016 on 11/17/2016.
 */

public class Dbhandler extends SQLiteOpenHelper {

    // Data base for Registration
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";

    private static final String COL_1 = "id";
    private static final String COL_2 = "name";
    private static final String COL_3 = "email";
    private static final String COL_4 = "uname";
    private static final String COL_5 = "pass";
    private static final String TAG = "Dbhandler";

    // Data base  for  Inserting Student data
    public SQLiteDatabase db;

    private  static  final String TABLE_CREATE = "create table contacts (id integer primary key not null," +
            "name text not null, email text not null, uname text not null, pass text not null)";


    public Dbhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // In constructor we have to create database.
        // SQLiteDatabase db = this.getWritableDatabase();
        Log.d(TAG, "Dbhandler: Register Data base was created ");


    }                                           // When ever the constructor is called Database is created.


    @Override
    public void onCreate(SQLiteDatabase db) {   // When ever onCreate method is called we have to create table



        db.execSQL(TABLE_CREATE);
        this.db = db;

        Log.d(TAG, "onCreate: Table was created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String oUP = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(oUP);
        onCreate(db);
    }

    public void insertData(Contact c) {

        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        String qr = "Select * from contacts";
        Cursor cursor = db.rawQuery(qr, null);
        int count = cursor.getCount();

        cv.put(COL_1, count);
        cv.put(COL_2, c.getName1());
        cv.put(COL_3, c.getEmail());
        cv.put(COL_4, c.getUname());
        cv.put(COL_5, c.getPass());

        db.insert(TABLE_NAME, null, cv);

        Log.d(TAG, "InsertData: Data was inserted");

        db.close();
    }

    public Boolean searchPass(String uname, String pa ){

        Log.d(TAG, "searchPass: Entered");

        db = this.getReadableDatabase();
        String que = "select uname, pass from "+TABLE_NAME;
        Cursor cr = db.rawQuery(que, null);
        String u, p;
        // int n =0;
        // p= "Not Found.";
        Boolean tf = false;

        if(cr.moveToFirst())
        {
            Log.d(TAG, "Entered in if");


            do{
                Log.d(TAG, "Entered into DoWhile Loop");
                u = cr.getString(0);

                if(u.equals(uname) )
                {
                    Log.d(TAG, "Username Match");
                    p = cr.getString(1);
                    if(pa.equals(p))
                    {
                        tf = true;
                        break;
                    }
                    else
                        Log.d(TAG, "Password did not Match");
                }
                else
                    Log.d(TAG, "Username Did not Match");

            }while (cr.moveToNext());
        }
        db.close();

        if((tf == true) || (tf == false))
        {
            Log.d(TAG, "searchPass: True OR False");
        }

        return tf;
    }

}
