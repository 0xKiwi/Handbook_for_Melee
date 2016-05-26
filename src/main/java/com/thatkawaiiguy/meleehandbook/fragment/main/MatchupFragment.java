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

package com.thatkawaiiguy.meleehandbook.fragment.main;

import android.app.Fragment;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

import java.io.IOException;

public class MatchupFragment extends Fragment {

    private View leftView;
    private View rightView;

    private Spinner spinnerLeft;
    private Spinner spinnerRight;

    private TextView infoLeft;
    private TextView infoRight;

    private ImageButton muImgLeft;
    private ImageButton muImgRight;

    private Button shineBottom;
    private Button shineTop;

    private String characterLeft = "";
    private String characterRight = "";

    public static MatchupFragment newInstance() {
        Bundle args = new Bundle();
        MatchupFragment fragment = new MatchupFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.matchup_layout, container, false);

        leftView = view.findViewById(R.id.viewleft);
        rightView = view.findViewById(R.id.viewright);
        infoLeft = (TextView) view.findViewById(R.id.muTextLeft);
        TextView muInfoLeft = (TextView) view.findViewById(R.id.muInfoLeft);
        infoRight = (TextView) view.findViewById(R.id.muTextRight);
        TextView muInfoRight = (TextView) view.findViewById(R.id.muInfoRight);
        spinnerLeft = (Spinner) view.findViewById(R.id.spinnerLeft);
        spinnerRight = (Spinner) view.findViewById(R.id.spinnerRight);
        muImgRight = (ImageButton) view.findViewById(R.id.muImgRight);
        muImgLeft = (ImageButton) view.findViewById(R.id.muImgLeft);
        shineBottom = (Button) view.findViewById(R.id.shineTextBottom);
        shineTop = (Button) view.findViewById(R.id.shineTextTop);

        final MediaPlayer mp = new MediaPlayer();
        final MediaPlayer mp2 = new MediaPlayer();
        shineTop.setOnTouchListener(new View.OnTouchListener() {
                                        @Override
                                        public boolean onTouch(View v, MotionEvent event) {
                                            if(characterLeft.equals(characterRight) &&
                                                    characterLeft.equals("Fox")) {
                                                try {
                                                    mp.reset();
                                                    AssetFileDescriptor afd;
                                                    afd = getResources().getAssets().openFd
                                                            ("shine.wav");
                                                    mp.setDataSource(afd.getFileDescriptor(), afd
                                                            .getStartOffset(), afd.getLength());
                                                    mp.prepare();
                                                    mp.start();
                                                } catch(IllegalStateException | IOException e) {
                                                    e.printStackTrace();
                                                }
                                                return true;
                                            }
                                            return false;
                                        }
                                    }
        );
        shineBottom.setOnTouchListener(new View.OnTouchListener() {
                                           @Override
                                           public boolean onTouch(View v, MotionEvent event) {
                                               if(characterLeft.equals(characterRight) &&
                                                       characterLeft.equals("Fox")) {
                                                   try {
                                                       mp2.reset();
                                                       AssetFileDescriptor afd;
                                                       afd = getResources().getAssets().openFd
                                                               ("shine.wav");
                                                       mp2.setDataSource(afd.getFileDescriptor(),
                                                               afd.getStartOffset(), afd
                                                                       .getLength());
                                                       mp2.prepare();
                                                       mp2.start();
                                                   } catch(IllegalStateException | IOException e) {
                                                       e.printStackTrace();
                                                   }
                                                   return true;
                                               }
                                               return false;
                                           }
                                       }
        );

