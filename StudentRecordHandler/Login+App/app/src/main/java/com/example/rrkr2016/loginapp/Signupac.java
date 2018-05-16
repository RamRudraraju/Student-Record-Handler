package com.example.rrkr2016.loginapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by RRKR2016 on 11/17/2016.
 */



public class Signupac extends AppCompatActivity {

    Dbhandler Db2 = new Dbhandler(this);

    EditText TFname, TFemail, TFuname, TFpass1, TFpass2;
    Button Bsignupbutton;
    private static final String TAG = "Signupac";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupac);

        Bsignupbutton = (Button) findViewById(R.id.Bsignupbutton);

        View.OnClickListener lsave = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                TFname = (EditText)findViewById(R.id.TFname);
                TFemail = (EditText)findViewById(R.id.TFemail);
                TFuname = (EditText)findViewById(R.id.TFuname);
                TFpass1 = (EditText)findViewById(R.id.TFpass1);
                TFpass2 = (EditText)findViewById(R.id.TFpass2);

                String name = TFname.getText().toString();
                String email = TFemail.getText().toString();
                String uname = TFuname.getText().toString();
                String pass1 = TFpass1.getText().toString();
                String pass2 = TFpass2.getText().toString();

                if(!pass1.equals(pass2))
                {
                    Toast t = Toast.makeText(Signupac.this, "Password don't Match", Toast.LENGTH_SHORT);
                    t.show();
                }
                else
                {
                    // Inserting Data
                    Toast t = Toast.makeText(Signupac.this, "Your account was created", Toast.LENGTH_SHORT);
                    t.show();

                    Log.d(TAG, "onClick: Defore cretion of Contact Object");

                    Contact c = new Contact();
                    c.setName1(name);
                    c.setEmail(email);
                    c.setUname(uname);
                    c.setPass(pass1);

                    Db2.insertData(c);
                    Db2.close();

                }

            }

        };
        Bsignupbutton.setOnClickListener(lsave);
    }
}