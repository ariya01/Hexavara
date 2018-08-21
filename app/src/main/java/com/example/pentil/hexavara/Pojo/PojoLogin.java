package com.example.pentil.hexavara.Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pentil on 15/08/2018.
 */

public class PojoLogin {
    @SerializedName("token")
    String token;

    @SerializedName("username")
    String username;

    @SerializedName("email")
    String email;

    @SerializedName("fullname")
    String fullname;

    @SerializedName("address")
    String address;

    @SerializedName("photo")
    String photo;

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoto() {
        return photo;
    }
}
