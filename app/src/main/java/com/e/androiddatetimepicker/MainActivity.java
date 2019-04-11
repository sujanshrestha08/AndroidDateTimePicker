package com.e.androiddatetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText tvDOB;
    private EditText tvTime;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDOB = findViewById(R.id.tvDOB);
        tvTime = findViewById(R.id.tvTime);

        tvDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

    }

    private void loadDatePicker() {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog =new DatePickerDialog(
                this, this, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
        datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis() + 172800000);
                datePickerDialog.show();

    }

    private void loadTime() {
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);


        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvTime.setText("Time is" + hourOfDay + ";" + minute);
            }
        }, hour, minute, false);
            timePickerDialog.show();
    }


    @Override
    public void onDateSet (DatePicker view, int year, int month, int dayOfMonth) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        Calendar c = Calendar.getInstance();
        c.set(year, month, dayOfMonth);

        String date = format.format(c.getTime());
        tvDOB.setText(date);


    }
}
