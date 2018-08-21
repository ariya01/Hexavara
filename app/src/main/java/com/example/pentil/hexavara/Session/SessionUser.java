package com.example.pentil.hexavara.Session;

/**
 * Created by Pentil on 15/08/2018.
 */

public class SessionUser
{
    public static String token;

    public static String username;

    public static String email;

    public static String fullname;

    public static String address;

    public static String photo;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        SessionUser.token = token;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SessionUser.username = username;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        SessionUser.email = email;
    }

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        SessionUser.fullname = fullname;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        SessionUser.address = address;
    }

    public static String getPhoto() {
        return photo;
    }

    public static void setPhoto(String photo) {
        SessionUser.photo = photo;
    }
}
