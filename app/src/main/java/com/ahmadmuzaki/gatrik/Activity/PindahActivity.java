package com.ahmadmuzaki.gatrik.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.telecom.Call;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.ahmadmuzaki.gatrik.API.APICreateData;
import com.ahmadmuzaki.gatrik.API.RetroServer;
import com.ahmadmuzaki.gatrik.Model.DataModel;
import com.ahmadmuzaki.gatrik.R;

public class PindahActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_MODEL = "extra_data_model";
    ProgressDialog progressDialog;
    APICreateData apiCreateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah);

        TextView tvObjek = findViewById(R.id.tv_pindah);
        DataModel dataModel = getIntent().getParcelableExtra(EXTRA_DATA_MODEL);
        String text = "Nama : " + dataModel.getNama() + "\nAlamat : " + dataModel.getAlamat() +
                "\nNomor HP : " + dataModel.getNo_hp() + "\nTrip : " + dataModel.getTrip() +
                "\nTanggal Berangkat : " + dataModel.getTgl_brangkat() + "\nJam Berangkat : " +
                dataModel.getJam_brangkat() + "\nJumlah Book" + dataModel.getJml_book();
        tvObjek.setText(text);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(dataModel.getNama());
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait . . .");
    }












    //Menampikkan menu_editor
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_editor, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_save:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}