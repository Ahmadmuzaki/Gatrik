package com.ahmadmuzaki.gatrik.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ahmadmuzaki.gatrik.Model.DataModel;
import com.ahmadmuzaki.gatrik.R;

public class PindahActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_MODEL = "extra_data_model";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah);

        TextView tvObjek = findViewById(R.id.tv_pindah);
        DataModel dataModel = getIntent().getParcelableExtra(EXTRA_DATA_MODEL);
        String text = "Nama : " + dataModel.getNama() + "\nAlamat : " + dataModel.getAlamat() +
                "\nNomor HP : " + dataModel.getNo_hp() + "\nTrip : " + dataModel.getTrip() +
                "\nTanggal Berangkat : " + dataModel.getTgl_brangkat() + "\nJam Berangkat : " +
                dataModel.getJam_brangkat() + "Jumlah Book" + dataModel.getJml_book();
        tvObjek.setText(text);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(dataModel.getNama());
        }
    }
}