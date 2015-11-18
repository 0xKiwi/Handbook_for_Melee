package com.thatkawaiiguy.meleehandbook.other;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.thatkawaiiguy.meleehandbook.R;

public class CustomChildViewHolder extends ChildViewHolder {

    public final TextView dataText;

    public CustomChildViewHolder(View itemView) {
        super(itemView);

        dataText = (TextView) itemView.findViewById(R.id.recycler_item_text_child);
    }
}