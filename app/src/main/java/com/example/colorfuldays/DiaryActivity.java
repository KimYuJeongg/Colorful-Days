package com.example.colorfuldays;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

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
        textView.setText(Calendar.getInstance().get(Calendar.YEAR) +
                "." + (Calendar.getInstance().get(Calendar.MONTH) + 1) +
                "." + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    }
}
