package com.example.duongtainhan555.retrofit.Retrofit2;

public class RetrofitConnect {
    //http://192.168.64.2/NhaHang/
    private static final String baseurl ="http://192.168.64.2/NhaHang/";
    public static DataAPI onConnect()
    {
        return RetrofitInit.getRetrofit(baseurl).create(DataAPI.class);
    }
}
