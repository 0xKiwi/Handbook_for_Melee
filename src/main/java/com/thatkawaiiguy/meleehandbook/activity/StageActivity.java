package com.thatkawaiiguy.meleehandbook.activity;

import android.os.Bundle;

import com.thatkawaiiguy.meleehandbook.R;

public class StageActivity extends GifInfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (optionPicked) {
            case "Battlefield":
                infoImage.setImageResource(R.drawable.battlefieldbox);
                break;
            case "Dream Land":
                infoImage.setImageResource(R.drawable.dreamlandbox);
                break;
            case "Final Destination":
                infoImage.setImageResource(R.drawable.fdbox);
                break;
            case "Fountain of Dreams":
                infoImage.setImageResource(R.drawable.fodbox);
                break;
            case "Kongo Jungle (SSB)":
                infoImage.setImageResource(R.drawable.kongo);
                break;
            case "Pokemon Stadium":
                infoImage.setImageResource(R.drawable.pokestadiumbox);
                break;
            case "Yoshi's Story":
                infoImage.setImageResource(R.drawable.ystorybox);
                break;
        }
    }
}
