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

package com.thatkawaiiguy.meleehandbook.activity;

import android.os.Bundle;

import com.thatkawaiiguy.meleehandbook.R;

public class CharacterActivity extends GifInfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (optionPicked) {
            case "Bowser":
                infoImage.setImageResource(R.drawable.bowser);
                break;
            case "Donkey Kong":
                infoImage.setImageResource(R.drawable.dong);
                break;
            case "Dr. Mario":
                infoImage.setImageResource(R.drawable.drmario);
                break;
            case "Kirby":
                infoImage.setImageResource(R.drawable.kirby);
                break;
            case "Link":
                infoImage.setImageResource(R.drawable.link);
                break;
            case "Luigi":
                infoImage.setImageResource(R.drawable.luigi);
                break;
            case "Mario":
                infoImage.setImageResource(R.drawable.mario);
                break;
            case "Mewtwo":
                infoImage.setImageResource(R.drawable.mewtwo);
                break;
            case "Mr. Game & Watch":
                infoImage.setImageResource(R.drawable.mrgandw);
                break;
            case "Ness":
                infoImage.setImageResource(R.drawable.ness);
                break;
            case "Pichu":
                infoImage.setImageResource(R.drawable.pichu);
                break;
            case "Princess Zelda":
                infoImage.setImageResource(R.drawable.zelda);
                break;
            case "Roy":
                infoImage.setImageResource(R.drawable.roy);
                break;
            case "Young Link":
                infoImage.setImageResource(R.drawable.ylink);
                break;
        }
    }
}