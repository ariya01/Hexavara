package com.example.pentil.hexavara.API;

/**
 * Created by Pentil on 15/08/2018.
 */
import com.example.pentil.hexavara.API.APIClient;
import com.example.pentil.hexavara.API.APIInterface;

import retrofit2.Callback;



public class APIService {
    private APIInterface apiInterface;
    public APIService()
    {
        apiInterface= APIClient
                .builder()
                .create(APIInterface.class);
    }
    public void login(String username, String password,Callback callback )
    {
        apiInterface.login(username,password).enqueue(callback);
    }

    public void mylist(String auth,Callback callback)
    {
        apiInterface.mylist(auth).enqueue(callback);
    }
}
