package com.ahmadmuzaki.gatrik.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.ahmadmuzaki.gatrik.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TambahDataActivity extends AppCompatActivity {
    private EditText date;
    private EditText time;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        date = findViewById(R.id.edt_date);
        time = findViewById(R.id.edt_time);

        //India Punya
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(TambahDataActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(year + "-" + month + "-" + day);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int jam = calendar.get(Calendar.HOUR);
                int menit = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(TambahDataActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        time.setText(i+":"+i1);
                    }
                },jam, menit, false);
                timePickerDialog.show();
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tambah Data Penumpang");
        }
    }
}