package com.example.lenovo.pama;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private EditText website;
    private EditText email;
    private EditText password;
    private Button updatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        website = (EditText) findViewById(R.id.updatewebsite);
        email = (EditText) findViewById(R.id.updateemailid);
        password = (EditText) findViewById(R.id.updatepassword);
        updatebtn = (Button) findViewById(R.id.updaterecord);

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site = website.getText().toString();
                String id = email.getText().toString();
                String pass = password.getText().toString();

                if(!(site.equals("")) && !(id.equals("")) && !(pass.equals(""))) {
                    MyDatabaseHelper helper = new MyDatabaseHelper(getApplicationContext());
                    int result = helper.update(site, id, pass);
                    if(result == 1)
                        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(),"Record does not exist.",Toast.LENGTH_LONG).show();

//                    Cursor cur = MyDatabaseHelper.db.rawQuery("Select * from Details ;",null);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill all the 3 fields",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
