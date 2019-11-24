package com.example.hp.ktsmilkapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1email,e2password;
    Button register,login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        e1email = (EditText)findViewById(R.id.emailLogin);
        e2password=(EditText)findViewById(R.id.passwordLogin);
        register = (Button)findViewById(R.id.btnregisterlogin);
        login =(Button)findViewById(R.id.btnLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1email.getText().toString();
                String s2 = e2password.getText().toString();
                Boolean checkmail = db.checklogin(s1,s2);
                Cursor checkUser = db.CheckUserType(s1,s2);

                if(checkmail==true) {
                    Toast.makeText(getApplicationContext(), "Succefully Login", Toast.LENGTH_SHORT).show();

                    while(checkUser.moveToNext()){

                        //Toast.makeText(getApplicationContext(),checkUser.getString(3),Toast.LENGTH_SHORT).show();

                        if(checkUser.getString(3).equals("user")){
                            Intent intent = new Intent(MainActivity.this, collectionCenter.class);
                            startActivity(intent);
                        }else if(checkUser.getString(3).equals("admin")){
                            Intent intent = new Intent(MainActivity.this, MainCollection.class);
                            startActivity(intent);
                        }

                    }

                }
                else
                    Toast.makeText(getApplicationContext(),"Incorrect email or Password",Toast.LENGTH_SHORT).show();

                if(s1.equals("")||s2.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
