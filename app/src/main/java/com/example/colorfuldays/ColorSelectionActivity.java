package com.example.colorfuldays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colorfuldays.veiwlist.Adapter;
import com.example.colorfuldays.veiwlist.VerticalSpaceItemDecoration;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ColorSelectionActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_selection);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                DatePicker datePicker = (DatePicker) findViewById(R.id.dataPicker);
                String date = String.format("%d.%d.%d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth());
                Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);

            }
        });

        initRecycleViewItem();
    }

    private void initRecycleViewItem()
    {
        RecyclerView listview = findViewById(R.id.main_listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);

        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("Anger");
        itemList.add("Confusion");
        itemList.add("Exciting");
        itemList.add("Normal");
        itemList.add("Joy");
        itemList.add("Sad");
        itemList.add("Tired");
        itemList.add("Melancholy");

        Adapter adapter = new Adapter(this, itemList, ColorSelectionActivity.this);
        listview.setAdapter(adapter);
        listview.addItemDecoration(new VerticalSpaceItemDecoration(35));
    }

    
}
