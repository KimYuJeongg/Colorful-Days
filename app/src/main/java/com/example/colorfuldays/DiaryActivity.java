package com.example.colorfuldays;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaryActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        TextView textView = (TextView) findViewById(R.id.date);
        textView.setText("2020.8.29");
    }

    static String getDate(View v)
    {
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd");
        Date time = new Date();

        String time1 = date.format(time);

        return time1;
    }
}
