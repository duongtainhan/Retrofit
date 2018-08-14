package com.example.duongtainhan555.retrofit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.duongtainhan555.retrofit.Model.Monan;
import com.example.duongtainhan555.retrofit.R;
import com.example.duongtainhan555.retrofit.Retrofit2.DataAPI;
import com.example.duongtainhan555.retrofit.Retrofit2.RetrofitConnect;
import com.example.duongtainhan555.retrofit.Retrofit2.XuLyBatDongBo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements XuLyBatDongBo {

    ArrayList<Monan> monans = new ArrayList<>();
    XuLyBatDongBo xuLyBatDongBo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReciveData();
        xuLyBatDongBo = this;
    }

    private void ReciveData() {
        DataAPI dataAPI = RetrofitConnect.onConnect();
        Call<List<Monan>> callback = dataAPI.onGetdata();
        callback.enqueue(new Callback<List<Monan>>() {
            @Override
            public void onResponse(Call<List<Monan>> call, Response<List<Monan>> response) {
                ArrayList<Monan> mangmonan = (ArrayList<Monan>) response.body();
                for(int i=0;i<mangmonan.size();i++)
                {
                    Log.d("CCC",mangmonan.get(i).getTenmonan());
                }
                xuLyBatDongBo.NhanData(mangmonan);
            }

            @Override
            public void onFailure(Call<List<Monan>> call, Throwable t) {

            }
        });
    }

    @Override
    public void NhanData(ArrayList<Monan> monans) {
        Log.d("BBB",monans.size()+"");
    }
}
