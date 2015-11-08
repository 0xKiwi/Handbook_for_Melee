package com.thatkawaiiguy.meleehandbook.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

import pl.droidsonroids.gif.GifImageView;

public class GifInfoActivity extends AppCompatActivity {
    protected String optionPicked = "";

    protected GifImageView infoImage;

    protected AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_gif_layout);
        Slidr.attach(this);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        Bundle mainData = getIntent().getExtras();
        if (mainData == null)
            return;
        optionPicked = mainData.getString("option");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(0x00000000);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(optionPicked);

        infoImage = (GifImageView) findViewById(R.id.infoGif);

        TextView infoText = (TextView) findViewById(R.id.infoText);
        infoText.setText(Html
                .fromHtml(ArrayHelper.getInfoString(optionPicked, this)));
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
