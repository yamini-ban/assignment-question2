package com.example.lenovo.pama;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private View rootView;
    private EditText email;
    private EditText password;
    private EditText username;
    private Button register;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_register, container, false);

        email = (EditText) rootView.findViewById(R.id.email);
        username = (EditText) rootView.findViewById(R.id.username);
        password = (EditText) rootView.findViewById(R.id.password);
        register = (Button) rootView.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = email.getText().toString();
                String name = username.getText().toString();
                String pass = password.getText().toString();

                if (!(name.equals("")) && !(id.equals("")) && !(pass.equals(""))) {
                    MyDatabaseHelper helper = new MyDatabaseHelper(getActivity());
                    helper.insertRegister(name, id, pass);
                    Cursor cur = MyDatabaseHelper.db.rawQuery("Select * from logindetails ;", null);
                    Toast.makeText(getContext(), "" + cur.getCount(), Toast.LENGTH_LONG).show();
//                    Toast.makeText(getApplicationContext(),site+","+id+","+pass,Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Please fill all the 3 fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }

}
