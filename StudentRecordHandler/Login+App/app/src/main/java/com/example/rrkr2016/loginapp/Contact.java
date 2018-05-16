package com.example.rrkr2016.loginapp;

/**
 * Created by RRKR2016 on 11/17/2016.
 */

public class Contact {

    private  String name, email, uname, pass;

    public void setName1(String name1){
        this.name = name1;
      //  Log.d(TAG, "setName1: name");
    }
    public String getName1(){
        return name;
    }

    public void setEmail(String email1){
        this.email = email1;
     //   Log.d(TAG, "setEmail: email");
    }
    public String getEmail(){
        return email;
    }

    public void setUname(String uname1){
        this.uname = uname1;
       // Log.d(TAG, "setUname: uname");
    }
    public String getUname(){
        return uname;
    }

    public void setPass(String pass1){
        this.pass = pass1;
     //   Log.d(TAG, "setPass: pass");
    }
    public String getPass(){
        return pass;
    }
}
