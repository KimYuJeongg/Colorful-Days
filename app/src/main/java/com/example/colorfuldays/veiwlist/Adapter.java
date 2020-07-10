package com.example.colorfuldays.veiwlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.colorfuldays.ColorSelectionActivity;
import com.example.colorfuldays.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private ArrayList<String> itemList;
    private Context context;
    private View.OnClickListener onClickItem;
    private Activity colorSelectionActivity;

    public Adapter(Context context, ArrayList<String> itemList, View.OnClickListener onClickItem,
                   ColorSelectionActivity colorSelectionActivity)
    {
        this.context = context;
        this.itemList = itemList;
        this.onClickItem = onClickItem;
        this.colorSelectionActivity = colorSelectionActivity;
    }

    private Map<String, String> ColorMap()
    {
        Map<String, String> colorMap = new HashMap<>();

        colorMap.put("Anger", "#ff4343");
        colorMap.put("Confusion", "#ff8e43");
        colorMap.put("Exciting", "#ffff4f");
        colorMap.put("Normal", "#85e070");
        colorMap.put("Joy", "#ffa8ab");
        colorMap.put("Sad", "#80a9e0");
        colorMap.put("Tired", "#6662bf");
        colorMap.put("Melancholy", "#bd72db");

        return colorMap;
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
        holder.button.setOnClickListener(onClickItem);

        GradientDrawable bgShape = (GradientDrawable) holder.button.getBackground();

        if (ColorMap().containsKey(itemList.get(position)))
            bgShape.setColor(Color.parseColor(ColorMap().get(itemList.get(position))));
    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textview;
        public Button button;

        public ViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION)
                    {
                        Intent intent = new Intent();
                        intent.putExtra("name", ColorMap().get(itemList.get((pos))));
                        colorSelectionActivity.setResult(Activity.RESULT_OK, intent);
                        notifyItemChanged(pos);
                        colorSelectionActivity.finish();
                    }
                }
            });

            textview = itemView.findViewById(R.id.item_text);
            button = itemView.findViewById(R.id.item_button);
        }
    }
}