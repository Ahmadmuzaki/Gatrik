package com.ahmadmuzaki.gatrik.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ahmadmuzaki.gatrik.API.APICreateData;
import com.ahmadmuzaki.gatrik.API.APIRequestData;
import com.ahmadmuzaki.gatrik.API.RetroServer;
import com.ahmadmuzaki.gatrik.Model.ResponseModel;
import com.ahmadmuzaki.gatrik.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {

    private EditText edtNama, edtAlamat, edtNoHp, edtTrip, edtTglBerangkat, edtJamBerangkat, edtJumlahBook;
    private Button btnSimpanData;
    String nama, alamat, hp, trip, tglBerangkat, jamBerangkat, jmlBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edtNama = findViewById(R.id.edt_tambah_nama);
        edtAlamat = findViewById(R.id.edt_tambah_alamat);
        edtNoHp = findViewById(R.id.edt_tambah_hp);
        edtTrip = findViewById(R.id.edt_tambah_trip);
        edtTglBerangkat = findViewById(R.id.edt_tambah_tgl_berangkat);
        edtJamBerangkat = findViewById(R.id.edt_tambah_jam_berangkat);
        edtJumlahBook = findViewById(R.id.edt_tambah_book);
        btnSimpanData = findViewById(R.id.btn_simpan);

        btnSimpanData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtNama.getText().toString();
                alamat = edtAlamat.getText().toString();
                hp = edtNoHp.getText().toString();
                trip = edtTrip.getText().toString();
                tglBerangkat = edtTglBerangkat.getText().toString();
                jamBerangkat = edtJamBerangkat.getText().toString();
                jmlBook = edtJumlahBook.getText().toString();

                if (nama.trim().equals("")) {
                    edtNama.setError("Nama Tidak Boleh Kosong");
                } else if (alamat.trim().equals("")) {
                    edtAlamat.setError("Alamat Tidak Boleh Kosong");
                } else if (hp.trim().equals("")) {
                    edtNoHp.setError("Ho Handphone Tidak Boleh Kosong");
                } else if (trip.trim().equals("")) {
                    edtTrip.setError("Trip Tidak Boleh Kosong");
                } else if (tglBerangkat.trim().equals("")) {
                    edtTglBerangkat.setError("Tanggal Berangkat Tidak Boleh Kosong");
                } else if (jamBerangkat.trim().equals("")) {
                    edtJamBerangkat.setError("Jam Berangkat Tidak Boleh Kosong");
                } else if (jmlBook.trim().equals("")) {
                    edtJumlahBook.setError("Jumlah Book Tidak Boleh Kosong");
                } else {
                    tambahData();
                }

            }
        });
    }

    public void tambahData() {
        APICreateData acData = RetroServer.konekRetrofit().create(APICreateData.class);
        Call<ResponseModel> simpanData = acData.simpan(nama, alamat, hp, trip, tglBerangkat, jamBerangkat, jmlBook);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this, "Kode " + kode + "Pesan" + pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal Menghubungi Server" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}