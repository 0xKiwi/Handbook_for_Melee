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
import com.thatkawaiiguy.meleehandbook.activity.HealthyActivity;

import java.util.List;

public class HealthyExpandableAdapter extends ExpandableRecyclerAdapter<CustomParentViewHolder, CustomChildViewHolder> {

    private LayoutInflater mInflater;

    Context context;

    boolean canStart = true;

    public HealthyExpandableAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        this.context = context;
        mInflater = LayoutInflater.from(context);
        removeAnimation();
    }

    @Override
    public CustomParentViewHolder onCreateParentViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.recycler_item_layout_parent, parent, false);
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
                    Intent mIntent = new Intent(context, HealthyActivity.class);
                    mIntent.putExtra("option", childViewHolder.dataText.getText());
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
