package com.islavdroid.retapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.islavdroid.retapp.R;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText inputUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton =(Button)findViewById(R.id.btn_login);
        inputUserName =(EditText) findViewById(R.id.input_username);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUser();
            }
        });


    }


    private void getUser(){
        Intent intent =new Intent(MainActivity.this,UserActivity.class);
        intent.putExtra("USERNAME",inputUserName.getText().toString());
        startActivity(intent);
    }
}
