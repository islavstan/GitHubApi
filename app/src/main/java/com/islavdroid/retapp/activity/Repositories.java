package com.islavdroid.retapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.islavdroid.retapp.R;
import com.islavdroid.retapp.ReposAdapter;
import com.islavdroid.retapp.model.GitHubRepo;
import com.islavdroid.retapp.rest.ApiClient;
import com.islavdroid.retapp.rest.GitHubRepoEndPoint;
import com.islavdroid.retapp.rest.GitHubUserEndPoints;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories extends AppCompatActivity {
    private String receivedUserName;
    TextView userNameTV;
    RecyclerView mRecyclerView;
    List<GitHubRepo>myDataSource = new ArrayList<>();
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle extras =getIntent().getExtras();
        receivedUserName=extras.getString("USERNAME");
        userNameTV =(TextView)findViewById(R.id.userNameTv);
        userNameTV.setText("User: "+receivedUserName);
        mRecyclerView =(RecyclerView)findViewById(R.id.repos_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter =new ReposAdapter(myDataSource,R.layout.item_repo,getApplicationContext());
        mRecyclerView.setAdapter(myAdapter);
        loadRepositiries();
    }

    private void loadRepositiries() {
        GitHubRepoEndPoint apiService = ApiClient.getClient().create(GitHubRepoEndPoint.class);
        Call<List<GitHubRepo>> call =apiService.getRepo(receivedUserName);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                myDataSource.clear();
                myDataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });

    }
}
