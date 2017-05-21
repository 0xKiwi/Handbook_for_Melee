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

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.TextView;

import com.appodeal.ads.Appodeal;
import com.r0adkll.slidr.Slidr;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.utils.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.MutedVideoView;
import com.thatkawaiiguy.meleehandbook.utils.Preferences;
import com.thatkawaiiguy.meleehandbook.utils.XMLParser;

public class VideoInfoActivity extends AppCompatActivity {

    private String optionPicked = "";

    private MutedVideoView infoVid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_video_layout);
        Slidr.attach(this);

        Bundle mainData = getIntent().getExtras();
        if (mainData == null)
            return;
        optionPicked = mainData.getString("option");
        int id = mainData.getInt("xml");

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(optionPicked);

        TextView text = (TextView) findViewById(R.id.infoText);
        text.setMovementMethod(LinkMovementMethod.getInstance());

        Log.d("MEME", optionPicked + id);
        text.setText(Html.fromHtml(XMLParser.getInnerXMLfromTitle(id, optionPicked, getResources())));
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, Integer.parseInt(Preferences.getTextSize
                (this)));

        infoVid = (MutedVideoView) findViewById(R.id.infoVid);
        setVideo();

        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange() - getStatusBarHeight()) {
                        if (infoVid.isPlaying())
                            infoVid.pause();
                    } else {
                        if (!infoVid.isPlaying())
                            infoVid.start();
                    }
                }
            });
        }

        if (!Preferences.hideAds(this)) {
            Appodeal.setBannerViewId(R.id.adView);
            Appodeal.show(this, Appodeal.BANNER_VIEW);
        }
    }


    private void setVideo() {
        infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                getResources().getIdentifier(ArrayHelper.getFileName(optionPicked), "raw", getPackageName())));

        infoVid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0, 0);
                mp.setLooping(true);
                mp.start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setVideo();
        Appodeal.onResume(this, Appodeal.BANNER_VIEW);
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

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private int getActionBarHeight() {
        int actionBarHeight = 0;

        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources()
                    .getDisplayMetrics());
        }
        return actionBarHeight;
    }
}
