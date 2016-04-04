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

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.r0adkll.slidr.Slidr;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.MutedVideoView;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

public class VideoInfoActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler{

    String optionPicked = "";

    MutedVideoView infoVid;

    BillingProcessor bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_video_layout);
        Slidr.attach(this);

        bp = new BillingProcessor(this, getResources().getString(R.string.licensekey), this);
        bp.loadOwnedPurchasesFromGoogle();

        AdView mAdView = (AdView) findViewById(R.id.adView);
        if(!bp.isPurchased(getResources().getString(R.string.adproductid))) {
            mAdView.loadAd(new AdRequest.Builder().build());
            mAdView.setVisibility(View.VISIBLE);
        } else
            mAdView.setVisibility(View.GONE);

        Bundle mainData = getIntent().getExtras();
        if (mainData == null)
            return;
        optionPicked = mainData.getString("option");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0x00000000);
            NestedScrollView scroll = (NestedScrollView)findViewById(R.id.video_scrollView);
            scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int
                        oldScrollX, int oldScrollY) {
                    if(scrollX < 5)
                        getWindow().setStatusBarColor(0x00000000);
                    else
                        getWindow().setStatusBarColor(adjustAlpha(ContextCompat.getColor(getParent(), R.color.theme_accent), (float) (scrollX + 20) / 10));

                }
            });
        }

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(optionPicked);

        infoVid = (MutedVideoView) findViewById(R.id.infoVid);
        infoVid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0,0);
                mp.setLooping(true);
            }
        });

        TextView text = (TextView) findViewById(R.id.infoText);
        text.setText(Html.fromHtml(ArrayHelper.getInfoString(optionPicked, this)));
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, Integer.parseInt(Preferences.getTextSize(this)));
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
    public void onBillingError(int errorCode, Throwable error) {

    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingInitialized() {

    }

    public int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
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


    @Override
    public void onDestroy() {
        super.onDestroy();

        if(bp != null)
            bp.release();
    }
}
