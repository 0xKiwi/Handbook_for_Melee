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

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;

public class TextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView menuText;

        public ViewHolder(View v) {
            super(v);
            menuText = (TextView) v.findViewById(R.id.menuTitle);
        }

        public TextView getTextView() {
            return menuText;
        }
    }

    public TextAdapter(String[] mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_text_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        ((ViewHolder) viewHolder).getTextView().setText(mDataSet[position]);
    }

    public static boolean isPosAd(int pos, int start, int repeat) {
        if(pos == 0)
            return false;
        return pos == start || (pos % (repeat + start + (pos / repeat)) == 0);
    }

    public static int getProperPos(int pos, int start, int repeat) {
        int add = pos;
        if(pos > start) {
            add--;
            if(pos > repeat + start)
                add -= pos / (repeat + start);
        }
        return add;
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}

