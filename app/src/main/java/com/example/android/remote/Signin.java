package com.example.android.remote;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Ahalya on 6/23/2016.
 */
public class Signin extends AppCompatActivity {
    EditText user,pass;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        Button signin = (Button) findViewById(R.id.btnSignIn);
        user = (EditText) findViewById(R.id.etUser);
        pass = (EditText) findViewById(R.id.etPass);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String usern = user.getText().toString();
                    String passn = pass.getText().toString();
                    db=getApplicationContext().openOrCreateDatabase("Remote.db",MODE_PRIVATE,null);
                    Cursor rs = db.rawQuery("select * from user where name='"+usern+"' and pass='" + passn + "';", null);
                    if (rs.moveToNext()) {
                        Intent RemoteInt=new Intent(Signin.this,Remote.class);
                        startActivity(RemoteInt);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Incorrect details",Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Log.e("ss","ss",e);
                }
            }
        });
    }
}
