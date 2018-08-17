package com.example.duongtainhan555.retrofit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duongtainhan555.retrofit.Model.Monan;
import com.example.duongtainhan555.retrofit.R;
import com.example.duongtainhan555.retrofit.Retrofit2.RequestInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.duongtainhan555.retrofit.Retrofit2.RetrofitInit.retrofit;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    MonanAdapter monanAdapter;
    private ArrayList<Monan> monans;
    private static final String base_url="https://service-php-by-dn.000webhostapp.com/";
    private CompositeDisposable compositeDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        compositeDisposable = new CompositeDisposable();
        loadJSON(base_url);
    }

    private void loadJSON(String url)
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        RequestInterface requestInterface = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface.class);
        Disposable disposable = requestInterface.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError, this::handleSuccess);
        compositeDisposable.add(disposable);
    }
    private void handleResponse(List<Monan> arrayMonans) {
        monans = new ArrayList<>(arrayMonans);
        monanAdapter = new MonanAdapter(MainActivity.this,R.layout.layout_monan,monans);
        listView.setAdapter(monanAdapter);

    }
    private void handleError(Throwable error) {

        Toast.makeText(this, "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    private void handleSuccess() {
        Toast.makeText(this, "Get data success! ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
