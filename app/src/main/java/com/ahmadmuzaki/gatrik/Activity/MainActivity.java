package com.ahmadmuzaki.gatrik.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ahmadmuzaki.gatrik.API.APIRequestData;
import com.ahmadmuzaki.gatrik.API.RetroServer;
import com.ahmadmuzaki.gatrik.Adapter.AdapterData;
import com.ahmadmuzaki.gatrik.Model.DataModel;
import com.ahmadmuzaki.gatrik.Model.ResponseModel;
import com.ahmadmuzaki.gatrik.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    //List data model simpan ke arraylist dulu
    private List<DataModel> listPenumpang = new ArrayList<>();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = findViewById(R.id.srl_data);
        progressBar = findViewById(R.id.pb_data);
        rvData = findViewById(R.id.rview_data);
        lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
//        ambilData(); digantikan dengan ambildata yang ada di methon onResume
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                ambilData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ambilData();
    }

    //Membuat method tampil Data
    public void ambilData(){

        progressBar.setVisibility(View.VISIBLE);
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> tampilData = ardData.ardAmbilData();

        tampilData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                Toast.makeText(MainActivity.this, "Kode : "+kode+"|Pesan : "+pesan, Toast.LENGTH_SHORT).show();
                listPenumpang = response.body().getData();
                adData = new AdapterData(MainActivity.this, listPenumpang);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungkan Server"+t.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}