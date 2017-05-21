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
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;
import com.thatkawaiiguy.meleehandbook.utils.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.utils.Preferences;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.fragment.CharacterFragmentAdapter;

public class CharacterFrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_tab_image_layout);
        final SlidrInterface slidrInterface = Slidr.attach(this);

        if (getIntent().getExtras() == null)
            return;
        String charPicked = getIntent().getExtras().getString("option");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(charPicked);
        assert getSupportActionBar() != null;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CharacterFragmentAdapter(getSupportFragmentManager()));

        TabLayout tabs = ((TabLayout) findViewById(R.id.tabs));
        tabs.setupWithViewPager(viewPager);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        slidrInterface.unlock();
                        break;
                    case 1:
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

        ((ImageView) findViewById(R.id.infoImage)).setImageResource(getResources().getIdentifier(ArrayHelper
                .getFileName(charPicked), "drawable", getPackageName()));
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

    public String getSupportActionBarTitle() {
        assert getSupportActionBar() != null;
        return (String) getSupportActionBar().getTitle();
    }
}