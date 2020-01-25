package com.example.lenovo.pama;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    private TableLayout displayactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        displayactivity = (TableLayout) findViewById(R.id.display_activity);

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = myDatabaseHelper.db;

        Cursor cur = db.rawQuery("Select * from details",null);
//        Cursor cur1 = db.rawQuery("select * from logindetails",null);

        TableRow thead = (TableRow) LayoutInflater.from(this).inflate(R.layout.sample_row,null,false);
        thead.setBackgroundColor(Color.BLACK);

        TextView tv = (TextView) thead.findViewById(R.id.website_row);
        tv.setText("Website");
        tv.setTextColor(Color.WHITE);

        tv = (TextView) thead.findViewById(R.id.email_row);
        tv.setText("EmailID");
        tv.setTextColor(Color.WHITE);

        tv = (TextView) thead.findViewById(R.id.password_row);
        tv.setText("Password");
        tv.setTextColor(Color.WHITE);

        displayactivity.addView(thead);

        while (cur.moveToNext()){

            TableRow tr = (TableRow) LayoutInflater.from(this).inflate(R.layout.sample_row,null,false);

            TextView textV = (TextView) tr.findViewById(R.id.website_row);
            textV.setText(cur.getString(0));

            textV = (TextView) tr.findViewById(R.id.email_row);
            textV.setText(cur.getString(1));

            textV = (TextView) tr.findViewById(R.id.password_row);
            textV.setText(cur.getString(2));

            displayactivity.addView(tr);

            String row = "";
            row += cur.getString(0)+",";
            row += cur.getString(1)+",";
            row += cur.getString(2);
            Log.d("-----",row);

        }
        Toast.makeText(this,""+cur.getCount()+" records found.",Toast.LENGTH_SHORT).show();

//        while(cur1.moveToNext()) {
//            String row = "";
//            row += cur.getString(0)+"-";
//            row += cur.getString(1)+"-";
//            row += cur.getString(2);
//            Log.d("-----",row);
//        }

    }
}
