package com.islavdroid.retapp.rest;

import com.islavdroid.retapp.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by islav on 14.11.2016.
 */

public interface GitHubRepoEndPoint {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>>getRepo(@Path("user")String name);
}
