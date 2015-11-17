package com.thatkawaiiguy.meleehandbook.other;

import android.content.Context;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.ContextThemeWrapper;

import com.thatkawaiiguy.meleehandbook.R;

import java.util.Map;

public class Preferences {

    public static void sync(PreferenceManager preferenceManager) {
        Map<String, ?> map = preferenceManager.getSharedPreferences().getAll();
        for (String key : map.keySet())
            sync(preferenceManager, key);
    }

    public static void sync(PreferenceManager preferenceManager, String key) {
        Preference pref = preferenceManager.findPreference(key);
        if (pref instanceof ListPreference) {
            ListPreference listPref = (ListPreference) pref;
            pref.setSummary(listPref.getEntry());
        }
    }

    public static void applyTheme(ContextThemeWrapper contextThemeWrapper) {
        if (Preferences.darkThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme);
        else if(Preferences.blackThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme_Black);
        else if(Preferences.lightThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme_Light);
        else if(Preferences.blackActionBarThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme_Black_Color);
    }

    public static void applySettingsTheme(ContextThemeWrapper contextThemeWrapper) {
        if (Preferences.darkThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme_Settings);
        else if(Preferences.blackThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme_Black_Settings);
        else if(Preferences.lightThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme_Light_Settings);
        else if(Preferences.blackActionBarThemeEnabled(contextThemeWrapper))
            contextThemeWrapper.setTheme(R.style.AppTheme_Black_Color_Settings);
        else
            contextThemeWrapper.setTheme(R.style.AppTheme_Settings);
    }

    private static boolean darkThemeEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_theme),
                        context.getString(R.string.pref_theme_value_light))
                .equals(context.getString(R.string.pref_theme_value_dark));
    }

    private static boolean blackThemeEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_theme),
                        context.getString(R.string.pref_theme_value_dark))
                .equals(context.getString(R.string.pref_theme_value_black));
    }

    private static boolean blackActionBarThemeEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_theme),
                        context.getString(R.string.pref_theme_value_black))
                .equals(context.getString(R.string.pref_theme_value_blackactionbar));
    }

    private static boolean lightThemeEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_theme),
                        context.getString(R.string.pref_theme_value_dark))
                .equals(context.getString(R.string.pref_theme_value_light));
    }

    public static boolean hideAds(Context context){
        return hideAdsEnabled(context);
    }

    public static boolean showExitDialog(Context context){
        return exitDialogEnabled(context);
    }

    private static String getDefaultListItem(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_default), context.getString(R.string
                        .title_advancedtech));
    }

    public static String defaultListItem(Context context){
        return getDefaultListItem(context);
    }

    public static boolean sortByTierEnabled(Context context){
        return sortByTier(context);
    }

    private static boolean hideAdsEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_ads), false);
    }

    private static boolean exitDialogEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_exit), false);
    }

    private static boolean sortByTier(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_tier), false);
    }
}