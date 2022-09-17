package com.example.soru2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MySQLiteDB extends SQLiteOpenHelper {
    private static final String databaseName="MyInformationDb";
    private static final int version=1;
    SQLiteDatabase db;
    private ArrayList<MyInformation> myInformations = new ArrayList<>();
    public MySQLiteDB(Context context){

        super(context,databaseName,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="CREATE TABLE MyInformation(id INTEGER PRIMARY KEY AUTOINCREMENT , website TEXT,username TEXT,password TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addInformation(String website, String username, String password){
        ContentValues values= new ContentValues();
        values.put("website",website);
        values.put("username",username);
        values.put("password",password);
        db= this.getWritableDatabase();
        db.insert("MyInformation",null,values);
        db.close();
    }
    public ArrayList<MyInformation> getList(){
        String sql="Select id,website,username,password from MyInformation";
        db= this.getReadableDatabase();
        Cursor curser=db.rawQuery(sql,null);

        while (curser.moveToNext()) {
            Integer id = curser.getInt(curser.getColumnIndexOrThrow("id"));
            String website = curser.getString(curser.getColumnIndexOrThrow("website"));
            String username = curser.getString(curser.getColumnIndexOrThrow("username"));
            String password = curser.getString(curser.getColumnIndexOrThrow("password"));
            myInformations.add(new MyInformation(id, website, username, password));
        }

        return myInformations;
    }

}
