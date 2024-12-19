package com.example.visitor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    Button btnlogin;

    String s1 = "Aditya";
    String s2 = "Krishna";

    String s3 = "Teacher";
    String s4 = "Class";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        btnlogin = findViewById(R.id.btnLogin);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Aditya = et1.getText().toString();
                String Krishna = et2.getText().toString();
                String Teacher = et3.getText().toString();
                String Class = et4.getText().toString();

                if (Aditya.equals(s1) && Krishna.equals(s2) && Teacher.equals(s3) && Class.equals(s4)) {

                    Toast.makeText(getApplicationContext(), "APPROVED", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}