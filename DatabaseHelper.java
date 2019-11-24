package com.example.hp.ktsmilkapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null,1);
    }


    //create user table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(name text, email text primary key,password text,type text)");

        db.execSQL("Create table collectionCenter(id integer primary key AutoIncrement,session text,item text, supplier text, reading text, test text, String uom, qty integer, comment text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists collectionCenter");

    }
    //insert into database
    public boolean insert (String name,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("type","user");

        long ins = db.insert("user",null,contentValues);
        if(ins== -1) return false;
        else return true;


    }
    //insert collectioncenterdata
    public boolean insertCollection(String session,String item,String supplier,String reading, String test, String uom, int qty, String comment){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("session",session);
        contentValues.put("item", item);
        contentValues.put("supplier", supplier);
        contentValues.put("reading",reading);
        contentValues.put("test",test);
        contentValues.put("uom", uom);
        contentValues.put("qty", qty);
        contentValues.put("comment",comment);

        long ins = db.insert("collectionCenter",null,contentValues);
        if(ins== -1) return false;
        else return true;

    }
    //checking if email exists;
    public Boolean checkmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;

    }
    //check uaer type
    public Cursor CheckUserType(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
            return cursor;
    }

    //check the login email,password
    public Boolean checklogin(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

    public Cursor getAllCollections(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from collectionCenter", null);
        return cursor;
    }

}

