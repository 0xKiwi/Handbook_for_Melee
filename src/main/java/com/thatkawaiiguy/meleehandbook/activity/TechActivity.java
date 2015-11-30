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
            case "DI angles":
                infoImage.setImageResource(R.drawable.diangles);
                break;
            case "Directional Influence":
                infoImage.setImageResource(R.drawable.di);
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
            case "Ledgedash":
                infoImage.setImageResource(R.drawable.ledgedash);
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
            case "Scar jump":
                infoImage.setImageResource(R.drawable.scarjump);
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
            case "Smash DI":
                infoImage.setImageResource(R.drawable.sdi);
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
            case "Wall jump":
                infoImage.setImageResource(R.drawable.walljump);
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
