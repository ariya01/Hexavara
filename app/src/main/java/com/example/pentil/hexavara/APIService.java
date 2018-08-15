package com.example.pentil.hexavara;

/**
 * Created by Pentil on 15/08/2018.
 */
import retrofit2.Callback;



public class APIService {
    private APIInterface apiInterface;
    public APIService()
    {
        apiInterface=APIClient
                .builder()
                .create(APIInterface.class);
    }
    public void login(String username, String password,Callback callback )
    {
        apiInterface.login(username,password).enqueue(callback);
    }
}
