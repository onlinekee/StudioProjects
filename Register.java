package com.example.hp.ktsmilkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper db;
    EditText usrname,editemail,editpassword,confirmpassword;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);

        usrname= (EditText)findViewById(R.id.registerUserName);
        editemail=(EditText)findViewById(R.id.registerEmail);
        editpassword=(EditText)findViewById(R.id.registerPassword);
        confirmpassword=(EditText)findViewById(R.id.regConfirmPassword);
        register = (Button)findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = usrname.getText().toString();
                String s2 = editemail.getText().toString();
                String s3 = editpassword.getText().toString();
                String s4 =confirmpassword.getText().toString();

                if(s1.equals("")|| s2.equals("")|| s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s3.equals(s4)) {
                        Boolean checkmail = db.checkmail(s2);
                        if (checkmail == true) {
                            Boolean insert = db.insert(s1, s2, s3);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();

                    }
                }


            }
        });
    }
}
