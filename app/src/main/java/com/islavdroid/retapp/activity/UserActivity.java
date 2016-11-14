package com.islavdroid.retapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavdroid.retapp.R;

public class UserActivity extends AppCompatActivity {
    private TextView userNameTV,followersTV,followingTV,logInTV,emailTV;
    private ImageView avatar;
    private Button ownedRepBtn;
    private Bundle extras;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        extras = getIntent().getExtras();
        userName =extras.getString("USERNAME");

        userNameTV =(TextView)findViewById(R.id.username);
        followersTV =(TextView)findViewById(R.id.followers);
        followingTV =(TextView)findViewById(R.id.following);
        logInTV =(TextView)findViewById(R.id.logIn);
        emailTV =(TextView)findViewById(R.id.email);
        avatar =(ImageView)findViewById(R.id.avatar);
        ownedRepBtn =(Button)findViewById(R.id.ownReposBtn);
        ownedRepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    private void

}
