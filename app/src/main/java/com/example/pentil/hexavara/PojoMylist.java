package com.example.pentil.hexavara;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pentil on 15/08/2018.
 */

public class PojoMylist
{
    @SerializedName("name")
    String name;

    @SerializedName("salary")
    String salary;

    @SerializedName("image")
    String image;

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public String getImage() {
        return image;
    }
}
