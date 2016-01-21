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

public class UniqueTechActivity extends GifInfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (optionPicked) {
            case "Boomerang superjump":
                infoImage.setImageResource(R.drawable.boomjump);
                break;
            case "Desynching":
                infoImage.setImageResource(R.drawable.desync);
                break;
            case "Extended grapple":
                infoImage.setImageResource(R.drawable.egrapple);
                break;
            case "Edge canceled eggs":
                infoImage.setImageResource(R.drawable.ece);
                break;
            case "Float cancel":
                infoImage.setImageResource(R.drawable.floatcan);
                break;
            case "DJ knockback armor":
                infoImage.setImageResource(R.drawable.djka);
                break;
            case "Ledgehop double laser":
                infoImage.setImageResource(R.drawable.lhdl);
                break;
            case "Multishine":
                infoImage.setImageResource(R.drawable.multishine);
                break;
            case "Parry":
                infoImage.setImageResource(R.drawable.parry);
                break;
            case "Pillaring":
                infoImage.setImageResource(R.drawable.pillar);
                break;
            case "Princess/Swordsman spiking":
                infoImage.setImageResource(R.drawable.psspiking);
                break;
            case "Reverse angle boomerang":
                infoImage.setImageResource(R.drawable.revangle);
                break;
            case "RI grapple cancel":
                infoImage.setImageResource(R.drawable.rigcancel);
                break;
            case "Short hop laser":
                infoImage.setImageResource(R.drawable.shl);
                break;
            case "Side-B shorten":
                infoImage.setImageResource(R.drawable.sbshorten);
                break;
            case "Shine mine":
                infoImage.setImageResource(R.drawable.shinemine);
                break;
            case "Up-B turnaround":
                infoImage.setImageResource(R.drawable.upbturn);
                break;
            case "Up-B cancel":
                infoImage.setImageResource(R.drawable.upbcancel);
                break;
            case "Waveshine":
                infoImage.setImageResource(R.drawable.waveshine);
                break;
            case "Wobbling":
                infoImage.setImageResource(R.drawable.wobbling);
                break;
            case "Yo-yo glitch":
                infoImage.setImageResource(R.drawable.yoyo);
                break;
        }
    }
}
