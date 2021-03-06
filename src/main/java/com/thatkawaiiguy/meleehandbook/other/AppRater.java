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

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

public class AppRater {
    private final static String APP_TITLE = "Handbook for Melee";// App Name
    private final static String APP_PNAME = "com.thatkawaiiguy.meleehandbook";// Package Name

    private final static int DAYS_UNTIL_PROMPT = 7;//Min number of days
    private final static int LAUNCHES_UNTIL_PROMPT = 10;//Min number of launches

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if(prefs.getBoolean("dontshowagain", false)) { return; }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if(date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if(launch_count % LAUNCHES_UNTIL_PROMPT == 0) {
            if(System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                onCreateDialog(mContext, editor);
            }
        }

        editor.apply();
    }

    private static void onCreateDialog(final Context mContext, final SharedPreferences.Editor
            editor) {
        new AlertDialog.Builder(mContext)
            .setTitle("Rate " + APP_TITLE)
            .setMessage("If " + APP_TITLE + " is helping you out, please take a moment to " +
                    "rate " +
                    "it. Thanks for your support!")
            .setPositiveButton("Rate", (DialogInterface dialog, int which) -> {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("market://details?id=" + APP_PNAME)));
                if(editor != null)
                    editor.putBoolean("dontshowagain", true).commit();
                dialog.dismiss();
            })
            .setNeutralButton("Later", (DialogInterface dialog, int which) -> dialog.dismiss())
            .setNegativeButton("Never", (DialogInterface dialog, int which) -> {
                if(editor != null)
                    editor.putBoolean("dontshowagain", true).commit();
                dialog.dismiss();
            }).show();
    }
}