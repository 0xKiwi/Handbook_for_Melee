package com.thatkawaiiguy.meleehandbook.other;

import java.util.ArrayList;

/**
 * Created by Ivan Martinez on 12/14/2016.
 */

public class GroupedUniqueTech {
    private ArrayList<String> techs;
    private String character;

    public GroupedUniqueTech(ArrayList<String> techs, String character) {
        this.techs = techs;
        this.character = character;
    }

    public ArrayList<String> getTechs() {
        return techs;
    }

    public void setTechs(ArrayList<String> techs) {
        this.techs = techs;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}