        setMatchupsView();
        return view;
    }

    private String getRightPercent(String left, String right) {
        if(left.equals(right))
            return "Mirror";
        return getLeftPercent(right, left);
    }

    private String getLeftPercent(String left, String right) {
        switch(left) {
            case "Fox": {
                switch(right) {
                    case "Fox":
                        return "Mirror";
                    case "Falco":
                        return "50";
                    case "Sheik":
                        return "60";
                    case "Marth":
                        return "50";
                    case "Princess Peach":
                        return "60";
                    case "Captain Falcon":
                        return "65";
                    case "Ice Climbers":
                        return "65";
                    case "Samus Aran":
                        return "50";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "63";
                    case "Mario":
                        return "60";
                    case "Ganondorf":
                        return "60";
                    case "Link":
                        return "80";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "70";
                    case "Young Link":
                        return "70";
                    case "Pikachu":
                        return "60";
                    case "Yoshi":
                        return "60";
                    case "Princess Zelda":
                        return "80";
                    case "Mr. Game & Watch":
                        return "80";
                    case "Ness":
                        return "80";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "80";
                    case "Pichu":
                        return "80";
                    case "Mewtwo":
                        return "80";
                }
            }
            break;
            case "Falco": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return "Mirror";
                    case "Sheik":
                        return "55";
                    case "Marth":
                        return "50";
                    case "Princess Peach":
                        return "50";
                    case "Captain Falcon":
                        return "60";
                    case "Ice Climbers":
                        return "50";
                    case "Samus Aran":
                        return "55";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "50";
                    case "Mario":
                        return "60";
                    case "Ganondorf":
                        return "70";
                    case "Link":
                        return "60";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "70";
                    case "Young Link":
                        return "70";
                    case "Pikachu":
                        return "60";
                    case "Yoshi":
                        return "60";
                    case "Princess Zelda":
                        return "90";
                    case "Mr. Game & Watch":
                        return "90";
                    case "Ness":
                        return "90";
                    case "Bowser":
                        return "90";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "80";
                }
            }
            break;
            case "Sheik": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return "Mirror";
                    case "Marth":
                        return "50";
                    case "Princess Peach":
                        return "55";
                    case "Captain Falcon":
                        return "60";
                    case "Ice Climbers":
                        return "45";
                    case "Samus Aran":
                        return "60";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "50";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "70";
                    case "Link":
                        return "65";
                    case "Luigi":
                        return "65";
                    case "Donkey Kong":
                        return "80";
                    case "Roy":
                        return "90";
                    case "Young Link":
                        return "80";
                    case "Pikachu":
                        return "60";
                    case "Yoshi":
                        return "60";
                    case "Princess Zelda":
                        return "80";
                    case "Mr. Game & Watch":
                        return "90";
                    case "Ness":
                        return "80";
                    case "Bowser":
                        return "90";
                    case "Kirby":
                        return "75";
                    case "Pichu":
                        return "80";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Marth": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return "Mirror";
                    case "Princess Peach":
                        return "60";
                    case "Captain Falcon":
                        return "50";
                    case "Ice Climbers":
                        return "60";
                    case "Samus Aran":
                        return "60";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "50";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "60";
                    case "Link":
                        return "55";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "60";
                    case "Roy":
                        return "70";
                    case "Young Link":
                        return "60";
                    case "Pikachu":
                        return "40";
                    case "Yoshi":
                        return "60";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "90";
                    case "Ness":
                        return "70";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "90";
                    case "Pichu":
                        return "90";
                    case "Mewtwo":
                        return "80";
                }
            }
            break;
            case "Princess Peach": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return "Mirror";
                    case "Captain Falcon":
                        return "45";
                    case "Ice Climbers":
                        return "70";
                    case "Samus Aran":
                        return "60";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "40";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "60";
                    case "Link":
                        return "40";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "40";
                    case "Pikachu":
                        return "65";
                    case "Yoshi":
                        return "65";
                    case "Princess Zelda":
                        return "80";
                    case "Mr. Game & Watch":
                        return "70";
                    case "Ness":
                        return "70";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "80";
                    case "Pichu":
                        return "90";
                    case "Mewtwo":
                        return "70";
                }
            }
            break;
            case "Captain Falcon": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return "Mirror";
                    case "Ice Climbers":
                        return "60";
                    case "Samus Aran":
                        return "60";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "50";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "60";
                    case "Link":
                        return "80";
                    case "Luigi":
                        return "55";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "70";
                    case "Pikachu":
                        return "60";
                    case "Yoshi":
                        return "60";
                    case "Princess Zelda":
                        return "80";
                    case "Mr. Game & Watch":
                        return "70";
                    case "Ness":
                        return "70";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "80";
                    case "Pichu":
                        return "90";
                    case "Mewtwo":
                        return "70";
                }
            }
            break;
            case "Ice Climbers": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return "Mirror";
                    case "Samus Aran":
                        return "45";
                    case "Dr. Mario":
                        return "50";
                    case "Jigglypuff":
                        return "50";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "50";
                    case "Link":
                        return "45";
                    case "Luigi":
                        return "50";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "90";
                    case "Young Link":
                        return "65";
                    case "Pikachu":
                        return "70";
                    case "Yoshi":
                        return "45";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "60";
                    case "Ness":
                        return "60";
                    case "Bowser":
                        return "90";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "90";
                    case "Mewtwo":
                        return "80";
                }
            }
            break;
            case "Samus Aran": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return "Mirror";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "40";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "40";
                    case "Link":
                        return "55";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "80";
                    case "Young Link":
                        return "70";
                    case "Pikachu":
                        return "60";
                    case "Yoshi":
                        return "70";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "70";
                    case "Ness":
                        return "60";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "80";
                    case "Pichu":
                        return "80";
                    case "Mewtwo":
                        return "70";
                }
            }
            break;
            case "Dr. Mario": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return "Mirror";
                    case "Jigglypuff":
                        return "50";
                    case "Mario":
                        return "60";
                    case "Ganondorf":
                        return "50";
                    case "Link":
                        return "55";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "60";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "50";
                    case "Pikachu":
                        return "60";
                    case "Yoshi":
                        return "70";
                    case "Princess Zelda":
                        return "55";
                    case "Mr. Game & Watch":
                        return "70";
                    case "Ness":
                        return "60";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "80";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Jigglypuff": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return "Mirror";
                    case "Mario":
                        return "60";
                    case "Ganondorf":
                        return "45";
                    case "Link":
                        return "50";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "60";
                    case "Pikachu":
                        return "60";
                    case "Yoshi":
                        return "70";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "60";
                    case "Ness":
                        return "90";
                    case "Bowser":
                        return "90";
                    case "Kirby":
                        return "80";
                    case "Pichu":
                        return "60";
                    case "Mewtwo":
                        return "80";
                }
            }
            break;
            case "Mario": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return "Mirror";
                    case "Ganondorf":
                        return "50";
                    case "Link":
                        return "55";
                    case "Luigi":
                        return "60";
                    case "Donkey Kong":
                        return "60";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "60";
                    case "Pikachu":
                        return "40";
                    case "Yoshi":
                        return "60";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "70";
                    case "Ness":
                        return "50";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "90";
                    case "Mewtwo":
                        return "80";
                }
            }
            break;
            case "Ganondorf": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return "Mirror";
                    case "Link":
                        return "50";
                    case "Luigi":
                        return "50";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "60";
                    case "Pikachu":
                        return "50";
                    case "Yoshi":
                        return "70";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "60";
                    case "Ness":
                        return "90";
                    case "Bowser":
                        return "90";
                    case "Kirby":
                        return "80";
                    case "Pichu":
                        return "60";
                    case "Mewtwo":
                        return "80";
                }
            }
            break;
            case "Link": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return "Mirror";
                    case "Luigi":
                        return "50";
                    case "Donkey Kong":
                        return "60";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "55";
                    case "Pikachu":
                        return "40";
                    case "Yoshi":
                        return "70";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "75";
                    case "Ness":
                        return "60";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "60";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Luigi": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return "Mirror";
                    case "Donkey Kong":
                        return "50";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "45";
                    case "Pikachu":
                        return "50";
                    case "Yoshi":
                        return "50";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "60";
                    case "Ness":
                        return "50";
                    case "Bowser":
                        return "70";
                    case "Kirby":
                        return "60";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Donkey Kong": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return "Mirror";
                    case "Roy":
                        return "40";
                    case "Young Link":
                        return "40";
                    case "Pikachu":
                        return "30";
                    case "Yoshi":
                        return "50";
                    case "Princess Zelda":
                        return "50";
                    case "Mr. Game & Watch":
                        return "55";
                    case "Ness":
                        return "70";
                    case "Bowser":
                        return "70";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Roy": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return "Mirror";
                    case "Young Link":
                        return "40";
                    case "Pikachu":
                        return "40";
                    case "Yoshi":
                        return "30";
                    case "Princess Zelda":
                        return "50";
                    case "Mr. Game & Watch":
                        return "50";
                    case "Ness":
                        return "30";
                    case "Bowser":
                        return "70";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Young Link": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return "Mirror";
                    case "Pikachu":
                        return "50";
                    case "Yoshi":
                        return "55";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "60";
                    case "Ness":
                        return "60";
                    case "Bowser":
                        return "70";
                    case "Kirby":
                        return "60";
                    case "Pichu":
                        return "60";
                    case "Mewtwo":
                        return "40";
                }
            }
            break;
            case "Pikachu": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return "Mirror";
                    case "Yoshi":
                        return "40";
                    case "Princess Zelda":
                        return "65";
                    case "Mr. Game & Watch":
                        return "60";
                    case "Ness":
                        return "70";
                    case "Bowser":
                        return "70";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Yoshi": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return "Mirror";
                    case "Princess Zelda":
                        return "50";
                    case "Mr. Game & Watch":
                        return "50";
                    case "Ness":
                        return "20";
                    case "Bowser":
                        return "70";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Princess Zelda": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Zelda":
                        return "Mirror";
                    case "Mr. Game & Watch":
                        return "50";
                    case "Ness":
                        return "30";
                    case "Bowser":
                        return "70";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "70";
                    case "Mewtwo":
                        return "60";
                }
            }
            break;
            case "Mr. Game & Watch": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Zelda":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mr. Game & Watch":
                        return "Mirror";
                    case "Ness":
                        return "20";
                    case "Bowser":
                        return "80";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "60";
                    case "Mewtwo":
                        return "30";
                }
            }
            break;
            case "Ness": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Zelda":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mr. Game & Watch":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ness":
                        return "Mirror";
                    case "Bowser":
                        return "60";
                    case "Kirby":
                        return "60";
                    case "Pichu":
                        return "80";
                    case "Mewtwo":
                        return "40";
                }
            }
            break;
            case "Bowser": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Zelda":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mr. Game & Watch":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ness":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Bowser":
                        return "Mirror";
                    case "Kirby":
                        return "70";
                    case "Pichu":
                        return "60";
                    case "Mewtwo":
                        return "20";
                }
            }
            break;
            case "Kirby": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Zelda":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mr. Game & Watch":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ness":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Bowser":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Kirby":
                        return "Mirror";
                    case "Pichu":
                        return "40";
                    case "Mewtwo":
                        return "30";
                }
            }
            break;
            case "Pichu": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Zelda":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mr. Game & Watch":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ness":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Bowser":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Kirby":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pichu":
                        return "Mirror";
                    case "Mewtwo":
                        return "30";
                }
            }
            break;
            case "Mewtwo": {
                switch(right) {
                    case "Fox":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Falco":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Sheik":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Marth":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Peach":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Captain Falcon":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ice Climbers":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Samus Aran":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Dr. Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Jigglypuff":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mario":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ganondorf":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Luigi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Donkey Kong":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Roy":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Young Link":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pikachu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Yoshi":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Princess Zelda":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mr. Game & Watch":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Ness":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Bowser":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Kirby":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Pichu":
                        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(right,
                                left)) - 100));
                    case "Mewtwo":
                        return "Mirror";
                }
            }
            break;
        }
        return "uhh";
    }
