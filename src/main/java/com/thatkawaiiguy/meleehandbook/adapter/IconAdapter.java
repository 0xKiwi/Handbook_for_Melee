/*
    This file is part of Melee Handbook.

    Melee Handbook is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Melee Handbook is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Melee Handbook.  If not, see <http://www.gnu.org/licenses/>
 */

package com.thatkawaiiguy.meleehandbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private final String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView menuText;
        private final ImageView menuImage;

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

        switch(mDataSet[position]) {
            case "Bowser":
                viewHolder.getImageView().setImageResource(R.drawable.marioicon);
                break;
            case "Captain Falcon":
                viewHolder.getImageView().setImageResource(R.drawable.fzeroicon);
                break;
            case "Donkey Kong":
                viewHolder.getImageView().setImageResource(R.drawable.dkicon);
                break;
            case "Dr. Mario":
                viewHolder.getImageView().setImageResource(R.drawable.marioicon);
                break;
            case "Falco":
                viewHolder.getImageView().setImageResource(R.drawable.falcoicon);
                break;
            case "Fox":
                viewHolder.getImageView().setImageResource(R.drawable.foxicon);
                break;
            case "Ganondorf":
                viewHolder.getImageView().setImageResource(R.drawable.zeldaicon);
                break;
            case "Ice Climbers":
                viewHolder.getImageView().setImageResource(R.drawable.icicon);
                break;
            case "Jigglypuff":
                viewHolder.getImageView().setImageResource(R.drawable.jiggsicon);
                break;
            case "Kirby":
                viewHolder.getImageView().setImageResource(R.drawable.kirbyicon);
                break;
            case "Link":
                viewHolder.getImageView().setImageResource(R.drawable.linkicon);
                break;
            case "Mario":
                viewHolder.getImageView().setImageResource(R.drawable.marioicon);
                break;
            case "Luigi":
                viewHolder.getImageView().setImageResource(R.drawable.luigiicon);
                break;
            case "Marth":
                viewHolder.getImageView().setImageResource(R.drawable.marthicon);
                break;
            case "Mewtwo":
                viewHolder.getImageView().setImageResource(R.drawable.pokemonicon);
                break;
            case "Mr. Game & Watch":
                viewHolder.getImageView().setImageResource(R.drawable.gandwicon);
                break;
            case "Ness":
                viewHolder.getImageView().setImageResource(R.drawable.ebicon);
                break;
            case "Pichu":
                viewHolder.getImageView().setImageResource(R.drawable.pikaicon);
                break;
            case "Pikachu":
                viewHolder.getImageView().setImageResource(R.drawable.pikaicon);
                break;
            case "Princess Peach":
                viewHolder.getImageView().setImageResource(R.drawable.peachicon);
                break;
            case "Princess Zelda":
                viewHolder.getImageView().setImageResource(R.drawable.zeldaicon);
                break;
            case "Roy":
                viewHolder.getImageView().setImageResource(R.drawable.royicon);
                break;
            case "Samus Aran":
                viewHolder.getImageView().setImageResource(R.drawable.metroidicon);
                break;
            case "Sheik":
                viewHolder.getImageView().setImageResource(R.drawable.zeldaicon);
                break;
            case "Yoshi":
                viewHolder.getImageView().setImageResource(R.drawable.yoshiicon);
                break;
            case "Young Link":
                viewHolder.getImageView().setImageResource(R.drawable.linkicon);
                break;

            //STAGEs
            case "Battlefield":
                viewHolder.getImageView().setImageResource(R.drawable.smashicon);
                break;
            case "Dream Land":
                viewHolder.getImageView().setImageResource(R.drawable.kirbyicon);
                break;
            case "Final Destination":
                viewHolder.getImageView().setImageResource(R.drawable.smashicon);
                break;
            case "Fountain of Dreams":
                viewHolder.getImageView().setImageResource(R.drawable.kirbyicon);
                break;
            case "Kongo Jungle (SSB)":
                viewHolder.getImageView().setImageResource(R.drawable.dkicon);
                break;
            case "Pokemon Stadium":
                viewHolder.getImageView().setImageResource(R.drawable.pokemonicon);
                break;
            case "Yoshi's Story":
                viewHolder.getImageView().setImageResource(R.drawable.yoshiicon);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
