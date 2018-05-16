package com.example.rrkr2016.loginapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dbhandler Db1 = new Dbhandler(this);

    EditText TFusername, TFpassword;
    Button Bsignup, Blogin, fc, fs, clear;
    String Username, Password, Opassword;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TFusername = (EditText) findViewById(R.id.TFusername);
        TFpassword = (EditText) findViewById(R.id.TFpassword);
        Bsignup = (Button) findViewById(R.id.Bsignup);
        Blogin = (Button) findViewById(R.id.Blogin);
        fc = (Button) findViewById(R.id.fs);
        fs = (Button) findViewById(R.id.fs);
        clear = (Button) findViewById(R.id.clear);

        registerForContextMenu(fc);
        registerForContextMenu(TFusername);
        registerForContextMenu(TFpassword);

        //Elertes the system that btn and
        //    registerForContextMenu(TFpassword);
        //   registerForContextMenu(TFusername);

        //  registerForContextMenu(fs);

        View.OnClickListener log = new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast tl = Toast.makeText(MainActivity.this, "Entered in to the login", Toast.LENGTH_SHORT);
                tl.show();

                TFusername = (EditText) findViewById(R.id.TFusername); // TFusername
                Username = TFusername.getText().toString();

                TFpassword = (EditText) findViewById(R.id.TFpassword);
                Password = TFpassword.getText().toString();

                Log.d(TAG, "onClick: Of Login ");

                //  Opassword = Db1.searchPass(Username, Password);
                Boolean tf = Db1.searchPass(Username, Password);

                if(tf){

                    Log.d(TAG, "Login Successful");

                    Toast t = Toast.makeText(MainActivity.this, "Login Successful ", Toast.LENGTH_SHORT);
                    t.show();

                    Intent is = new Intent(MainActivity.this, Success.class);
                    startActivity(is);
                }
                else
                {
                    Toast t = Toast.makeText(MainActivity.this, "Wrong Username OR Password ", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        };
        Blogin.setOnClickListener(log);
        //

        View.OnClickListener lsave = new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Intent are = new Intent(MainActivity.this, Signupac.class);
                Log.d(TAG, "Password did not Match");
                startActivity(are);
            }
        };

        Bsignup.setOnClickListener(lsave);


        View.OnClickListener cclear = new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                TFusername.setText("");
                TFpassword.setText("");

                //  Intent is = new Intent(MainActivity.this, Signupac.class);
                //   startActivity(is);
            }
        };
        clear.setOnClickListener(cclear);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "Menu was activated.");
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "User clicked on Menu.");

        switch (item.getItemId()){

            case R.id.signup:
                this.startActivity(new Intent(this, Signupac.class));

        }
        return super.onOptionsItemSelected(item);
    }


    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()){
            case R.id.fs:
                menu.setHeaderTitle("List of Colors");
                menu.add(0,1,0,"Red");
                menu.add(0,2,0,"Blue");
                menu.add(0,7,0,"Green");
                menu.add(0,8,0,"Yellow");
                break;

            case R.id.TFusername:
            case R.id.TFpassword:
                menu.setHeaderTitle("Font size");
                menu.add(0,3,0,"12");
                menu.add(0,4,0,"18");
                menu.add(0,5,0,"24");
                menu.add(0,6,0,"30");
                break;
        }
        // getMenuInflater().inflate(R.menu.main_colors, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId() == 1){

            Log.d(TAG, "onContextItemSelected: Red");
            TFusername.setTextColor(Color.RED);
            TFpassword.setTextColor(Color.RED);
        }else if(item.getItemId() == 2){

            Log.d(TAG, "onContextItemSelected: Blue");
            TFusername.setTextColor(Color.BLUE);
            TFpassword.setTextColor(Color.BLUE);
        }
        else if(item.getItemId() == 3){

            Log.d(TAG, "onContextItemSelected: 12");
            TFusername.setTextSize(12);
            TFpassword.setTextSize(12);
        }
        else if(item.getItemId() == 4){

            Log.d(TAG, "onContextItemSelected: 24");
            TFusername.setTextSize(24);
            TFpassword.setTextSize(24);
        }
        else if(item.getItemId() == 5){

            Log.d(TAG, "onContextItemSelected: 18");
            TFusername.setTextSize(18);
            TFpassword.setTextSize(18);
        }
        else if(item.getItemId() == 6){

            Log.d(TAG, "onContextItemSelected: 24");
            TFusername.setTextSize(24);
            TFpassword.setTextSize(24);
        }

        else if(item.getItemId() == 7){

            Log.d(TAG, "onContextItemSelected: Blue");
            TFusername.setTextColor(Color.GREEN);
            TFpassword.setTextColor(Color.GREEN);
        }
        else if(item.getItemId() == 8){

            Log.d(TAG, "onContextItemSelected: Blue");
            TFusername.setTextColor(Color.YELLOW);
            TFpassword.setTextColor(Color.YELLOW);
        }
        else
            return false;

        return true;

        //return super.onContextItemSelected(item);
    }



  /*  @Override // Creating the Menu based on con
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.main_colors, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

       switch (item.getItemId()){
           case R.id.red:
               Log.d(TAG, "onContextItemSelected: Red");
               TFusername.setTextColor(Color.RED);
               TFpassword.setTextColor(Color.RED);
               break;

           case R.id.blue:
               Log.d(TAG, "onContextItemSelected: Blue");
               TFusername.setTextColor(Color.BLUE);
               TFpassword.setTextColor(Color.BLUE);
               break;
       }

        return super.onContextItemSelected(item);
    }

    */


    }








