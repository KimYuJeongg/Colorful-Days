package com.example.colorfuldays.veiwlist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    private int last_click = -1;

    public Adapter(Context context, ArrayList<String> itemList)
    {
        this.context = context;
        this.itemList = itemList;
    }

    private Map<String, String> ColorMap()
    {
        Map<String, String> colorMap = new HashMap<>();

        colorMap.put("Anger", "#ff6969");
        colorMap.put("Confusion", "#ffc085");
        colorMap.put("Exciting", "#fff785");
        colorMap.put("Normal", "#bbe09d");
        colorMap.put("Joy", "#ffbcb8");
        colorMap.put("Sad", "#9eb1ff");
        colorMap.put("Tired", "#7a7cff");
        colorMap.put("Melancholy", "#b090f0");

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
    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public interface OnItemClickListener
    {
        void onItemClick(View v, int pos);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textview;
        ImageButton button;

        public ViewHolder(View itemView)
        {
            super(itemView);

            textview = itemView.findViewById(R.id.item_text);
            button = itemView.findViewById(R.id.item_button);

            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = getBindingAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION)
                    {
                        mListener.onItemClick(v, pos);
                    }
                }
            });
        }
    }
}