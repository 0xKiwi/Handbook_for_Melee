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
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.TextView;

import com.appodeal.ads.Appodeal;
import com.r0adkll.slidr.Slidr;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.MutedVideoView;
import com.thatkawaiiguy.meleehandbook.other.Preferences;
import com.thatkawaiiguy.meleehandbook.other.XMLParser;

import org.xmlpull.v1.XmlPullParser;

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

        text.setText(Html.fromHtml(XMLParser.getInnerXMLfromTitle(id, optionPicked, getResources())));
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP, Integer.parseInt(Preferences.getTextSize
                (this)));

        infoVid = (MutedVideoView) findViewById(R.id.infoVid);
        setVideo();

        /*if (Build.VERSION.SDK_INT >= 21) {
            oldStatusColor = getWindow().getStatusBarColor();
            getWindow().setStatusBarColor(0x00000000);
        }

        final Window activity = getWindow();
*/
        final AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                        //if (Build.VERSION.SDK_INT >= 21)
                        //    activity.setStatusBarColor(oldStatusColor);
                        if (infoVid.isPlaying())
                            infoVid.pause();
                    } else {
                        //if (Build.VERSION.SDK_INT >= 21)
                        //    activity.setStatusBarColor(0x00000000);
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
        switch (optionPicked) {
            case "Boomerang superjump":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.boomjump));
                break;
            case "Chillin dash":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.chillindash));
                break;
            case "Desynching":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.desync));
                break;
            case "Double jump refresh":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.jumprefresh));
                break;
            case "Edge canceled eggs":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.ece));
                break;
            case "Float cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.fcan));
                break;
            case "Frozen turnip glitch":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.frozenturnip));
                break;
            case "Gentleman":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.gentleman));
                break;
            case "Double jump cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.djc));
                break;
            case "DJ knockback armor":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.djka));
                break;
            case "Ledgehop double laser":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.lhdl));
                break;
            case "Multishine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.multishine));
                break;
            case "Needle turnaround cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.needlecancel));
                break;
            case "Parry":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.parry));
                break;
            case "Pillaring":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.pillar));
                break;
            case "Princess/Swordsman spiking":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.psspiking));
                break;
            case "RI grapple cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.rigc));
                break;
            case "Rising pound":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.risingpound));
                break;
            case "SHFF missiles":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.shffm));
                break;
            case "Short hop laser":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.shl));
                break;
            case "Side-B shorten":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.sidebshorten));
                break;
            case "Shine mine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.shinemine));
                break;
            case "Up-B turnaround":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.upbturn));
                break;
            case "Up-B cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.upbcan));
                break;
            case "Up-B walljump":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.upbwalljump));
                break;
            case "Vududash":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.vudu));
                break;
            case "Wallbombing":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.wallbomb));
                break;
            case "Waveshine":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.waveshine));
                break;
            case "Wobbling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.wobbling));
                break;
            case "Yo-yo glitch":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.yoyoglitch));
                break;

            //NORMAL TECHS

            case "Aerial interrupt":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.ai));
                break;
            case "Chain grab":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.cgrab));
                break;
            case "Crouch cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.crouchcancel));
                break;
            case "Dash-dance":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.dashdance));
                break;
            case "Fast fall":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.ffall));
                break;
            case "Fox-trot":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.ftrot));
                break;
            case "Jab reset":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.jabreset));
                break;
            case "Jump-canceled grab":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.jcgrab));
                break;
            case "L-cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.lcancel));
                break;
            case "Ledgedash":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.ledgedash));
                break;
            case "Ledge stalling":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.ledgestall));
                break;
            case "Ledge-cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.ledgecancel));
                break;
            case "Ledge dropping":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.pcdrop));
                break;
            case "Marth killer":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.marthkiller));
                break;
            case "Moonwalk":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.moonwalk));
                break;
            case "No-impact land":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.noimpact));
                break;
            case "Platform cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.platformcancel));
                break;
            case "Powershield":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.pshield));
                break;
            case "Platform warp":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.pwarp));
                break;
            case "Shield pressure":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.shieldpress));
                break;
            case "Shield dropping":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.shielddrop));
                break;
            case "SHFFL":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.shffl));
                break;
            case "Short hop":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.shop));
                break;
            case "Tech":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.tech));
                break;
            case "Tech-chase":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.techchase));
                break;
            case "Team wobble":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.twobble));
                break;
            case "Wavedash":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.wavedash));
                break;
            case "V-cancel":
                infoVid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R
                        .raw.vcancel));
                break;
        }

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
