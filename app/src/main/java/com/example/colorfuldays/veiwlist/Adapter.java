package com.example.colorfuldays.veiwlist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colorfuldays.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private ArrayList<String> itemList;
    private Context context;
    private View.OnClickListener onClickItem;

    public Adapter(Context context, ArrayList<String> itemList, View.OnClickListener onClickItem)
    {
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.color_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        String item = itemList.get(position);

        holder.textview.setText(item);
        holder.textview.setTag(item);
        holder.textview.setOnClickListener(onClickItem);

        Map<String, String> colorMap = new HashMap<String, String>();
        colorMap.put("Anger", "#ff4343");
        colorMap.put("Confusion", "#ff8e43");
        colorMap.put("Exciting", "#ffff4f");
        colorMap.put("Normal", "#85e070");
        colorMap.put("Joy", "#ffa8ab");
        colorMap.put("Sad", "#80a9e0");
        colorMap.put("Tired", "#6662bf");
        colorMap.put("Melancholy", "#bd72db");

        GradientDrawable bgShape = (GradientDrawable) holder.textview.getBackground();

        if(colorMap.containsKey(itemList.get(position)))
            bgShape.setColor(Color.parseColor(colorMap.get(itemList.get(position))));
    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textview;

        public ViewHolder(View itemView)
        {
            super(itemView);

            textview = itemView.findViewById(R.id.item_textview);
        }
    }
}
