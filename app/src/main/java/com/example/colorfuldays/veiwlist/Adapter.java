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

        GradientDrawable bgShape = (GradientDrawable) holder.textview.getBackground();

        if(position == 0)
            bgShape.setColor(Color.parseColor("#ff2929"));
        else if(position == 1)
            bgShape.setColor(Color.parseColor("#ff8229"));   //Joy
        else if(position == 2)
            bgShape.setColor(Color.parseColor("#85e070"));    //Normal
        else if(position == 3)
            bgShape.setColor(Color.parseColor("#ff7377"));    //Happy
        else if(position == 4)
            bgShape.setColor(Color.parseColor("#80a9e0"));    //Sad
        else if(position == 5)
            bgShape.setColor(Color.parseColor("#6662bf"));    //Tired
        else if(position == 6)
            bgShape.setColor(Color.parseColor("#bd72db"));    //melancholy
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
