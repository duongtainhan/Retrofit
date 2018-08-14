package com.example.duongtainhan555.retrofit.Retrofit2;

public class RetrofitConnect {
    //http://192.168.1.14/Nhahang/getdata.php
    private static final String baseurl ="http://192.168.1.14/Nhahang/";
    public static DataAPI onConnect()
    {
        return RetrofitInit.getRetrofit(baseurl).create(DataAPI.class);
    }
}
