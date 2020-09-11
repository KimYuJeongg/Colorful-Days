package com.example.colorfuldays.veiwlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;

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
    private Activity colorSelectionActivity;
    int divide_line = 0;

    public Adapter(Context context, ArrayList<String> itemList, ColorSelectionActivity colorSelectionActivity)
    {
        this.context = context;
        this.itemList = itemList;
        this.colorSelectionActivity = colorSelectionActivity;
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.color_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        String item = itemList.get(position);

        holder.textview.setText(item);
        holder.textview.setTag(item);

        GradientDrawable bgShape = (GradientDrawable) holder.button.getBackground();

        if (ColorMap().containsKey(itemList.get(position)))
            bgShape.setColor(Color.parseColor(ColorMap().get(itemList.get(position))));

        holder.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                divide_line++;
                final Intent intent = new Intent();

                if (position != RecyclerView.NO_POSITION)
                {
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            if(divide_line == 1)
                            {
                                String color = ColorMap().get(itemList.get((position)));
                                intent.putExtra("name", color);
                                colorSelectionActivity.setResult(Activity.RESULT_OK, intent);
                                notifyItemChanged(position);
                            }
                            else if(divide_line == 2)
                            {
                                String color = ColorMap().get(itemList.get((position)));
                                intent.putExtra("name", color);
                                colorSelectionActivity.setResult(Activity.RESULT_OK, intent);
                                notifyItemChanged(position);
                                colorSelectionActivity.finish(); // Double Click Listener
                            }
                        }
                    }, 500);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textview;
        public ImageButton button;

        public ViewHolder(View itemView)
        {
            super(itemView);

            textview = itemView.findViewById(R.id.item_text);
            button = itemView.findViewById(R.id.item_button);
        }
    }
}