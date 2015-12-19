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
            case "DJC counter":
                infoImage.setImageResource(R.drawable.djcc);
                break;
            case "Double jump cancel":
                infoImage.setImageResource(R.drawable.djc);
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
            case "Up-B turnaround":
                infoImage.setImageResource(R.drawable.upbturn);
                break;
            case "Up-B cancel":
                infoImage.setImageResource(R.drawable.upbcancel);
                break;
            case "Vududash":
                infoImage.setImageResource(R.drawable.vudu);
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
