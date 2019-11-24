package com.example.hp.ktsmilkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class collection_center_insert extends AppCompatActivity {

    DatabaseHelper db;
    Button save;
    EditText uom,qty,comment;
    Spinner session,item,supplier,reading,test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_center_insert);

        db = new DatabaseHelper(this);

        save = (Button)findViewById(R.id.btn_save);
        uom= (EditText) findViewById(R.id.editText_uom);
        qty= (EditText) findViewById(R.id.editText_qty);
        comment= (EditText) findViewById(R.id.editText_comment);
        session= (Spinner) findViewById(R.id.spinner_session);
        item= (Spinner) findViewById(R.id.spinner_item);
        supplier= (Spinner) findViewById(R.id.spinner_supplier);
        reading= (Spinner) findViewById(R.id.spinner_reading);
        test= (Spinner) findViewById(R.id.spinner_test);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insert = db.insertCollection(session.getSelectedItem().toString(),item.getSelectedItem().toString(),supplier.getSelectedItem().toString(),reading.getSelectedItem().toString(),test.getSelectedItem().toString(),uom.getText().toString(),Integer.parseInt(qty.getText().toString()),comment.getText().toString());

                if(insert == true){
                    Toast.makeText(getApplicationContext(),"Inserted Successfully!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(collection_center_insert.this, collectionCenter.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Insertion Failed!",Toast.LENGTH_SHORT).show();
                }

            }
        });









    }
}
