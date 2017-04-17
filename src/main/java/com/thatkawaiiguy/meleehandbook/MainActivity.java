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

import com.appodeal.ads.Appodeal;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.appodeal.ads.UserSettings;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import com.thatkawaiiguy.meleehandbook.other.Preferences;
import com.thatkawaiiguy.meleehandbook.activity.SearchResultsActivity;

public class MainActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler {

    private int listdefault = 0;

    private Fragment fg = TechFragment.newInstance();

    private DrawerLayout mDrawer;
    private FragmentManager fragmentManager;

    private CharSequence mTitle;

    private BillingProcessor bp;
    private FirebaseAnalytics mFirebaseAnalytics;

    private static final String PRIVATE_PREF = "myapp";
    private static final String VERSION_KEY = "version_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Preferences.applySettingsTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        bp = new BillingProcessor(this, getResources().getString(R.string.licensekey), this);
        bp.loadOwnedPurchasesFromGoogle();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        prepareAdmob();

        if (!Preferences.hideAds(this))
            Appodeal.show(this, Appodeal.BANNER_VIEW);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
        if (Preferences.hideAds(this) || !BillingProcessor.isIabServiceAvailable(this))
            nvDrawer.getMenu().findItem(R.id.remove).setTitle("Thank you!!");

        NavigationMenuView navigationMenuView = (NavigationMenuView) nvDrawer.getChildAt(0);
        if (navigationMenuView != null)
            navigationMenuView.setVerticalScrollBarEnabled(false);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        //mDrawer.setDrawerListener(mDrawerToggle);
        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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

        setTitle(Preferences.defaultListItem(this));
        mTitle = getTitle();

        if (savedInstanceState == null) {
            init();
            addFragment();
            nvDrawer.getMenu().getItem(listdefault).setChecked(true);
            AppRater.app_launched(this);
            if (Preferences.openNavLaunchEnabled(this))
                mDrawer.openDrawer(Gravity.LEFT);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Appodeal.onResume(this, Appodeal.BANNER_VIEW);
    }

    private void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
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
            case R.id.remove:
                if (bp.isPurchased(getResources().getString(R.string.adproductid)))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://umad.com/img/2" +
                            "015/10/happy-jigglypuff-pokemon-gif-536-593-hd-wallpapers.jpg")));
                else if (BillingProcessor.isIabServiceAvailable(this)) {
                    bp.purchase(this, getResources().getString(R.string.adproductid));
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://bit" +
                            ".ly/1NXCD2o")));
                }
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
        if (Preferences.showExitDialog(this)) {
            new ExitDialogFragment().show(fragmentManager, "exit");
        } else
            super.onBackPressed();
    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        Preferences.setHideAds(this, true);
        recreate();
    }

    @Override
    public void onPurchaseHistoryRestored() {
        if (bp.isPurchased(getString(R.string.adproductid))) {
            Preferences.setHideAds(this, true);
        } else
            Preferences.setHideAds(this, false);
        recreate();
    }

    @Override
    public void onBillingInitialized() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data);
    }

    private void changeFragment(CharSequence title) {
        Fragment fg2;
        switch ((String) title) {
            case "Advanced Techniques":
                fg2 = TechFragment.newInstance();
                break;
            case "Characters":
                fg2 = CharacterFragment.newInstance();
                break;
            case "Fundamentals":
                fg2 = FunFragment.newInstance();
                break;
            case "Stages":
                fg2 = StageFragment.newInstance();
                break;
            case "Matchups":
                fg2 = MatchupFragment.newInstance();
                break;
            case "Terminology":
                fg2 = TermFragment.newInstance();
                break;
            case "Unique Techniques":
                fg2 = UniqueFragment.newInstance();
                break;
            case "Staying Healthy":
                fg2 = HealthyFragment.newInstance();
                break;
            default:
                fg2 = HealthyFragment.newInstance();
        }
        if (!fg.equals(fg2)) {
            fg = fg2;
            fragmentManager.beginTransaction().replace(R.id.fragmentLayout, fg).commit();
        }
    }

    private void sendToast() {
        if (Preferences.showToast(this)) {
            Toast.makeText(getApplicationContext(), "Don't forget to stretch and take breaks! You " +
                            "don't want to have to go" +
                            " to the doctor.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void addFragment() {
        switch (Preferences.defaultListItem(this)) {
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
        fragmentManager.beginTransaction().add(R.id.fragmentLayout, fg).commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (bp != null)
            bp.release();
    }

    private void init() {
        SharedPreferences sharedPref = getSharedPreferences(PRIVATE_PREF, Context.MODE_PRIVATE);
        int currentVersionNumber = 0;
        int savedVersionNumber = sharedPref.getInt(VERSION_KEY, 0);

        try {
            PackageInfo pi = getPackageManager().getPackageInfo(getPackageName(), 0);
            currentVersionNumber = pi.versionCode;
        } catch (Exception ignored) {
        }

        if (currentVersionNumber > savedVersionNumber) {
            showWhatsNewDialog();

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(VERSION_KEY, currentVersionNumber);
            editor.apply();
        }
    }

    private void prepareAdmob() {
        UserSettings userSettings = Appodeal.getUserSettings(this);
        userSettings.setGender(UserSettings.Gender.MALE);
        userSettings.setInterests("games, movies, shows, esports");
        userSettings.setAge(17);
        userSettings.setOccupation(UserSettings.Occupation.SCHOOL);
        userSettings.setAlcohol(UserSettings.Alcohol.NEGATIVE);
        userSettings.setSmoking(UserSettings.Smoking.NEGATIVE);

        Appodeal.disableLocationPermissionCheck();
        Appodeal.disableWriteExternalStoragePermissionCheck();
        Appodeal.setBannerViewId(R.id.adView);
        Appodeal.disableNetwork(this, "cheetah");
        Appodeal.disableNetwork(this, "mailru");
        Appodeal.initialize(this, getResources().getString(R.string.appodeal_id), Appodeal.BANNER);

    }

    private void showWhatsNewDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);

        View view = inflater.inflate(R.layout.dialog_whatsnew, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(view).setTitle("Whats New")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {
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
                        if (menuItem != null) {
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