package com.example.colorfuldays.veiwlist;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration
{
    private final int verticalSpaceHeight;

    public VerticalSpaceItemDecoration(int verticalSpaceHeight)
    {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount())
        {
            outRect.left = verticalSpaceHeight;
            outRect.right = verticalSpaceHeight;
        }
    }
}
