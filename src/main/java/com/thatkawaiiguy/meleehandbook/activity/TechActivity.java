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

public class TechActivity extends GifInfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (optionPicked) {
            case "Aerial interrupt":
                infoImage.setImageResource(R.drawable.aerialinterrupt);
                break;
            case "Chain grab":
                infoImage.setImageResource(R.drawable.cgrab);
                break;
            case "Crouch cancel":
                infoImage.setImageResource(R.drawable.crouchcancel);
                break;
            case "Dash-dance":
                infoImage.setImageResource(R.drawable.ddance);
                break;
            case "Fast falling":
                infoImage.setImageResource(R.drawable.ffall);
                break;
            case "Fox-trot":
                infoImage.setImageResource(R.drawable.ftrot);
                break;
            case "Jab reset":
                infoImage.setImageResource(R.drawable.jabreset);
                break;
            case "L-canceling":
                infoImage.setImageResource(R.drawable.lcancel);
                break;
            case "Ledge stall":
                infoImage.setImageResource(R.drawable.ledgestall);
                break;
            case "Ledge-canceling":
                infoImage.setImageResource(R.drawable.ledgecancel);
                break;
            case "Moonwalk":
                infoImage.setImageResource(R.drawable.moonwalk);
                break;
            case "No-impact landing":
                infoImage.setImageResource(R.drawable.noimpact);
                break;
            case "Platform cancel":
                infoImage.setImageResource(R.drawable.dropcancel);
                break;
            case "Powershield":
                infoImage.setImageResource(R.drawable.pshield);
                break;
            case "Platform warp":
                infoImage.setImageResource(R.drawable.pwarp);
                break;
            case "Shield pressure":
                infoImage.setImageResource(R.drawable.shieldpress);
                break;
            case "Shield dropping":
                infoImage.setImageResource(R.drawable.shielddrop);
                break;
            case "SHFFL":
                infoImage.setImageResource(R.drawable.shffl);
                break;
            case "Short hop":
                infoImage.setImageResource(R.drawable.shop);
                break;
            case "Tech":
                infoImage.setImageResource(R.drawable.tech);
                break;
            case "Tech-chasing":
                infoImage.setImageResource(R.drawable.techchase);
                break;
            case "Team wobble":
                infoImage.setImageResource(R.drawable.twobble);
                break;
            case "Wavedash":
                infoImage.setImageResource(R.drawable.wavedash);
                break;
            case "V-canceling":
                infoImage.setImageResource(R.drawable.vcancel);
                break;
        }
    }
}
