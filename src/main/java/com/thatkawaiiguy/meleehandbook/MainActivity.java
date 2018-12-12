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

package com.thatkawaiiguy.meleehandbook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

import com.thatkawaiiguy.meleehandbook.activity.AppSettingsActivity;
import com.thatkawaiiguy.meleehandbook.fragment.AboutDialogFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.MatchupFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.CharacterFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.FunFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.HealthyFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.StageFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.TechFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.TermFragment;
import com.thatkawaiiguy.meleehandbook.fragment.main.UniqueFragment;
import com.thatkawaiiguy.meleehandbook.other.AppRater;
import com.thatkawaiiguy.meleehandbook.utils.Preferences;
import com.thatkawaiiguy.meleehandbook.activity.SearchResultsActivity;

public class MainActivity extends AppCompatActivity {

    private int listdefault = 0;

    private Fragment fg = TechFragment.newInstance();

    private DrawerLayout mDrawer;
    private FragmentManager fragmentManager;

    private CharSequence mTitle;

    private static final String PRIVATE_PREF = "myapp";
    private static final String VERSION_KEY = "version_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Preferences.applySettingsTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        setupToolbar();

        setupNavDrawer(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle(Preferences.defaultListItem(this));
        mTitle = getTitle();
    }

    private void setupNavDrawer(Bundle savedInstanceState) {
        mDrawer = findViewById(R.id.drawer_layout);

        NavigationView nvDrawer = findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        NavigationMenuView navigationMenuView = (NavigationMenuView) nvDrawer.getChildAt(0);
        if(navigationMenuView != null)
            navigationMenuView.setVerticalScrollBarEnabled(false);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
            this, mDrawer, findViewById(R.id.toolbar),
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        //mDrawer.setDrawerListener(mDrawerToggle);
        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
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
            init();
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
            case R.id.uniquetech:
                mTitle = menuItem.getTitle();
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);

                menuItem.setChecked(true);
                sendToast();
                break;
            case R.id.characters:
            case R.id.fundamentals:
            case R.id.mu:
            case R.id.stages:
            case R.id.term:
            case R.id.healthy:
                mTitle = menuItem.getTitle();
                assert getSupportActionBar() != null;
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);

                menuItem.setChecked(true);
                break;
            case R.id.settings:
                startActivity(new Intent(this, AppSettingsActivity.class));
                break;
            case R.id.about:
                new AboutDialogFragment().show(fragmentManager, "about");
                break;
        }
        mDrawer.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        if(Preferences.showExitDialog(this)) {
            new ExitDialogFragment().show(fragmentManager, "exit");
        } else
            super.onBackPressed();
    }

    private Fragment getProperFragment(String title) {
        if(title.equals(getString(R.string.title_advancedtech)))
            return TechFragment.newInstance();
        else if(title.equals(getString(R.string.title_characters)))
            return CharacterFragment.newInstance();
        else if(title.equals(getString(R.string.title_fundamentals)))
            return FunFragment.newInstance();
        else if(title.equals(getString(R.string.title_stages)))
            return StageFragment.newInstance();
        else if(title.equals(getString(R.string.title_matchups)))
            return MatchupFragment.newInstance();
        else if(title.equals(getString(R.string.title_term)))
            return TermFragment.newInstance();
        else if(title.equals(getString(R.string.title_uniquetech)))
            return UniqueFragment.newInstance();
        else if(title.equals(getString(R.string.title_healthy)))
            return HealthyFragment.newInstance();
        else
            return HealthyFragment.newInstance();
    }

    private void changeFragment(CharSequence title) {
        Fragment fg2 = getProperFragment(title.toString());

        if(!fg.equals(fg2)) {
            fg = fg2;
            fragmentManager.beginTransaction().replace(R.id.fragmentLayout, fg).commit();
        }
    }

    private void sendToast() {
        if(Preferences.showToast(this)) {
            Toast.makeText(getApplicationContext(), "Don't forget to stretch and take breaks! You" +
                " don't want to have to go to the doctor.", Toast.LENGTH_SHORT).show();
        }
    }

    private void addFragment() {
        String title = Preferences.defaultListItem(this);
        fg = getProperFragment(title);
        listdefault = getListPosition(title);
        fragmentManager.beginTransaction().add(R.id.fragmentLayout, fg).commit();
    }

    private int getListPosition(String title) {
        if(title.equals(getString(R.string.title_advancedtech)))
            return 0;
        else if(title.equals(getString(R.string.title_characters)))
            return 1;
        else if(title.equals(getString(R.string.title_fundamentals)))
            return 2;
        else if(title.equals(getString(R.string.title_stages)))
            return 3;
        else if(title.equals(getString(R.string.title_matchups)))
            return 4;
        else if(title.equals(getString(R.string.title_term)))
            return 5;
        else if(title.equals(getString(R.string.title_uniquetech)))
            return 6;
        else if(title.equals(getString(R.string.title_healthy)))
            return 7;
        else
            return 7;
    }

    private void init() {
        SharedPreferences sharedPref = getSharedPreferences(PRIVATE_PREF, Context.MODE_PRIVATE);
        int currentVersionNumber = 0;
        int savedVersionNumber = sharedPref.getInt(VERSION_KEY, 0);

        try {
            PackageInfo pi = getPackageManager().getPackageInfo(getPackageName(), 0);
            currentVersionNumber = pi.versionCode;
        } catch(Exception ignored) {
        }

        if(currentVersionNumber > savedVersionNumber) {
            showWhatsNewDialog();

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(VERSION_KEY, currentVersionNumber);
            editor.apply();
        }
    }

    private void showWhatsNewDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = inflater.inflate(R.layout.dialog_whatsnew, null);
        builder.setView(view).setTitle("Whats New")
                .setPositiveButton("OK", (DialogInterface dialog, int which) -> dialog.dismiss());

        builder.create().show();
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
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            selectDrawerItem(menuItem);
            return true;
        });
    }

    public static class ExitDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                .setTitle("Are you sure you want to exit the app?")
                .setNegativeButton(R.string.no, (DialogInterface dialog, int id) -> {
                    dialog.dismiss();
                })
                .setPositiveButton(R.string.yes, (DialogInterface dialog, int id) -> {
                    getActivity().finish();
                    System.exit(0);
                })
                .show();
        }
    }
}