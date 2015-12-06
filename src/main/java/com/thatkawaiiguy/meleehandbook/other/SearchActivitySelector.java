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
        String[] uniqueTechs = ArrayHelper.getUniqueArray();

        for(String uniqueTech : uniqueTechs) {
            if(uniqueTech.toLowerCase().contains(query)) {
                if(uniqueTech.toLowerCase().equals("super wavedash & sdwd") ||
                        uniqueTech.toLowerCase().equals("extended & homing grapple"))
                    return new Intent(context, TechTabActivity.class).putExtra("option",
                            uniqueTech);
                else
                    return new Intent(context, UniqueTechActivity.class).putExtra("option",
                            uniqueTech);
            }
        }

        return null;
    }

    public static Intent selectTechActivity(String query, Context context) {
        String[] techs = ArrayHelper.getTechArray();

        for(String tech : techs) {
            if(tech.toLowerCase().contains(query) && !"fox".contains(query)) {
                if(tech.equals("Wall jump") || tech.equals("Directional Influence"))
                    return new Intent(context, TechTabActivity.class).putExtra("option", tech);
                else
                    return new Intent(context, TechActivity.class).putExtra("option", tech);
            }
        }
        return null;
    }

    public static Intent selectCharacterActivity(String query, Context context) {
        String[] characters = ArrayHelper.getCharacterArray(context);

        boolean hasFrame;

        for(String character : characters) {
            if(character.toLowerCase().contains(query)) {
                switch(character) {
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
                    case "Princess Peach":
                        hasFrame = true;
                        break;
                    default:
                        hasFrame = false;
                        break;
                }
                if("falco".contains(query))
                    return new Intent(context, CharacterFrameActivity.class).putExtra
                            ("option", "Falco");
                else if(hasFrame) {
                    return new Intent(context, CharacterFrameActivity.class).putExtra("option",
                            character);
                } else
                    return new Intent(context, CharacterActivity.class).putExtra("option",
                            character);
            }
        }
        return null;
    }

    public static Intent selectFunActivity(String query, Context context) {
        String[] funs = ArrayHelper.getFunArray();

        for(String fun : funs) {
            if(fun.toLowerCase().contains(query))
                return new Intent(context, FunActivity.class).putExtra("option", fun);
        }
        return null;
    }

    public static Intent selectMapActivity(String query, Context context) {
        String[] maps = ArrayHelper.getMapArray();

        for(String map : maps) {
            if(map.toLowerCase().contains(query) && !"yoshi".contains(query))
                return new Intent(context, StageActivity.class).putExtra("option", map);
        }
        return null;
    }

}
