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
import android.os.Handler;

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
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.boomjump));
                break;
            case "Desynching":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.desync));
                break;
            case "Double jump refresh":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jumprefresh));
                break;
            case "Edge canceled eggs":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ece));
                break;
            case "Float cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fcan));
                break;
            case "Frozen turnip glitch":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.frozenturnip));
                break;
            case "Double jump cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.djc));
                break;
            case "DJ knockback armor":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.djka));
                break;
            case "Ledgehop double laser":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lhdl));
                break;
            case "Multishine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.multishine));
                break;
            case "Parry":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.parry));
                break;
            case "Pillaring":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pillar));
                break;
            case "Princess/Swordsman spiking":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.psspiking));
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
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shl));
                break;
            case "Side-B shorten":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sidebshorten));
                break;
            case "Shine mine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shinemine));
                break;
            case "Up-B turnaround":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.upbturn));
                break;
            case "Up-B cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.upbcan));
                break;
            case "Vududash":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vudu));
                break;
            case "Wallbombing":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wallbomb));
                break;
            case "Waveshine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.waveshine));
                break;
            case "Wobbling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wobbling));
                break;
            case "Yo-yo glitch":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.yoyoglitch));
                break;

            //NORMAL TECHS

            case "Aerial interrupt":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ai));
                break;
            case "Chain grab":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cgrab));
                break;
            case "Crouch cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crouchcancel));
                break;
            case "Dash-dance":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dashdance));
                break;
            case "Fast falling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ffall));
                break;
            case "Fox-trot":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ftrot));
                break;
            case "Jab reset":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jabreset));
                break;
            case "L-canceling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lcancel));
                break;
            case "Ledgedash":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ledgedash));
                break;
            case "Ledge stall":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ledgestall));
                break;
            case "Ledge-canceling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ledgecancel));
                break;
            case "Moonwalk":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.moonwalk));
                break;
            case "No-impact landing":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.noimpact));
                break;
            case "Platform cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.platformcancel));
                break;
            case "Powershield":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pshield));
                break;
            case "Platform warp":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pwarp));
                break;
            case "Shield pressure":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shieldpress));
                break;
            case "Shield dropping":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shielddrop));
                break;
            case "SHFFL":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shffl));
                break;
            case "Short hop":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shop));
                break;
            case "Tech":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tech));
                break;
            case "Tech-chasing":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.techchase));
                break;
            case "Team wobble":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.twobble));
                break;
            case "Wavedash":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wavedash));
                break;
            case "V-canceling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vcancel));
                break;
        }
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                infoVid.start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setVideo();
    }
}
