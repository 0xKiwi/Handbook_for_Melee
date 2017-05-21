/*
    This file is part of Handbook for Melee.

    Handbook for Melee is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Handbook for Melee is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Handbook for Melee.  If not, see <http://www.gnu.org/licenses/>
 */

package com.thatkawaiiguy.meleehandbook.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.utils.Preferences;

import pl.droidsonroids.gif.GifImageView;

public class GifInfoActivity extends AppCompatActivity {
    String optionPicked = "";

    GifImageView infoGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_gif_layout);
        Slidr.attach(this);

        Bundle mainData = getIntent().getExtras();
        if (mainData == null)
            return;
        optionPicked = mainData.getString("option");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(0x00000000);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(optionPicked);

        infoGif = (GifImageView) findViewById(R.id.infoGif);

        TextView text = (TextView) findViewById(R.id.infoText);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(Preferences.getTextSize(this)));
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("option", optionPicked);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        optionPicked = savedInstanceState.getString("option");
    }
}
