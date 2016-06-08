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

    public static boolean showExitDialog(Context context){
        return exitDialogEnabled(context);
    }

    public static String getMainChar(Context context){
        return getMain(context);
    }

    private static String getDefaultListItem(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_default), context.getString(R.string
                        .title_advancedtech));
    }

    public static String defaultListItem(Context context){
        return getDefaultListItem(context);
    }

    public static boolean openNavLaunchEnabled(Context context){
        return openNavLaunch(context);
    }

    public static boolean showToast(Context context){
        return toast(context);
    }

    public static boolean sortByTierEnabled(Context context){
        return sortByTier(context);
    }

    public static boolean groupByCharacterEnabled(Context context){
        return groupByCharacter(context);
    }

    public static String getTextSize(Context context){
        return textSize(context);
    }

    //public static boolean hideAds(Context context){
    //    return hideAdsEnabled(context);
    //}

    private static boolean exitDialogEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_exit), false);
    }

    private static String getMain(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_main), "");
    }

    //private static boolean hideAdsEnabled(Context context) {
    //    return PreferenceManager.getDefaultSharedPreferences(context)
    //            .getBoolean(context.getString(R.string.pref_ads), false);
    //}

    public static void setHideAds(Context context, boolean hide) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean
                (context.getString(R.string.pref_ads), hide).apply();
    }

    public static boolean hideAds(Context context) {
        return !PreferenceManager.getDefaultSharedPreferences(context).getBoolean
                (context.getString(R.string.pref_ads), false);
    }

    private static boolean openNavLaunch(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_open), false);
    }

    private static boolean toast(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_toast), false);
    }

    private static boolean sortByTier(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_tier), false);
    }

    private static String textSize(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.pref_textsize), "14");
    }

    private static boolean groupByCharacter(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(context.getString(R.string.pref_uniquegroup), true);
    }
}