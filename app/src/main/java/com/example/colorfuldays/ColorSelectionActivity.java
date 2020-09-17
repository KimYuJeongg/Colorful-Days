package com.example.colorfuldays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.DatePicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colorfuldays.veiwlist.Adapter;
import com.example.colorfuldays.veiwlist.VerticalSpaceItemDecoration;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ColorSelectionActivity extends Activity
{
    private int last_click_position = -1;

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
        RecyclerView recyclerView = findViewById(R.id.main_listview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<String> itemList = new ArrayList<>();
        itemList.add("Anger");
        itemList.add("Confusion");
        itemList.add("Exciting");
        itemList.add("Normal");
        itemList.add("Joy");
        itemList.add("Sad");
        itemList.add("Tired");
        itemList.add("Melancholy");

        final Adapter adapter = new Adapter(this, itemList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(35));

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(final View v, final int pos)
            {
                final Intent intent = new Intent();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        String color = ColorMap().get(itemList.get(pos));
                        intent.putExtra("name", color);
                        setResult(Activity.RESULT_OK, intent);
                        if (!v.isSelected())
                        {
                            last_click_position = pos;
                            v.setSelected(true);
                        }
                        else if (v.isSelected())
                        {
                            finish();
                        }
                    }
                }, 500);
            }
        });
    }

    private Map<String, String> ColorMap()
    {
        Map<String, String> colorMap = new HashMap<>();

        colorMap.put("Anger", "#ff6969");
        colorMap.put("Confusion", "#ffc085");
        colorMap.put("Exciting", "#fff785");
        colorMap.put("Normal", "#b9faa0");
        colorMap.put("Joy", "#ffbcb8");
        colorMap.put("Sad", "#9eb1ff");
        colorMap.put("Tired", "#9578ff");
        colorMap.put("Melancholy", "#c587ff");

        return colorMap;
    }
}
