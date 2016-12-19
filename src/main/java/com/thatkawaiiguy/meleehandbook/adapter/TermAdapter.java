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

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.XMLParser;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.ViewHolder> {

    private final String[] mTitles;
    private final String[] mContent;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView menuText;
        private final TextView subText;

        public ViewHolder(View v) {
            super(v);
            menuText = (TextView) v.findViewById(R.id.termListTitle);
            subText = (TextView) v.findViewById(R.id.termListSubtitle);
        }

        public TextView getTextView() {
            return menuText;
        }

        public TextView getTermTextView() {
            return subText;
        }
    }

    public TermAdapter(Resources res) {
        mTitles = XMLParser.addAllTitlesToArray(res, R.xml.terms);
        mContent = XMLParser.addAllContentToArray(res, R.xml.terms);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.term_layout, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(mTitles[position]);
        viewHolder.getTermTextView().setText(mContent[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles.length;
    }
}
