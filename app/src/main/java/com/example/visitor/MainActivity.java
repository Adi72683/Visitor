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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
                String A = et1.getText().toString();
                String K = et2.getText().toString();
                String T = et3.getText().toString();
                String C = et4.getText().toString();

               if(A.isEmpty()||K.isEmpty()||T.isEmpty()||C.isEmpty()){
                   Toast.makeText(getApplicationContext(), "ALL THE FIELDS MUST BE FILLED", Toast.LENGTH_LONG).show();
               }
               else
                {
                    try {
                        callApi();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
        }

            private void callApi() throws JSONException {
                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",et1);
                    data.put("lastname",et2);
                    data.put("whomToMeet",et3);
                    data.put("purpose",et4);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request= new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_LONG).show(),
                        error -> Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_LONG).show()
                );
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

            }
            });

    }
}