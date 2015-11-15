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
            case "Ganondorf":
                infoImage.setImageResource(R.drawable.ganondorf);
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
            case "Pikachu":
                infoImage.setImageResource(R.drawable.pikachu);
                break;
            case "Princess Peach":
                infoImage.setImageResource(R.drawable.peach);
                break;
            case "Princess Zelda":
                infoImage.setImageResource(R.drawable.zelda);
                break;
            case "Roy":
                infoImage.setImageResource(R.drawable.roy);
                break;
            case "Yoshi":
                infoImage.setImageResource(R.drawable.yoshi);
                break;
            case "Young Link":
                infoImage.setImageResource(R.drawable.ylink);
                break;
        }
    }
}