/*
    private String getInfo(String left, String right) {
        switch(left) {
            case "Fox": {
                switch(right) {
                    case "Falco":
                        return "Better recovery and amaazing neutral";
                    case "Sheik":
                        return "Strong attacks, punish game";
                    case "Marth":
                        return "Combo ability, strong attacks";
                    case "Princess Peach":
                        return "Strong attacks";
                    case "Captain Falcon":
                        return "Combo and gimping ability";
                    case "Ice Climbers":
                        return "Combo and gimping ability";
                    case "Samus Aran":
                        return "Strong attacks";
                    case "Dr. Mario":
                        return "Strong attacks, easy ledge guard";
                    case "Jigglypuff":
                        return "Strong attacks";
                    case "Ganondorf":
                        return "Fast faller";
                    case "Pikachu":
                        return "Strong attacks";
                }
            }
            break;
            case "Falco": {
                switch(right) {
                    case "Fox":
                        return "Stopping power, but poor recovery";
                    case "Sheik":
                        return "Long tech roll and punish game";
                    case "Marth":
                        return "Stopping power, but poor recovery";
                    case "Princess Peach":
                        return "Strong attacks, but poor recovery";
                    case "Captain Falcon":
                        return "Stopping power, dair priority";
                    case "Ice Climbers":
                        return "Easily chaingrabbed";
                    case "Samus Aran":
                        return "Stopping power";
                    case "Dr. Mario":
                        return "Strong attacks, easy ledge guard";
                    case "Jigglypuff":
                        return "Strong attacks, but easily rested";
                    case "Ganondorf":
                        return "Fast faller";
                    case "Pikachu":
                        return "Strong attacks";
                }
            }
            break;
            case "Sheik": {
                switch(right) {
                    case "Fox":
                        return "Tech chase and gimping ability";
                    case "Falco":
                        return "Gimp ability";
                    case "Sheik":
                        return "Good punish, needles";
                    case "Marth":
                        return "Lightweight";
                    case "Princess Peach":
                        return "Stopping power";
                    case "Captain Falcon":
                        return "Gimping ability";
                    case "Ice Climbers":
                        return "Trouble separating, hard to camp";
                    case "Samus Aran":
                        return "Floaty";
                    case "Dr. Mario":
                        return "Strong attacks, easy ledge guard";
                    case "Jigglypuff":
                        return "Lightweight";
                    case "Ganondorf":
                        return "Lightweight";
                    case "Pikachu":
                        return "Can tech chase";
                }
            }
            break;
            case "Marth": {
                switch(right) {
                    case "Fox":
                        return "Can gimp";
                    case "Falco":
                        return "Can gimp";
                    case "Sheik":
                        return "Strong attacks";
                    case "Princess Peach":
                        return "Priority";
                    case "Captain Falcon":
                        return "Priority";
                    case "Ice Climbers":
                        return "Strong attacks";
                    case "Samus Aran":
                        return "Priority, edge guard";
                    case "Dr. Mario":
                        return "Strong attacks, easy ledge guard";
                    case "Jigglypuff":
                        return "Can space well";
                    case "Ganondorf":
                        return "Priority";
                    case "Pikachu":
                        return "Hard to edgeguard";
                }
            }
            break;
            case "Princess Peach": {
                switch(right) {
                    case "Fox":
                        return "Can be gimped";
                    case "Falco":
                        return "Easily gimps";
                    case "Sheik":
                        return "Easily comboed";
                    case "Marth":
                        return "Outranged";
                    case "Captain Falcon":
                        return "Lightweight";
                    case "Ice Climbers":
                        return "Can edgeguard";
                    case "Samus Aran":
                        return "Can gimp";
                    case "Dr. Mario":
                        return "Can gimp";
                    case "Jigglypuff":
                        return "Lightweight";
                    case "Ganondorf":
                        return "Lightweight";
                    case "Pikachu":
                        return "Aerial game";
                }
            }
            break;
            case "Captain Falcon": {
                switch(right) {
                    case "Fox":
                        return "Poor recovery";
                    case "Falco":
                        return "Poor recovery";
                    case "Sheik":
                        return "Poor recovery";
                    case "Marth":
                        return "Strong punish";
                    case "Princess Peach":
                        return "Trouble edgeguarding";
                    case "Ice Climbers":
                        return "Trouble separating";
                    case "Samus Aran":
                        return "Strong attacks";
                    case "Dr. Mario":
                        return "Strong attacks";
                    case "Jigglypuff":
                        return "Strong punish";
                    case "Ganondorf":
                        return "Slightly faster";
                    case "Pikachu":
                        return "Strong attacks";
                }
            }
            break;
            case "Ice Climbers": {
                switch(right) {
                    case "Fox":
                        return "Can chain grab";
                    case "Falco":
                        return "Can gimp";
                    case "Sheik":
                        return "Easily wobbles";
                    case "Marth":
                        return "Easily separates";
                    case "Princess Peach":
                        return "Easily separates";
                    case "Captain Falcon":
                        return "Can wobble";
                    case "Samus Aran":
                        return "Easily separated";
                    case "Dr. Mario":
                        return "Strong attacks, easy ledge guard";
                    case "Jigglypuff":
                        return "Strong attacks";
                    case "Ganondorf":
                        return "Easily separated";
                    case "Pikachu":
                        return "Strong attacks";
                }
            }
            break;
            case "Samus Aran": {
                switch(right) {
                    case "Fox":
                        return "Spam power";
                    case "Falco":
                        return "Spam power";
                    case "Sheik":
                        return "Easily comboed";
                    case "Marth":
                        return "Easily comboed";
                    case "Princess Peach":
                        return "Several recovery options";
                    case "Captain Falcon":
                        return "Floaty";
                    case "Ice Climbers":
                        return "Spam power";
                    case "Dr. Mario":
                        return "Spam power";
                    case "Jigglypuff":
                        return "Floaty";
                    case "Ganondorf":
                        return "Lightweight";
                    case "Pikachu":
                        return "Spam power";
                }
            }
            break;
            case "Dr. Mario": {
                switch(right) {
                    case "Fox":
                        return "Can reflect recoveries";
                    case "Falco":
                        return "Can reflect recoveries";
                    case "Sheik":
                        return "Easily comboed";
                    case "Marth":
                        return "Priority";
                    case "Princess Peach":
                        return "Easily gimped";
                    case "Captain Falcon":
                        return "Punish game";
                    case "Ice Climbers":
                        return "Can reflect";
                    case "Samus Aran":
                        return "Can reflect";
                    case "Jigglypuff":
                        return "Strong attacks";
                    case "Ganondorf":
                        return "Lighter weight";
                    case "Pikachu":
                        return "Strong attacks";
                }
            }
            break;
            case "Jigglypuff": {
                switch(right) {
                    case "Fox":
                        return "Floaty";
                    case "Falco":
                        return "Floaty";
                    case "Sheik":
                        return "Floaty";
                    case "Marth":
                        return "Floaty";
                    case "Princess Peach":
                        return "Edgeguards";
                    case "Captain Falcon":
                        return "Floaty";
                    case "Ice Climbers":
                        return "Hard to get grabbed";
                    case "Samus Aran":
                        return "Easy to avoid spam";
                    case "Dr. Mario":
                        return "Strong attacks, easy ledge guard";
                    case "Ganondorf":
                        return "Hard to catch";
                    case "Pikachu":
                        return "Edge guards";
                }
            }
            break;
            case "Ganondorf": {
                switch(right) {
                    case "Fox":
                        return "Predicatable recovery";
                    case "Falco":
                        return "Predicatable recovery";
                    case "Sheik":
                        return "Easily gimped";
                    case "Marth":
                        return "Has reach";
                    case "Princess Peach":
                        return "Strong attacks";
                    case "Captain Falcon":
                        return "Strong attacks";
                    case "Ice Climbers":
                        return "Extremely powerful";
                    case "Samus Aran":
                        return "Powerful";
                    case "Dr. Mario":
                        return "Powerful";
                    case "Jigglypuff":
                        return "Gets edge guarded";
                    case "Pikachu":
                        return "Slow but powerful";
                }
            }
            break;
            case "Pikachu": {
                switch(right) {
                    case "Fox":
                        return "Can chain grab";
                    case "Falco":
                        return "Can chain grab";
                    case "Sheik":
                        return "Weak to grabs";
                    case "Marth":
                        return "Excellent recovery";
                    case "Princess Peach":
                        return "Excellent recovery";
                    case "Captain Falcon":
                        return "Hard to catch";
                    case "Ice Climbers":
                        return "Easily pressured";
                    case "Samus Aran":
                        return "Excellent recovery";
                    case "Dr. Mario":
                        return "Strong attacks, easy ledge guard";
                    case "Jigglypuff":
                        return "Hard to catch";
                    case "Ganondorf":
                        return "Hard to catch";
                }
            }
            break;
        }
        return "";
    }
*/
    private void setMatchupsView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R
                .layout.simple_spinner_item, ArrayHelper.getCharacterArray(getActivity(), false));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLeft.setAdapter(adapter);
        spinnerRight.setAdapter(adapter);

        spinnerLeft.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setMatchupLeft(parent.getItemAtPosition(position).toString());
                createMatchup();
                setMatchupImage(characterLeft, muImgLeft);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        leftView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerLeft.performClick();
            }
        });

        spinnerRight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setMatchupRight(parent.getItemAtPosition(position).toString());
                createMatchup();
                setMatchupImage(characterRight, muImgRight);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        rightView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerRight.performClick();
            }
        });

        muImgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerLeft.performClick();
            }
        });
        muImgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerRight.performClick();
            }
        });

        String main = Preferences.getMainChar(getActivity());
        if(!main.equals("None") && !main.equals("")){
            setMatchupLeft(main);
            spinnerLeft.setSelection(getIndex(spinnerLeft, main));
            setMatchupImage(Preferences.getMainChar(getActivity()), muImgLeft);
            createMatchup();
        }

    }

    private void createMatchup() {
        if(getLeftPercent(characterLeft, characterRight).equals("Mirror")) {
            infoLeft.setText("Mirror");
            infoRight.setText("Mirror");
            if(characterLeft.equals("Fox") && characterRight.equals("Fox"))
                to20XX();
            else
                un20XX();
        } else {
            un20XX();
            //muInfoLeft.setText(getInfo(characterLeft, characterRight));
            infoLeft.setText(getLeftPercent(characterLeft, characterRight) + "%");
            //muInfoRight.setText(getInfo(characterRight, characterLeft));
            infoRight.setText(getRightPercent(characterLeft, characterRight) + "%");
        }
    }

    private int getIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }
        }
        return index;
    }

    private void setMatchupImage(String picked, ImageButton imgView) {
        switch(picked) {
            case "Fox":
                imgView.setImageResource(R.drawable.fox);
                break;
            case "Falco":
                imgView.setImageResource(R.drawable.falco);
                break;
            case "Sheik":
                imgView.setImageResource(R.drawable.sheik);
                break;
            case "Marth":
                imgView.setImageResource(R.drawable.marth);
                break;
            case "Princess Peach":
                imgView.setImageResource(R.drawable.peach);
                break;
            case "Captain Falcon":
                imgView.setImageResource(R.drawable.falcon);
                break;
            case "Ice Climbers":
                imgView.setImageResource(R.drawable.iceclimbers);
                break;
            case "Samus Aran":
                imgView.setImageResource(R.drawable.samus);
                break;
            case "Dr. Mario":
                imgView.setImageResource(R.drawable.drmario);
                break;
            case "Jigglypuff":
                imgView.setImageResource(R.drawable.jiggs);
                break;
            case "Mario":
                imgView.setImageResource(R.drawable.mario);
                break;
            case "Ganondorf":
                imgView.setImageResource(R.drawable.ganondorf);
                break;
            case "Link":
                imgView.setImageResource(R.drawable.link);
                break;
            case "Luigi":
                imgView.setImageResource(R.drawable.luigi);
                break;
            case "Donkey Kong":
                imgView.setImageResource(R.drawable.dong);
                break;
            case "Roy":
                imgView.setImageResource(R.drawable.roy);
                break;
            case "Young Link":
                imgView.setImageResource(R.drawable.ylink);
                break;
            case "Pikachu":
                imgView.setImageResource(R.drawable.pikachu);
                break;
            case "Yoshi":
                imgView.setImageResource(R.drawable.yoshi);
                break;
            case "Princess Zelda":
                imgView.setImageResource(R.drawable.zelda);
                break;
            case "Mr. Game & Watch":
                imgView.setImageResource(R.drawable.mrgandw);
                break;
            case "Ness":
                imgView.setImageResource(R.drawable.ness);
                break;
            case "Bowser":
                imgView.setImageResource(R.drawable.bowser);
                break;
            case "Kirby":
                imgView.setImageResource(R.drawable.kirby);
                break;
            case "Pichu":
                imgView.setImageResource(R.drawable.pichu);
                break;
            case "Mewtwo":
                imgView.setImageResource(R.drawable.mewtwo);
                break;
        }
    }

    private void setMatchupLeft(String character) {
        characterLeft = character;
    }

    private void setMatchupRight(String character) {
        characterRight = character;
    }

    private void un20XX() {
        shineTop.setVisibility(View.GONE);
        shineBottom.setVisibility(View.GONE);
    }

    private void to20XX() {
        shineTop.setVisibility(View.VISIBLE);
        shineBottom.setVisibility(View.VISIBLE);
    }
}
