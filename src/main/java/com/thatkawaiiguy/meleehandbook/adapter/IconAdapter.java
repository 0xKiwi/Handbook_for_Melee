package com.thatkawaiiguy.meleehandbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    protected String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView menuText;
        private ImageView menuImage;

        public ViewHolder(View v) {
            super(v);
            menuText = (TextView) v.findViewById(R.id.menuTitle);
            menuImage = (ImageView) v.findViewById(R.id.menuImage);
        }

        public TextView getTextView() {
            return menuText;
        }

        public ImageView getImageView() {
            return menuImage;
        }
    }

    public IconAdapter(String[] mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_image_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(mDataSet[position]);

        ArrayHelper.iconListSetter(mDataSet[position], viewHolder.getImageView());
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
