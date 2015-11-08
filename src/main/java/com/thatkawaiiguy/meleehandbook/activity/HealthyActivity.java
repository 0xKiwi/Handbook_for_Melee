package com.thatkawaiiguy.meleehandbook.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;

public class HealthyActivity extends GifInfoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView infoText = (TextView) findViewById(R.id.infoText);

        switch (optionPicked) {
            case "Posture":
                infoImage.setImageResource(R.drawable.posture);
                infoText.setText(R.string.posture_info_text);
                break;
            case "Mental health":
                infoText.setText(R.string.mental_info_text);
                break;
            case "Dozer":
                infoImage.setImageResource(R.drawable.dozer);
                infoText.setText(R.string.dozer_info_text);
                break;
            case "Upstairs, downstairs":
                infoImage.setImageResource(R.drawable.upstairs);
                infoText.setText(R.string.upstairs_info_text);
                break;
            case "King leer":
                infoImage.setImageResource(R.drawable.kingleer);
                infoText.setText(R.string.kingleer_info_text);
                break;
            case "Sidewatcher":
                infoImage.setImageResource(R.drawable.sidewatcher);
                infoText.setText(R.string.sidewatcher_info_text);
                break;
            case "Near, far":
                infoImage.setImageResource(R.drawable.nearfar);
                infoText.setText(R.string.near_info_text);
                break;
            case "Handshake":
                infoImage.setImageResource(R.drawable.handshake);
                infoText.setText(R.string.handshake_info_text);
                break;
            case "Thumb sweep":
                infoImage.setImageResource(R.drawable.thumbsweep);
                infoText.setText(R.string.thumbsweep_info_text);
                break;
            case "Cuticle check":
                infoImage.setImageResource(R.drawable.cuticllecheck);
                infoText.setText(R.string.cuticlecheck_info_text);
                break;
            case "Wrist circles":
                infoImage.setImageResource(R.drawable.wristcircles);
                infoText.setText(R.string.wristcircles_info_text);
                break;
            case "Break at the wrist":
                infoImage.setImageResource(R.drawable.breakwrist);
                infoText.setText(R.string.break_info_text);
                break;
            case "Stop (in the name of love)":
                infoImage.setImageResource(R.drawable.stopstretch);
                infoText.setText(R.string.stop_info_text);
                break;
            case "Underhanded stretch":
                infoImage.setImageResource(R.drawable.underhand);
                infoText.setText(R.string.underhand_info_text);
                break;
            case "The block":
                infoImage.setImageResource(R.drawable.block);
                infoText.setText(R.string.block_info_text);
                break;
            case "Thumb push":
                infoImage.setImageResource(R.drawable.thumbpush);
                infoText.setText(R.string.thumbpush_info_text);
                break;
            case "Thumb pull":
                infoImage.setImageResource(R.drawable.thumbpull);
                infoText.setText(R.string.thumbpull_info_text);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
