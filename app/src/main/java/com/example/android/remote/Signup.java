package com.example.android.remote;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ahalya on 6/23/2016.
 */
public class Signup extends AppCompatActivity {
    EditText user,pass;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button signin=(Button)findViewById(R.id.btnSignIn);
        user=(EditText)findViewById(R.id.etUser);
        pass=(EditText)findViewById(R.id.etPass);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String usern=user.getText().toString();
                    String passn=pass.getText().toString();
                    SQLiteDatabase db=openOrCreateDatabase("Remote.db",MODE_PRIVATE,null);
                    db.execSQL("create table if not exists user(name varchar,pass varchar);");
                    db.execSQL("insert into user values('" + usern + "','" + passn + "');");
                    Toast.makeText(getApplicationContext(),"Inserted!",Toast.LENGTH_LONG).show();
                } catch(Exception e){
                    Log.e("dd","ddd",e);
                }
            }
        });

    }
}
