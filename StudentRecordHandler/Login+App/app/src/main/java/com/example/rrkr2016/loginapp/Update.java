package com.example.rrkr2016.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by RRKR2016 on 11/17/2016.
 */



public class Update extends AppCompatActivity {

    private EditText stulne, stufne, stumje, stugpae, stuagee, stuide;
    private Button updateb, backbu;
    DbhandlerS db ;

    String lname, fname, major, age, gpa, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        stulne = (EditText)findViewById(R.id.stulne);
        stufne = (EditText)findViewById(R.id.stufne);
        stumje = (EditText)findViewById(R.id.stumje);
        stugpae =  (EditText)findViewById(R.id.stugpae);
        stuagee = (EditText) findViewById(R.id.stuagee);
        stuide = (EditText) findViewById(R.id.stuide);

        updateb = (Button) findViewById(R.id.updatebu); //updatebu
        backbu = (Button) findViewById(R.id.backbu);

        db = new DbhandlerS(this);

        View.OnClickListener lupdate = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lname = stulne.getText().toString();
                fname = stufne.getText().toString();
                major = stumje.getText().toString();
                gpa = stugpae.getText().toString();
                age = stuagee.getText().toString();
                id =  stuide.getText().toString();

                boolean isUpdated = db.updateData(id, fname, lname, major, gpa, age);

                if(isUpdated == true)
                    Toast.makeText(Update.this, "Data updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Update.this, "Data was not updated", Toast.LENGTH_LONG).show();
            }
        };
        updateb.setOnClickListener(lupdate);

        View.OnClickListener lback = new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(Update.this, Success.class);
                startActivity(is);
            }
        };
        backbu.setOnClickListener(lback);


    }

}
