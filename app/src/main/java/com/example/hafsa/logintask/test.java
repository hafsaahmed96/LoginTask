package com.example.hafsa.logintask;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class test extends AppCompatActivity {
        EditText t1, t2;
        TextView txt1;
        DatabaseHelper db;
        Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DatabaseHelper(this);
        setContentView(R.layout.activity_test);
        t1=findViewById(R.id.usernamee);
        t2=findViewById(R.id.passwordd);
        txt1=findViewById(R.id.register2);
        btn1=findViewById(R.id.signinn);


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent regstration= new Intent(test.this, Register.class);
                startActivity(regstration);
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String usrname=t1.getText().toString();
                String pasword=t2.getText().toString();
                boolean chk= db.UserPassCheck(usrname,pasword);
                if (chk)
                {
                    Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_SHORT).show();
                     Intent inn= new Intent(test.this,Logout.class);
                    startActivity(inn);

            }
            else {Toast.makeText(getApplicationContext(),"Incorrect username or password",Toast.LENGTH_SHORT).show();
            t2.setText("");}
        }});
    }
}
