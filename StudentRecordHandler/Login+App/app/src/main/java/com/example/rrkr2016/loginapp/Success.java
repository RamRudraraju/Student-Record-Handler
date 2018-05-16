package com.example.rrkr2016.loginapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by RRKR2016 on 11/17/2016.
 */



public class Success extends AppCompatActivity {

    private Button addr, deletr, updater, showr, sback;
    DbhandlerS db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);



        addr = (Button) findViewById(R.id.addrs);
        deletr = (Button) findViewById(R.id.deleter);
        updater = (Button) findViewById(R.id.updater);
        showr = (Button) findViewById(R.id.showr);
        sback = (Button) findViewById(R.id.sback);


        db = new DbhandlerS(this);

        // Associated with 1st button
        View.OnClickListener lsave = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(Success.this, Save.class);
                startActivity(is);
            }
        };
        addr.setOnClickListener(lsave);

        View.OnClickListener ldelete = new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(Success.this, Delete.class);
                startActivity(is);
            }
        };
        deletr.setOnClickListener(ldelete);

        View.OnClickListener lupdate = new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(Success.this, Update.class);
                startActivity(is);
            }
        };
        updater.setOnClickListener(lupdate);


        View.OnClickListener lback = new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(Success.this, MainActivity.class);
                startActivity(is);
            }

        };
        sback.setOnClickListener(lback);


        View.OnClickListener sarc = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllData();

                if(res.getCount()==0){
                    showmessage ("Error", "Noting Found");// Method to show Data.
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Student Id: "+ res.getString(0)+ "\n");
                    buffer.append("Last Name : "+ res.getString(1)+ "\n");
                    buffer.append("First Name: "+ res.getString(2)+ "\n");
                    buffer.append("Major : "+ res.getString(3)+ "\n");
                    buffer.append("Gpa   : "+ res.getString(4)+ "\n");
                    buffer.append("Age   : "+ res.getString(5)+ "\n\n");
                }
                showmessage("Data", buffer.toString()); // Method to show Data.
            }
        };
        showr.setOnClickListener(sarc);
    }

    public void showmessage (String title, String message)
    {
        AlertDialog.Builder builder = new  AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}

