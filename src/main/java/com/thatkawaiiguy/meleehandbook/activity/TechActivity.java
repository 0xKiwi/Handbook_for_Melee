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

import android.net.Uri;
import android.os.Bundle;

import com.thatkawaiiguy.meleehandbook.R;

public class TechActivity extends VideoInfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setVideo();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("option", optionPicked);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        optionPicked = savedInstanceState.getString("option");
        setVideo();
    }

    public void setVideo(){
        switch (optionPicked) {
            case "Boomerang superjump":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Desynching":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Double jump refresh":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jumprefresh));
                break;
            //case "Extended grapple":
            //    infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
            //    break;
            case "Edge canceled eggs":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ece));
                break;
            case "Float cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fcan));
                break;
            case "DJ knockback armor":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.djka));
                break;
            case "Ledgehop double laser":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Multishine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Parry":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.parry));
                break;
            case "Pillaring":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Princess/Swordsman spiking":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Reverse angle boomerang":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "RI grapple cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rigc));
                break;
            case "Rising pound":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.risingpound));
                break;
            case "SHFF missiles":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shffm));
                break;
            case "Short hop laser":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Side-B shorten":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Shine mine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Up-B turnaround":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.upbturn));
                break;
            case "Up-B cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Wallbombing":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wallbomb));
                break;
            case "Waveshine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Wobbling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Yo-yo glitch":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Aerial interrupt":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;

            //NORMAL TECHS

            /*case "Chain grab":
                infoVid.setImageResource(R.drawable.cgrab);
                break;
            case "Crouch cancel":
                infoVid.setImageResource(R.drawable.crouchcancel);
                break;
            */case "Dash-dance":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dashdance));
                break;
            /*case "Fast falling":
                infoVid.setImageResource(R.drawable.ffall);
                break;
            case "Fox-trot":
                infoVid.setImageResource(R.drawable.ftrot);
                break;
            case "Jab reset":
                infoVid.setImageResource(R.drawable.jabreset);
                break;
            *///case "L-canceling":
            //infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lcancel));
            //    break;
            /*case "Ledge stall":
                infoVid.setImageResource(R.drawable.ledgestall);
                break;
            case "Ledge-canceling":
                infoVid.setImageResource(R.drawable.ledgecancel);
                break;
            case "Moonwalk":
                infoVid.setImageResource(R.drawable.moonwalk);
                break;
            case "No-impact landing":
                infoVid.setImageResource(R.drawable.noimpact);
                break;
            case "Platform cancel":
                infoVid.setImageResource(R.drawable.dropcancel);
                break;
            case "Powershield":
                infoVid.setImageResource(R.drawable.pshield);
                break;
            case "Platform warp":
                infoVid.setImageResource(R.drawable.pwarp);
                break;
            case "Shield pressure":
                infoVid.setImageResource(R.drawable.shieldpress);
                break;
            case "Shield dropping":
                infoVid.setImageResource(R.drawable.shielddrop);
                break;
            case "SHFFL":
                infoVid.setImageResource(R.drawable.shffl);
                break;
            case "Short hop":
                infoVid.setImageResource(R.drawable.shop);
                break;
            case "Tech":
                infoVid.setImageResource(R.drawable.tech);
                break;
            case "Tech-chasing":
                infoVid.setImageResource(R.drawable.techchase);
                break;
            case "Team wobble":
                infoVid.setImageResource(R.drawable.twobble);
                break;
            case "Wavedash":
                infoVid.setImageResource(R.drawable.wavedash);
                break;
            case "V-canceling":
                infoVid.setImageResource(R.drawable.vcancel);
                break;*/
        }
        infoVid.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setVideo();
    }
}
