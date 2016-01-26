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

package com.thatkawaiiguy.meleehandbook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.thatkawaiiguy.meleehandbook.activity.AppSettingsActivity;
import com.thatkawaiiguy.meleehandbook.fragment.AboutDialogFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.CharacterFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.FunFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.HealthyFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.StageFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.MatchupFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.TechFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.TermFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.UniqueFragment;
import com.thatkawaiiguy.meleehandbook.other.AppRater;
import com.thatkawaiiguy.meleehandbook.other.Preferences;
import com.thatkawaiiguy.meleehandbook.activity.SearchResultsActivity;

public class MainActivity extends AppCompatActivity {

    private int listdefault = 0;

    private Fragment fg = TechFragment.newInstance();

    private DrawerLayout mDrawer;

    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Preferences.applySettingsTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        if(!Preferences.hideAds(this)) {
            mAdView.loadAd(new AdRequest.Builder().build());
            mAdView.setVisibility(View.VISIBLE);
        } else if(Preferences.hideAds(this))
            mAdView.setVisibility(View.GONE);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        NavigationMenuView navigationMenuView = (NavigationMenuView) nvDrawer.getChildAt(0);
        if (navigationMenuView != null)
            navigationMenuView.setVerticalScrollBarEnabled(false);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        //mDrawer.setDrawerListener(mDrawerToggle);
        mDrawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    slideOffset = 1.0f - slideOffset;
                    int a = Math.min(255, Math.max(0, (int) (slideOffset * 255))) << 24;
                    int rgb = 0x00ffffff & getWindow().getStatusBarColor();
                    getWindow().setStatusBarColor(a + rgb);
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });

        mDrawerToggle.syncState();

        if(savedInstanceState == null) {
            setTitle(Preferences.defaultListItem(this));
            mTitle = getTitle();
            addFragment();
            nvDrawer.getMenu().getItem(listdefault).setChecked(true);
            AppRater.app_launched(this);
            if(Preferences.openNavLaunchEnabled(this))
                mDrawer.openDrawer(Gravity.LEFT);
        }
    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.advancedtech:
                mTitle = getString(R.string.title_advancedtech);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                sendToast();
                break;
            case R.id.characters:
                mTitle = getString(R.string.title_characters);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.fundamentals:
                mTitle = getString(R.string.title_fundamentals);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.mu:
                mTitle = getString(R.string.title_matchups);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.stages:
                mTitle = getString(R.string.title_stages);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.term:
                mTitle = getString(R.string.title_term);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.uniquetech:
                mTitle = getString(R.string.title_uniquetech);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                sendToast();
                break;
            case R.id.healthy:
                mTitle = getString(R.string.title_healthy);
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(getString(R.string.title_healthy));
                menuItem.setChecked(true);
                break;
            case R.id.support:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("http://bit.ly/1NXCD2o")));
                break;
            case R.id.settings:
                startActivity(new Intent(this, AppSettingsActivity.class));
                break;
            case R.id.about:
                new AboutDialogFragment().show(getFragmentManager(), "about");
                break;
        }
        mDrawer.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        if(Preferences.showExitDialog(this)) {
            new ExitDialogFragment().show(getFragmentManager(), "exit");
        } else
            super.onBackPressed();
    }

    private void changeFragment(CharSequence title) {
        switch((String) title) {
            case "Advanced Techniques":
                if(!fg.equals(TechFragment.newInstance()))
                    fg = TechFragment.newInstance();
                break;
            case "Characters":
                if(!fg.equals(CharacterFragment.newInstance()))
                    fg = CharacterFragment.newInstance();
                break;
            case "Fundamentals":
                if(!fg.equals(FunFragment.newInstance()))
                    fg = FunFragment.newInstance();
                break;
            case "Stages":
                if(!fg.equals(StageFragment.newInstance()))
                    fg = StageFragment.newInstance();
                break;
            case "Matchups":
                if(!fg.equals(MatchupFragment.newInstance()))
                    fg = MatchupFragment.newInstance();
                break;
            case "Terminology":
                if(!fg.equals(TermFragment.newInstance()))
                    fg = TermFragment.newInstance();
                break;
            case "Unique Techniques":
                if(!fg.equals(UniqueFragment.newInstance()))
                    fg = UniqueFragment.newInstance();
                break;
            case "Staying Healthy":
                if(!fg.equals(HealthyFragment.newInstance()))
                    fg = HealthyFragment.newInstance();
            default:
                if(fg != HealthyFragment.newInstance())
                    fg = HealthyFragment.newInstance();
        }
        getFragmentManager().beginTransaction().replace(R.id.fragmentLayout, fg).commit();
    }

    private void sendToast() {
        Toast.makeText(getApplicationContext(), "Don't forget to stretch and take breaks! You don't want to have to go" +
                        " to the doctor.",
                Toast.LENGTH_SHORT).show();
    }

    private void addFragment() {
        switch(Preferences.defaultListItem(this)) {
            case "Advanced Techniques":
                listdefault = 0;
                fg = TechFragment.newInstance();
                break;
            case "Characters":
                listdefault = 1;
                fg = CharacterFragment.newInstance();
                break;
            case "Fundamentals":
                listdefault = 2;
                fg = FunFragment.newInstance();
                break;
            case "Matchups":
                listdefault = 3;
                fg = MatchupFragment.newInstance();
                break;
            case "Stages":
                listdefault = 4;
                fg = StageFragment.newInstance();
                break;
            case "Terminology":
                listdefault = 5;
                fg = TermFragment.newInstance();
                break;
            case "Unique Techniques":
                listdefault = 6;
                fg = UniqueFragment.newInstance();
                break;
            case "Staying Healthy":
                listdefault = 7;
                fg = HealthyFragment.newInstance();
                break;
            default:
                fg = TechFragment.newInstance();
        }
        getFragmentManager().beginTransaction().add(R.id.fragmentLayout, fg).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.search) {
            startActivity(new Intent(this, SearchResultsActivity.class));
            overridePendingTransition(0, 0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if(menuItem != null) {
                            selectDrawerItem(menuItem);
                            return true;
                        } else
                            return false;
                    }
                });
    }

    public static class ExitDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setTitle("Are you sure you want to exit the app?")
                    .setNegativeButton(R.string.no,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            })
                    .setPositiveButton(R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    getActivity().finish();
                                    System.exit(0);
                                }
                            })
                    .show();
        }
    }
}