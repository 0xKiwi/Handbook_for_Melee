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

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.fragment.TabFragmentAdapter;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

import pl.droidsonroids.gif.GifImageView;

public class TechTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_tab_gif_layout);
        final SlidrInterface slidrInterface = Slidr.attach(this);

        if (getIntent().getExtras() == null)
            return;
        String techPicked = getIntent().getExtras().getString("option");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(0x00000000);
        final AppBarLayout appBar = (AppBarLayout) findViewById(R.id.app_bar);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(techPicked);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final GifImageView tabImage = (GifImageView) findViewById(R.id.infoGif);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        assert techPicked != null;
        switch(techPicked) {
            case "Wall jump":
                viewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(),
                        new String[]{"Wall Jump", "Ledge Wall Jump", "Reverse Wall Jump"}));
                tabLayout.setupWithViewPager(viewPager);

                tabImage.setImageResource(R.drawable.walljump);
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                        appBar.setExpanded(true);
                        switch(tab.getPosition()) {
                            case 0:
                                tabImage.setImageResource(R.drawable.walljump);
                                slidrInterface.unlock();
                                break;
                            case 1:
                                tabImage.setImageResource(R.drawable.defaultpic);
                                slidrInterface.lock();
                                break;
                            case 2:
                                tabImage.setImageResource(R.drawable.reversewalljump);
                                slidrInterface.lock();
                                break;
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                    }
                });
                break;
            case "Directional Influence":
                viewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(),
                        new String[]{"Directional Influence", "Smash DI", "DI Angles"}));
                tabLayout.setupWithViewPager(viewPager);

                tabImage.setImageResource(R.drawable.di);
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                        appBar.setExpanded(true);
                        switch(tab.getPosition()) {
                            case 0:
                                tabImage.setImageResource(R.drawable.di);
                                slidrInterface.unlock();
                                break;
                            case 1:
                                tabImage.setImageResource(R.drawable.sdi);
                                slidrInterface.lock();
                                break;
                            case 2:
                                tabImage.setImageResource(R.drawable.diangles);
                                slidrInterface.lock();
                                break;
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                });
                break;
            case "Super wavedash & SDWD":
                viewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(),
                        new String[]{"Super Wavedash", "Super Duper Wavedash"}));

                tabLayout.setupWithViewPager(viewPager);
                tabImage.setImageResource(R.drawable.swd);
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                        appBar.setExpanded(true);
                        switch(tab.getPosition()) {
                            case 0:
                                tabImage.setImageResource(R.drawable.swd);
                                slidrInterface.unlock();
                                break;
                            case 1:
                                tabImage.setImageResource(R.drawable.defaultpic);
                                slidrInterface.lock();
                                break;
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                });
                break;
            case "Extended & homing grapple":
                viewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(),
                        new String[]{"Extended grapple", "Homing grapple"}));
                tabLayout.setupWithViewPager(viewPager);

                tabImage.setImageResource(R.drawable.egrapple);
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                        appBar.setExpanded(true);
                        switch(tab.getPosition()) {
                            case 0:
                                tabImage.setImageResource(R.drawable.egrapple);
                                slidrInterface.unlock();
                                break;
                            case 1:
                                tabImage.setImageResource(R.drawable.hominggrapple);
                                slidrInterface.lock();
                                break;
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                });
                break;
            case "Shield dropping":
                viewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(),
                        new String[]{"Shield dropping", "Shai dropping"}));
                tabLayout.setupWithViewPager(viewPager);

                tabImage.setImageResource(R.drawable.shielddrop);
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                        appBar.setExpanded(true);
                        switch(tab.getPosition()) {
                            case 0:
                                tabImage.setImageResource(R.drawable.shielddrop);
                                slidrInterface.unlock();
                                break;
                            case 1:
                                tabImage.setImageResource(R.drawable.shaidrop);
                                slidrInterface.lock();
                                break;
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                });
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
