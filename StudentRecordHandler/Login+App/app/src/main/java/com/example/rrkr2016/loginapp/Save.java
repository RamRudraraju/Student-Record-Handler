package com.example.rrkr2016.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Save extends AppCompatActivity {



    private EditText stulne, stufne, stumje, stugpae, stuagee;
    private Button saveb, backb;
    DbhandlerS Db ;

    String lname, fname, major, age, gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        stulne = (EditText)findViewById(R.id.stulne);
        stufne = (EditText)findViewById(R.id.stufne);
        stumje = (EditText)findViewById(R.id.stumje);
        stugpae =  (EditText)findViewById(R.id.stugpae);
        stuagee = (EditText) findViewById(R.id.stuagee);

        saveb = (Button) findViewById(R.id.saveb);
        backb = (Button) findViewById(R.id.backbu);

        Db = new DbhandlerS(this);

        View.OnClickListener save = new View.OnClickListener() { // OnClickListener for "SAVE-Button"
            @Override
            public void onClick(View v) {  // 3) When a button is tapped it passes a reference to the "v"  View

                lname = stulne.getText().toString();
                fname = stufne.getText().toString();
                major = stumje.getText().toString();
                gpa = stugpae.getText().toString();
                age = stuagee.getText().toString();

                Boolean isInserted = Db.insertData(lname, fname, major, gpa, age);

                if (isInserted == true)
                    Toast.makeText(Save.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Save.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        };
        saveb.setOnClickListener(save);// 4) Assaining the listener to all the buttons

        View.OnClickListener lback = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(Save.this, Success.class);
                startActivity(is);
            }
        };
        backb.setOnClickListener(lback);

    }


}
