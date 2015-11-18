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

public class SearchActivitySelector {

    public static Intent selectUniqueActivity(String query, Context context) {
        String[] uniqueTechs = ArrayHelper.getLCUniqueArray();

        for(int i = 0; i < uniqueTechs.length; i++) {
            if(uniqueTechs[i].contains(query)) {
                if(uniqueTechs[i].equals("super wavedash & sdwd") ||
                        uniqueTechs[i].equals("extended & homing grapple"))
                    return new Intent(context, TechTabActivity.class).putExtra("option",
                            ArrayHelper.getUniqueArray()[i]);
                else
                    return new Intent(context, UniqueTechActivity.class).putExtra("option",
                            ArrayHelper.getUniqueArray()[i]);
            }
        }

        return null;
    }

    public static Intent selectTechActivity(String query, Context context) {
        String[] techs = ArrayHelper.getLCTechArray();

        for(int i = 0; i < techs.length; i++) {
            if(techs[i].contains(query) && !"fox".contains(query)) {
                if(techs[i].equals("wall jump") || query.equals("directional influence"))
                    return new Intent(context, TechTabActivity.class).putExtra("option",
                            ArrayHelper.getTechArray()[i]);
                else
                    return new Intent(context, TechActivity.class).putExtra("option", ArrayHelper
                            .getTechArray()[i]);
            }
        }
        return null;
    }

    public static Intent selectCharacterActivity(String query, Context context) {
        String[] characters = ArrayHelper.getLCCharacterArray(context);

        boolean hasFrame;

        for(int i = 0; i < characters.length; i++) {
            if(characters[i].contains(query)) {
                switch(characters[i]) {
                    case "Captain Falcon":
                        hasFrame = true;
                        break;
                    case "Ganondorf":
                        hasFrame = true;
                        break;
                    case "Falco":
                        hasFrame = true;
                        break;
                    case "Fox":
                        hasFrame = true;
                        break;
                    case "Ice Climbers":
                        hasFrame = true;
                        break;
                    case "Jigglypuff":
                        hasFrame = true;
                        break;
                    case "Marth":
                        hasFrame = true;
                        break;
                    case "Pikachu":
                        hasFrame = true;
                        break;
                    case "Samus Aran":
                        hasFrame = true;
                        break;
                    case "Sheik":
                        hasFrame = true;
                        break;
                    case "Yoshi":
                        hasFrame = true;
                        break;
                    case "Dr. Mario":
                        hasFrame = true;
                        break;
                    default:
                        hasFrame = false;
                        break;
                }
                if("falco".contains(query))
                    return new Intent(context, CharacterFrameActivity.class).putExtra
                            ("character", "Falco");
                else if(hasFrame) {
                    return new Intent(context, CharacterFrameActivity.class).putExtra("option",
                            ArrayHelper.getCharacterArray(context)[i]);
                } else
                    return new Intent(context, CharacterActivity.class).putExtra("option",
                            ArrayHelper.getCharacterArray(context)[i]);
            }
        }
        return null;
    }

    public static Intent selectFunActivity(String query, Context context) {
        String[] funs = ArrayHelper.getLCFunArray();

        for(int i = 0; i < funs.length; i++) {
            if(funs[i].contains(query))
                return new Intent(context, FunActivity.class).putExtra("option", ArrayHelper
                        .getFunArray()[i]);
        }
        return null;
    }

    public static Intent selectMapActivity(String query, Context context) {
        String[] maps = ArrayHelper.getLCMapArray();

        for(int i = 0; i < maps.length; i++) {
            if(maps[i].contains(query) && !"yoshi".contains(query))
                return new Intent(context, StageActivity.class).putExtra("option", ArrayHelper
                        .getMapArray()[i]);
        }
        return null;
    }

}
