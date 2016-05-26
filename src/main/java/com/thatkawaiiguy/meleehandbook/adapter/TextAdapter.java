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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;
import com.thatkawaiiguy.meleehandbook.R;

public class TextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final String[] mDataSet;
    private final int NATIVE_AD = 0;
    private final int TEXT = 1;

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
    public static class NativeViewHolder extends RecyclerView.ViewHolder {
        private final NativeExpressAdView mNativeExpressAdView;
        private final View view;

        public NativeViewHolder(View v) {
            super(v);
            view = v;
            mNativeExpressAdView = (NativeExpressAdView) v.findViewById(R.id.adView);
        }

        public NativeExpressAdView getNativeExpressAdView() {
            return mNativeExpressAdView;
        }

        public View getView() {
            return view;
        }
    }

    public TextAdapter(String[] mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if(viewType == NATIVE_AD) {
            return new NativeViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.native_ad_layout, viewGroup, false));
        } else {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.custom_text_row, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == NATIVE_AD) {
            AdRequest request = new AdRequest.Builder()
                    .setGender(AdRequest.GENDER_MALE)
                    .addTestDevice("BEDFB6C10C02524D5062207CE99366FC")
                    .build();
            ((NativeViewHolder)viewHolder).getNativeExpressAdView().loadAd(request);
        } else
            ((ViewHolder)viewHolder).getTextView().setText(mDataSet[position + calculateCorrectPos(position)]);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 2)
            return NATIVE_AD;
        else if(position == 16)
            return NATIVE_AD;
        else if(position == 30)
            return NATIVE_AD;
        else
            return TEXT;
    }

    private int calculateCorrectPos(int position){
        if(getItemViewType(position) == TEXT){
            if(position > 2)
                return -1;
            else
                return -position / 7;
        }

        return 0;
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}

