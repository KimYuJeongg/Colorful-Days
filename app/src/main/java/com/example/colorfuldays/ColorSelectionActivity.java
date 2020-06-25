package com.example.colorfuldays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colorfuldays.veiwlist.Adapter;

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
        itemList.add("Anger");
        itemList.add("Joy");
        itemList.add("Normal");
        itemList.add("Happy");
        itemList.add("Sad");
        itemList.add("Tired");
        itemList.add("Melancholy");  //7

//        HashMap<String, String> itmeList = new HashMap<>();
//        itmeList.put("Anger", "#ff2929");
//        itmeList.put("Joy", "#ff8229");
//        itmeList.put("Normal", "#85e070");
//        itmeList.put("Happy", "#ff7377");
//        itmeList.put("Sad", "#847cf7");
//        itmeList.put("Tired", "#847cf7");
//        itmeList.put("melancholy", "#7cb1f7");

        adapter = new Adapter(this, itemList, onClickItem);
        listview.setAdapter(adapter);

//        ViewListVacancy decoration = new ViewListVacancy();
//        listview.addItemDecoration(decoration);
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
