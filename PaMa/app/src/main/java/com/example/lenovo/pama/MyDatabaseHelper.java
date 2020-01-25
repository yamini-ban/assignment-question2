package com.example.lenovo.pama;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static SQLiteDatabase db;

    public MyDatabaseHelper(Context context) {
        super(context, "details", null, 3, new DatabaseErrorHandler() {
            @Override
            public void onCorruption(SQLiteDatabase dbObj) {
                Log.d("-.-","Database Error");
            }
        });
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE 'details' (\n" +
                "\t`WEBSITE`\tTEXT,\n" +
                "\t`EMAIL`\tTEXT,\n" +
                "\t`PASSWORD`\tTEXT,\n" +
                "\tPRIMARY KEY(`WEBSITE`,`EMAIL`)\n" +
                ");");

//        db.execSQL("CREATE TABLE `LoginDetails` (\n" +
//                "\t`Email`\tTEXT,\n" +
//                "\t`username`\tTEXT,\n" +
//                "\t`password`\tTEXT NOT NULL,\n" +
//                "\tPRIMARY KEY(`Email`)\n" +
//                ");");

        db.execSQL("INSERT INTO details VALUES(\"google.com\",\"xyz@yahoo.com\",\"123abc\");");
//        db.execSQL("Insert into Logindetails values (\"xyz@yahoo.com\",\"xyz\",\"123\");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(String website, String email, String password){
            String query = "INSERT INTO details VALUES (?,?,?);";
            db.execSQL(query , new Object[]{website,email,password});
    }
    public void insertRegister(String name,String email,String password) {
        String query = "Insert into Logindetails values (?,?,?);";
        db.execSQL(query,new Object[]{name,email,password});
    }

    public int update(String website, String email, String password) {
        Cursor cur = db.rawQuery("Select * from details;",null);
        while(cur.moveToNext()){
            if(cur.getString(0).equals(website) && cur.getString(1).equals(email)){
                String query = "update details set password=? where website = ? and email = ?;";
                db.execSQL(query,new Object[]{password,website,email});
                return 1;
            }
        }
        return -1;
    }

    public int delete(String web, String email) {
        Cursor cur = db.rawQuery("Select * from details;",null);
        while(cur.moveToNext()) {
            if(cur.getString(0).equals(web) && cur.getString(1).equals(email)) {
                String query = "delete from details where website = ? and email = ? ;";
                db.execSQL(query,new Object[]{web,email});
                return 1;
            }
        }
        return -1;
    }
}
