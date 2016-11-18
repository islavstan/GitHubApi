package com.islavdroid.retapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.islavdroid.retapp.R;
import com.islavdroid.retapp.model.GitHubUser;
import com.islavdroid.retapp.rest.ApiClient;
import com.islavdroid.retapp.rest.GitHubUserEndPoints;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    private TextView userNameTV,followersTV,followingTV,logInTV,emailTV,reposTV;
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
        reposTV =(TextView) findViewById(R.id.repos);
        ownedRepBtn =(Button)findViewById(R.id.ownReposBtn);
        ownedRepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           loadOwnRepos();
            }
        });
        loadData();
    }
    private void loadData(){
        //подключаемся по url
        final GitHubUserEndPoints apiService = ApiClient.getClient().create(GitHubUserEndPoints.class);
        //передаём username
        Call<GitHubUser> call = apiService.getUser(userName);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            //здесь пишем что делать с найденной информацией на сервере
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                userNameTV.setText("Username: "+response.body().getName());
                followersTV.setText("Followers: "+response.body().getFollowers());
                followingTV.setText("Following: "+response.body().getFollowing());
                logInTV.setText("LogIn: "+response.body().getLogin());
                if(response.body().getEmail()==null){
                    emailTV.setText("No email provided");
                }else{
                emailTV.setText("email: "+response.body().getEmail());}
                reposTV.setText("Your repositories: "+response.body().getRepos());
                Picasso.with(UserActivity.this).load(response.body().getAvatar()).resize(220,220).into(avatar);
            }
            @Override
            //здесь если инфы нет на сервере
            public void onFailure(Call<GitHubUser> call, Throwable t) {

            }
        });
    }
    public void loadOwnRepos(){
        Intent intent =new Intent(UserActivity.this,Repositories.class);
        intent.putExtra("USERNAME",userName);
        startActivity(intent);
    }

}
