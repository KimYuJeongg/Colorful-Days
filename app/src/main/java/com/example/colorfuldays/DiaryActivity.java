package com.example.colorfuldays;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class DiaryActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
    }
    public void date(View v)
    {
        TextView textView = (TextView) findViewById(R.id.date);
        SimpleDateFormat date = new SimpleDateFormat("YYYY.MM.dd");
        Date time = new Date();

        String time1 = date.format(time);
        textView.setText(time1);
    }
}
