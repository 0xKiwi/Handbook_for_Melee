/*
    This file is part of Handbook for Melee.

    Handbook for Melee is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Handbook for Melee is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Handbook for Melee.  If not, see <http://www.gnu.org/licenses/>
 */

package com.thatkawaiiguy.meleehandbook.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.activity.FunActivity;
import com.thatkawaiiguy.meleehandbook.activity.TechTabActivity;
import com.thatkawaiiguy.meleehandbook.activity.VideoInfoActivity;
import com.thatkawaiiguy.meleehandbook.utils.XMLParser;


public class TextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] mDataSet;
    private final Context mContext;

    private int id = 0;

    private final boolean video;
    private boolean canStart = true;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView menuText;
        public final View view;

        public ViewHolder(View v) {
            super(v);
            menuText = (TextView) v.findViewById(R.id.menuTitle);
            view = v;
        }

        public TextView getTextView() {
            return menuText;
        }
    }

    public TextAdapter(Activity context, boolean doVideo, int id) {
        mDataSet = XMLParser.addAllTitlesToArray(context.getResources(), id);
        mContext = context;
        video = doVideo;
        this.id = id;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.custom_text_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final String title = mDataSet[position];
        ViewHolder viewHolder1 = ((ViewHolder) viewHolder);
        viewHolder1.getTextView().setText(mDataSet[position]);

        if(video) {
            viewHolder1.view.setOnClickListener(v -> {
                String videoID = XMLParser.getDrawableFromTitle(id, title, mContext);
                if(canStart) {
                    Intent mIntent;
                    if(videoID.equals("Wall jumping") ||
                        videoID.equals("Directional Influence") ||
                        videoID.equals("Shield dropping") ||
                        videoID.equals("Super wavedash & SDWD") ||
                        videoID.equals("Extended & homing grapple"))
                        mIntent = new Intent(mContext, TechTabActivity.class);
                    else
                        mIntent = new Intent(mContext, VideoInfoActivity.class);
                    mIntent.putExtra("option", title);
                    mIntent.putExtra("videoID", videoID);
                    mIntent.putExtra("xml", id);
                    mContext.startActivity(mIntent);
                    canStart = false;
                }
            });
        } else {
            viewHolder1.view.setOnClickListener(v -> {
                String videoID = XMLParser.getDrawableFromTitle(id, title, mContext);
                if(canStart) {
                    mContext.startActivity(new Intent(mContext, FunActivity.class)
                            .putExtra("xml", R.xml.fundamentals)
                            .putExtra("option", title)
                            .putExtra("videoID", videoID));
                    canStart = false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public void setCanStart(boolean start) {
        canStart = start;
    }
}

