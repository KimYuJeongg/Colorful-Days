package com.example.colorfuldays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colorfuldays.veiwlist.Adapter;
import com.example.colorfuldays.veiwlist.VerticalSpaceItemDecoration;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ColorSelectionActivity extends Activity
{
    private RecyclerView listview;
    private Adapter adapter;

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
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//            Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
//            startActivity(intent);
            }
        });

        init();
    }

    private void init()
    {
        listview = findViewById(R.id.main_listview);
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

        adapter = new Adapter(this, itemList, ColorSelectionActivity.this);
        listview.setAdapter(adapter);

        listview.addItemDecoration(new VerticalSpaceItemDecoration(70));
    }
}
