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

package com.thatkawaiiguy.meleehandbook.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ArrayHelper {

    public static String[] getCharacterArray(Context context, boolean mainFirst) {
        ArrayList<String> chars;
        boolean sortByTier = Preferences.sortByTierEnabled(context);
        if(sortByTier) {
            chars = new ArrayList<>(Arrays.asList(new String[]{"Fox", "Falco", "Marth", "Sheik",
                    "Jigglypuff", "Princess Peach",
                    "Ice Climbers", "Captain Falcon", "Pikachu", "Samus",
                    "Dr. Mario", "Yoshi", "Luigi", "Ganondorf",
                    "Mario", "Young Link", "Donkey Kong", "Link", "Mr. Game & Watch", "Roy",
                    "Mewtwo", "Princess Zelda", "Ness", "Pichu", "Bowser", "Kirby"}));
        } else {
            chars = new ArrayList<>(Arrays.asList(new String[]{"Bowser", "Captain Falcon",
                    "Donkey Kong", "Dr. Mario",
                    "Falco", "Fox", "Ganondorf", "Ice Climbers", "Jigglypuff", "Kirby", "Link",
                    "Luigi", "Mario", "Marth", "Mewtwo", "Mr. Game & Watch", "Ness", "Pichu",
                    "Pikachu", "Princess Peach", "Princess Zelda", "Roy", "Samus", "Sheik",
                    "Yoshi", "Young Link"}));
        }

        if(mainFirst) {
            String main = Preferences.getMainChar(context);
            if(!main.equals("") && !main.equals("None")) {
                chars.remove(main);
                chars.add(0, main);
            }
        }

        return chars.toArray(new String[chars.size()]);
    }

    @NonNull
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static XmlResourceParser getEngXML(Context context, int id) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale("en"));
        return context.createConfigurationContext(configuration).getResources().getXml(id);
    }

    public static String[] getUniqueTechCharArray(Context context) {
        ArrayList<String> chars;
        boolean sortByTier = Preferences.sortByTierEnabled(context);
        if(sortByTier) {
            chars = new ArrayList<>(Arrays.asList(new String[]{"Fox", "Falco", "Marth",
                    "Sheik", "Jigglypuff", "Princess Peach",
                    "Ice Climbers", "Captain Falcon", "Pikachu", "Samus",
                    "Dr. Mario", "Yoshi", "Luigi", "Ganondorf",
                    "Mario", "Young Link", "Link", "Roy",
                    "Mewtwo", "Princess Zelda", "Ness", "Pichu",}));
        } else {
            chars = new ArrayList<>(Arrays.asList(new String[]{"Captain Falcon", "Dr. Mario",
                    "Falco", "Fox", "Ganondorf", "Ice Climbers", "Jigglypuff", "Link",
                    "Luigi", "Mario", "Marth", "Mewtwo", "Ness", "Pichu",
                    "Pikachu", "Princess Peach", "Princess Zelda", "Roy", "Samus", "Sheik",
                    "Yoshi", "Young Link"}));
        }

        String main = Preferences.getMainChar(context);
        if(!main.equals("") || !main.equals("None")) {
            if(chars.contains(main)) {
                chars.remove(main);
                chars.add(0, main);
            }
        }

        return chars.toArray(new String[chars.size()]);
    }

    public static String[] getMapArray() {
        return new String[]{"Battlefield", "Dream Land", "Final Destination",
                "Fountain of Dreams", "Kongo Jungle (SSB)", "Pokemon Stadium", "Yoshi's Story"};
    }

    public static String getFileName(String title){
        return title.toLowerCase().trim().replace(" ","").replace("-","").replace("/","")
                .replace("&", "").replace("'","").replace(".","").replace("(","").replace(")","").replace("-","");
    }

    public static boolean hasFrame(String character, Resources resources){
        ArrayList<String> filelist = new ArrayList<>();
        try {
            filelist = new ArrayList<>(Arrays.asList(resources.getAssets().list(getFileName(character))));
        } catch(IOException e) {
        }

        return filelist.size() > 0;
    }
}