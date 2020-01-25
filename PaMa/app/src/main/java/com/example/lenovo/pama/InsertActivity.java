package com.example.lenovo.pama;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    private EditText website;
    private EditText emailid;
    private EditText password;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        website = (EditText) findViewById(R.id.website);
        emailid = (EditText) findViewById(R.id.emailid);
        password = (EditText) findViewById(R.id.password);
        add = (Button) findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site = website.getText().toString();
                String id = emailid.getText().toString();
                String pass = password.getText().toString();


//                Toast.makeText(getApplicationContext(),site.length(),Toast.LENGTH_SHORT).show();

                if(!(site.equals("")) && !(id.equals("")) && !(pass.equals(""))) {
                    MyDatabaseHelper helper = new MyDatabaseHelper(getApplicationContext());
                    helper.insert(site, id, pass);
                    Cursor cur = MyDatabaseHelper.db.rawQuery("Select * from Details ;",null);
                    Toast.makeText(getApplicationContext(),""+cur.getCount(),Toast.LENGTH_LONG).show();
//                    Toast.makeText(getApplicationContext(),site+","+id+","+pass,Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill all the 3 fields",Toast.LENGTH_SHORT).show();
                }

//                while(cur.moveToNext()){
////                    String row = "";
////                    row = cur.getString(0);
////                    row += cur.getString(1);
////                    row += cur.getString(2);
////                    Log.d("------",row);
//                }

            }
        });
    }
}
