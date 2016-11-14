package com.islavdroid.retapp.rest;


import com.islavdroid.retapp.model.GitHubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/*Описание запросов к серверу происходит в интерфейсе. Над каждым
        методом должна стоять аннотация, с помощью которой Retrofit «узнает»,
        какого типа запрос.*/

public interface GitHubUserEndPoints {
    //перед первым слешом идёт наш base url, дальше мы указываем string user которое будет вставляться
    //для отображения инфы
    //Call - метод
    // getUser -имя метода
    //<GitHubUser> -тип возвращаемых данных
    // (@Path("user")String user) - В параметрах метода указываем что мы хотим передавать в запрос
    @GET("/users/{user}")
    Call<GitHubUser> getUser(@Path("user")String user);


}
