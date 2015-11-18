package com.thatkawaiiguy.meleehandbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.thatkawaiiguy.meleehandbook.other.CustomChildObject;
import com.thatkawaiiguy.meleehandbook.other.CustomChildViewHolder;
import com.thatkawaiiguy.meleehandbook.other.CustomParentObject;
import com.thatkawaiiguy.meleehandbook.other.CustomParentViewHolder;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.activity.FrameDataActivity;

import java.util.List;

public class FrameDataAdapter extends ExpandableRecyclerAdapter<CustomParentViewHolder, CustomChildViewHolder> {

    private final LayoutInflater mInflater;

    private final String characterPicked;

    private final Context context;

    private boolean canStart = true;

    public FrameDataAdapter(Context context, List<ParentObject> parentItemList, String character) {
        super(context, parentItemList);
        this.context = context;
        characterPicked = character;
        mInflater = LayoutInflater.from(context);
        removeAnimation();
    }

    @Override
    public CustomParentViewHolder onCreateParentViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.recycler_item_layout_card_parent, parent, false);
        return new CustomParentViewHolder(view);
    }

    @Override
    public CustomChildViewHolder onCreateChildViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.recycler_item_layout_child, parent, false);
        return new CustomChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(CustomParentViewHolder parentViewHolder, int position, Object parentObject) {
        CustomParentObject customParentObject = (CustomParentObject) parentObject;
        parentViewHolder.dataText.setText(customParentObject.getParentText());
    }

    @Override
    public void onBindChildViewHolder(final CustomChildViewHolder childViewHolder, int position, Object childObject) {
        CustomChildObject customChildObject = (CustomChildObject) childObject;
        childViewHolder.dataText.setText(customChildObject.getChildText());
        childViewHolder.dataText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(canStart) {
                    Intent mIntent = new Intent(context, FrameDataActivity.class);
                    mIntent.putExtra("option", characterPicked);
                    mIntent.putExtra("frame", childViewHolder.dataText.getText());
                    context.startActivity(mIntent);
                    canStart = false;
                }
            }
        });
    }

    public void setCanStart(){
        canStart = true;
    }
}
