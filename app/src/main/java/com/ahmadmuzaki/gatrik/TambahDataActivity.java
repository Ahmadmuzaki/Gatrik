package com.ahmadmuzaki.gatrik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TambahDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Tambah Data Penumpang");
        }
    }
}