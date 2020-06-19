package com.example.colorfuldays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colorfuldays.veiwlist.Adapter;
import com.example.colorfuldays.veiwlist.ViewListVacancy;

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

        init();
    }

    private void init()
    {

        listview = findViewById(R.id.main_listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);

        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("0");
        itemList.add("1");
        itemList.add("2");
        itemList.add("3");
        itemList.add("4");
        itemList.add("5");
        itemList.add("6");
        itemList.add("7");
        itemList.add("8");
        itemList.add("9");
        itemList.add("10");
        itemList.add("11");

        adapter = new Adapter(this, itemList, onClickItem);
        listview.setAdapter(adapter);

        ViewListVacancy decoration = new ViewListVacancy();
        listview.addItemDecoration(decoration);
    }


    private View.OnClickListener onClickItem = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String str = (String) v.getTag();
            Toast.makeText(ColorSelectionActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    };
}
