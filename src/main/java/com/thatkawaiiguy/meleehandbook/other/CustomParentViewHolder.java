package com.thatkawaiiguy.meleehandbook.other;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.thatkawaiiguy.meleehandbook.R;

public class CustomParentViewHolder extends ParentViewHolder {

    public final TextView dataText;

    public CustomParentViewHolder(View itemView) {
        super(itemView);

        dataText = (TextView) itemView.findViewById(R.id.recycler_item_text_parent);
    }
}