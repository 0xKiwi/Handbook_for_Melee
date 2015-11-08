package com.thatkawaiiguy.meleehandbook.other;

import android.content.Context;
import android.content.Intent;

import com.thatkawaiiguy.meleehandbook.activity.CharacterActivity;
import com.thatkawaiiguy.meleehandbook.activity.CharacterFrameActivity;
import com.thatkawaiiguy.meleehandbook.activity.FunActivity;
import com.thatkawaiiguy.meleehandbook.activity.StageActivity;
import com.thatkawaiiguy.meleehandbook.activity.TechActivity;
import com.thatkawaiiguy.meleehandbook.activity.TechTabActivity;
import com.thatkawaiiguy.meleehandbook.activity.UniqueTechActivity;

/**
 * Created by thatkawaiiguy on 10/1/15.
 */
public class SearchActivitySelector {

    public static Intent selectUniqueActivity(String query, Context context) {
        String[] uniqueTechs = ArrayHelper.getLCUniqueArray();

        for (int i = 0; i < uniqueTechs.length; i++) {
            if (uniqueTechs[i].contains(query)) {
                if (uniqueTechs[i].equals("super wavedash & sdwd") ||
                        uniqueTechs[i].equals("extended & homing grapple"))
                    return new Intent(context, TechTabActivity.class).putExtra("option", ArrayHelper.getUniqueArray()[i]);
                else
                    return new Intent(context, UniqueTechActivity.class).putExtra("option", ArrayHelper.getUniqueArray()[i]);
            }
        }

        return null;
    }

    public static Intent selectTechActivity(String query, Context context) {
        String[] techs = ArrayHelper.getLCTechArray();

        for (int i = 0; i < techs.length; i++) {
            if (techs[i].contains(query) && !"fox".contains(query)) {
                if (techs[i].equals("wall jump") || query.equals("directional influence"))
                    return new Intent(context, TechTabActivity.class).putExtra("option", ArrayHelper.getTechArray()[i]);
                else
                    return new Intent(context, TechActivity.class).putExtra("option", ArrayHelper.getTechArray()[i]);
            }
        }
        return null;
    }

    public static Intent selectCharacterActivity(String query, Context context) {
        String[] characters = ArrayHelper.getLCCharacterArray();

        for (int i = 0; i < characters.length; i++) {
            if (characters[i].contains(query)) {
                if("falco".contains(query))
                    return new Intent(context, CharacterFrameActivity.class).putExtra("character", "Falco");
                else if (characters[i].equals("sheik") || characters[i].equals("fox") || characters[i].equals("marth")
                        || characters[i].equals("captain falcon")) {
                    return new Intent(context, CharacterFrameActivity.class).putExtra("option", ArrayHelper.getCharacterArray()[i]);
                } else
                    return new Intent(context, CharacterActivity.class).putExtra("option", ArrayHelper.getCharacterArray()[i]);
            }
        }
        return null;
    }

    public static Intent selectFunActivity(String query, Context context) {
        String[] funs = ArrayHelper.getLCFunArray();

        for (int i = 0; i < funs.length; i++) {
            if (funs[i].contains(query))
                return new Intent(context, FunActivity.class).putExtra("option", ArrayHelper.getFunArray()[i]);
        }
        return null;
    }

    public static Intent selectMapActivity(String query, Context context) {
        String[] maps = ArrayHelper.getLCMapArray();

        for (int i = 0; i < maps.length; i++) {
            if (maps[i].contains(query) && !"yoshi".contains(query))
                return new Intent(context, StageActivity.class).putExtra("option", ArrayHelper.getMapArray()[i]);
        }
        return null;
    }
}
