package com.thatkawaiiguy.meleehandbook;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
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
import com.thatkawaiiguy.meleehandbook.fragment.ExitDialogFragment;
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

    int listdefault = 0;

    Fragment fg = TechFragment.newInstance();

    ActionBarDrawerToggle drawerToggle;

    private DrawerLayout mDrawer;

    private CharSequence mTitle;

    SearchView searchView;


    Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Preferences.applySettingsTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        }
    }

    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.advancedtech:
                mTitle = getString(R.string.title_advancedtech);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                sendToast();
                break;
            case R.id.characters:
                mTitle = getString(R.string.title_characters);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.fundamentals:
                mTitle = getString(R.string.title_fundamentals);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.mu:
                mTitle = getString(R.string.title_matchups);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.stages:
                mTitle = getString(R.string.title_stages);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.term:
                mTitle = getString(R.string.title_term);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                break;
            case R.id.uniquetech:
                mTitle = getString(R.string.title_uniquetech);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(mTitle);
                menuItem.setChecked(true);
                sendToast();
                break;
            case R.id.healthy:
                mTitle = getString(R.string.title_healthy);
                getSupportActionBar().setTitle(mTitle);
                changeFragment(getString(R.string.title_healthy));
                menuItem.setChecked(true);
                break;
            case R.id.settings:
                Intent mSettingsIntent = new Intent(this, AppSettingsActivity.class);
                startActivity(mSettingsIntent);
                break;
            case R.id.about:
                DialogFragment newFragment = new AboutDialogFragment();
                newFragment.show(getFragmentManager(), "about");
                break;
        }
        mDrawer.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        if(Preferences.showExitDialog(this)) {
            DialogFragment newFragment = new ExitDialogFragment();
            newFragment.show(getFragmentManager(), "exit");
        } else
            super.onBackPressed();
    }

    public void changeFragment(CharSequence title) {
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

    public void sendToast() {
        Toast.makeText(getApplicationContext(), "You should stretch! You don't want to have to go to the doctor.",
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
            onSearchRequested();
            return true;
        } else if(drawerToggle.onOptionsItemSelected(item)) {
            if(searchView != null)
                searchView.onActionViewCollapsed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        if(searchView != null)
            searchView.onActionViewCollapsed();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        mMenu = menu;
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView)
                MenuItemCompat.getActionView(menu.findItem(R.id.search));

        ComponentName cn = new ComponentName(this, SearchResultsActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));

        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean queryTextFocused) {
                if(!queryTextFocused) {
                    searchView.clearFocus();
                    searchView.setIconified(true);

                    if(mMenu != null)
                        (mMenu.findItem(R.id.search)).collapseActionView();
                }
            }
        });
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
}