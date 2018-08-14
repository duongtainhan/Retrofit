package com.example.duongtainhan555.retrofit.Retrofit2;

import com.example.duongtainhan555.retrofit.Model.Monan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataAPI {
    //http://192.168.1.14/Nhahang/getdata.php

    @GET("getdata.php")
    Call<List<Monan>> onGetdata();

}
