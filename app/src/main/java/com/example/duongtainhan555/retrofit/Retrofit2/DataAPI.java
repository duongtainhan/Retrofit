package com.example.duongtainhan555.retrofit.Retrofit2;

import com.example.duongtainhan555.retrofit.Model.Monan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataAPI {
    //http://192.168.64.2/NhaHang/GetData.php

    @GET("GetData.php")
    Call<List<Monan>> onGetdata();

}
