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
                infoGif.setImageResource(R.drawable.posture);
                infoText.setText(R.string.posture_info_text);
                break;
            case "Mental health":
                infoText.setText(R.string.mental_info_text);
                break;
            case "Dozer":
                infoGif.setImageResource(R.drawable.dozer);
                infoText.setText(R.string.dozer_info_text);
                break;
            case "Upstairs, downstairs":
                infoGif.setImageResource(R.drawable.upstairs);
                infoText.setText(R.string.upstairs_info_text);
                break;
            case "King leer":
                infoGif.setImageResource(R.drawable.kingleer);
                infoText.setText(R.string.kingleer_info_text);
                break;
            case "Sidewatcher":
                infoGif.setImageResource(R.drawable.sidewatcher);
                infoText.setText(R.string.sidewatcher_info_text);
                break;
            case "Near, far":
                infoGif.setImageResource(R.drawable.nearfar);
                infoText.setText(R.string.near_info_text);
                break;
            case "Handshake":
                infoGif.setImageResource(R.drawable.handshake);
                infoText.setText(R.string.handshake_info_text);
                break;
            case "Thumb sweep":
                infoGif.setImageResource(R.drawable.thumbsweep);
                infoText.setText(R.string.thumbsweep_info_text);
                break;
            case "Cuticle check":
                infoGif.setImageResource(R.drawable.cuticllecheck);
                infoText.setText(R.string.cuticlecheck_info_text);
                break;
            case "Wrist circles":
                infoGif.setImageResource(R.drawable.wristcircles);
                infoText.setText(R.string.wristcircles_info_text);
                break;
            case "Break at the wrist":
                infoGif.setImageResource(R.drawable.breakwrist);
                infoText.setText(R.string.break_info_text);
                break;
            case "Stop (in the name of love)":
                infoGif.setImageResource(R.drawable.stopstretch);
                infoText.setText(R.string.stop_info_text);
                break;
            case "Underhanded stretch":
                infoGif.setImageResource(R.drawable.underhand);
                infoText.setText(R.string.underhand_info_text);
                break;
            case "The block":
                infoGif.setImageResource(R.drawable.block);
                infoText.setText(R.string.block_info_text);
                break;
            case "Thumb push":
                infoGif.setImageResource(R.drawable.thumbpush);
                infoText.setText(R.string.thumbpush_info_text);
                break;
            case "Thumb pull":
                infoGif.setImageResource(R.drawable.thumbpull);
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
