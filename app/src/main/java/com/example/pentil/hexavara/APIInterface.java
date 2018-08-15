package com.example.pentil.hexavara;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Pentil on 15/08/2018.
 */

public interface APIInterface
{
    @FormUrlEncoded
    @POST("login")
    Call<PojoLogin> login(
      @Field("username") String username,
      @Field("password") String password
    );
}