package com.example.rrkr2016.loginapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    private Button backbt, removeb;
    private EditText idd;
    DbhandlerS db;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = new DbhandlerS(this);

        backbt = (Button) findViewById(R.id.backb);
        removeb = (Button) findViewById(R.id.removeb);

        idd = (EditText) findViewById(R.id.idd);
        final String Did = idd.getText().toString();

        View.OnClickListener lback = new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent is = new Intent(Delete.this, Success.class);
                startActivity(is);
            }

        };
        backbt.setOnClickListener(lback);

        View.OnClickListener lremove = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Integer DRow = db.deleteData(Did);

                if(DRow > 0 )
                    Toast.makeText(Delete.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Delete.this, "Data not Deleted", Toast.LENGTH_LONG).show();
            }
        };
        removeb.setOnClickListener(lremove);

    }


}