package com.example.lenovo.pama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    private Button delete_delete;
    private EditText website_delete;
    private EditText email_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        website_delete = (EditText) findViewById(R.id.website_delete);
        email_delete = (EditText) findViewById(R.id.email_delete);
        delete_delete = (Button) findViewById(R.id.delete_btn);

        delete_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String web = website_delete.getText().toString();
                String email = email_delete.getText().toString();

                MyDatabaseHelper helper = new MyDatabaseHelper(getApplicationContext());
                if(!(web.equals("")) && !(email.equals(""))) {

                    if(helper.delete(web,email)==1){
                        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Cannot delete record, please enter valid details.",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please fill both the fields.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
