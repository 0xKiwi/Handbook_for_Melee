package com.thatkawaiiguy.meleehandbook.fragment.main;

import android.app.Fragment;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    private TextView muInfoLeft;
    private TextView muInfoRight;

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
        muInfoLeft = (TextView) view.findViewById(R.id.muInfoLeft);
        infoRight = (TextView) view.findViewById(R.id.muTextRight);
        muInfoRight = (TextView) view.findViewById(R.id.muInfoRight);
        spinnerLeft = (Spinner) view.findViewById(R.id.spinnerLeft);
        spinnerRight = (Spinner) view.findViewById(R.id.spinnerRight);
        muImgRight = (ImageButton) view.findViewById(R.id.muImgRight);
        muImgLeft = (ImageButton) view.findViewById(R.id.muImgLeft);
        shineBottom = (Button) view.findViewById(R.id.shineTextBottom);
        shineTop = (Button) view.findViewById(R.id.shineTextTop);

        final MediaPlayer mp = new MediaPlayer();
        final MediaPlayer mp2 = new MediaPlayer();
        shineTop.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (characterLeft.equals(characterRight) &&
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
                            } catch (IllegalStateException | IOException e) {
                                e.printStackTrace();
                            }
                            return true;
                        }
                        return false;
                    }
                }
        );
        shineBottom.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (characterLeft.equals(characterRight) &&
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
                            } catch (IllegalStateException | IOException e) {
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
        if (left.equals(right))
            return "Mirror";
        return getLeftPercent(right, left);
    }

    private String getLeftPercent(String left, String right) {
        switch (left) {
            case "Fox": {
                switch (right) {
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
                switch (right) {
                    case "Fox":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                    case "Yoshi":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                    case "Yoshi":
                    case "Princess Zelda":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                    case "Yoshi":
                    case "Princess Zelda":
                    case "Mr. Game & Watch":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                    case "Yoshi":
                    case "Princess Zelda":
                    case "Mr. Game & Watch":
                    case "Ness":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                    case "Yoshi":
                    case "Princess Zelda":
                    case "Mr. Game & Watch":
                    case "Ness":
                    case "Bowser":
                        return getPercent(right, left);
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
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                    case "Yoshi":
                    case "Princess Zelda":
                    case "Mr. Game & Watch":
                    case "Ness":
                    case "Bowser":
                    case "Kirby":
                        return getPercent(right, left);
                    case "Pichu":
                        return "Mirror";
                    case "Mewtwo":
                        return "30";
                }
            }
            break;
            case "Mewtwo": {
                switch (right) {
                    case "Fox":
                    case "Falco":
                    case "Sheik":
                    case "Marth":
                    case "Princess Peach":
                    case "Captain Falcon":
                    case "Ice Climbers":
                    case "Samus Aran":
                    case "Dr. Mario":
                    case "Jigglypuff":
                    case "Mario":
                    case "Ganondorf":
                    case "Link":
                    case "Luigi":
                    case "Donkey Kong":
                    case "Roy":
                    case "Young Link":
                    case "Pikachu":
                    case "Yoshi":
                    case "Princess Zelda":
                    case "Mr. Game & Watch":
                    case "Ness":
                    case "Bowser":
                    case "Kirby":
                    case "Pichu":
                        return getPercent(right, left);
                    case "Mewtwo":
                        return "Mirror";
                }
            }
            break;
        }
        return "uhh";
    }

    private String getInfo(String left, String right) {
        switch (left) {
            case "Fox": {
                switch (right) {
                    case "Falco":
                        return "Better recovery and amazing neutral";
                    case "Sheik":
                        return "Strong attacks, punish game";
                    case "Marth":
                        return "Combo ability, strong attacks and approach";
                    case "Princess Peach":
                        return "Strong attacks";
                    case "Captain Falcon":
                        return "Combo and gimping ability";
                    case "Ice Climbers":
                        return "Combo and gimping ability";
                    case "Samus Aran":
                        return "Strong attacks";
                    case "Jigglypuff":
                        return "Rest combos";
                }
            }
            break;
            case "Falco": {
                switch (right) {
                    case "Fox":
                        return "Stopping power, but poor recovery";
                    case "Sheik":
                        return "Long tech roll and punish game";
                    case "Marth":
                        return "Stopping power, but poor recovery";
                    case "Princess Peach":
                        return "Combo ability, but poor recovery";
                    case "Captain Falcon":
                        return "Stopping power, dair priority";
                    case "Ice Climbers":
                        return "Easily chaingrabbed";
                    case "Samus Aran":
                        return "Stopping power";
                    case "Jigglypuff":
                        return "Strong attacks, but easily rested";
                }
            }
            break;
            case "Sheik": {
                switch (right) {
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
                        return "Can separate with B-Air but hard to camp";
                    case "Samus Aran":
                        return "Floaty";
                    case "Jigglypuff":
                        return "Lightweight";
                }
            }
            break;
            case "Marth": {
                switch (right) {
                    case "Fox":
                        return "Can gimp, disjointed hitboxes";
                    case "Falco":
                        return "Can gimp, disjointed hitboxes";
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
                    case "Jigglypuff":
                        return "Can space well";
                }
            }
            break;
            case "Princess Peach": {
                switch (right) {
                    case "Fox":
                        return "Zoning power";
                    case "Falco":
                        return "Easily gimps, down smash";
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
                    case "Jigglypuff":
                        return "Lightweight";
                }
            }
            break;
            case "Captain Falcon": {
                switch (right) {
                    case "Fox":
                        return "Predictable recovery";
                    case "Falco":
                        return "Predictable recovery";
                    case "Sheik":
                        return "Predictable recovery";
                    case "Marth":
                        return "Strong punish";
                    case "Princess Peach":
                        return "Trouble edgeguarding";
                    case "Ice Climbers":
                        return "Trouble separating";
                    case "Samus Aran":
                        return "Strong attacks";
                    case "Jigglypuff":
                        return "Strong punish";
                }
            }
            break;
            case "Ice Climbers": {
                switch (right) {
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
                        return "Can wobble easily";
                    case "Samus Aran":
                        return "Easily separated";
                    case "Jigglypuff":
                        return "Punishes hard";
                }
            }
            break;
            case "Samus Aran": {
                switch (right) {
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
                    case "Jigglypuff":
                        return "Floaty";
                }
            }
            break;
            case "Jigglypuff": {
                switch (right) {
                    case "Fox":
                        return "Lightweight, can be punished by Up-Throw -> Up-Air";
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
                        return "Easy to edgeguard";
                    case "Samus Aran":
                        return "Easy to avoid spam";
                }
            }
            break;
        }
        return "";
    }

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
        muImgLeft.setOnClickListener(new View.OnClickListener() {
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
        muImgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerRight.performClick();
            }
        });

        String main = Preferences.getMainChar(getActivity());
        if (!main.equals("None") && !main.equals("")) {
            setMatchupLeft(main);
            spinnerLeft.setSelection(getIndex(spinnerLeft, main));
            setMatchupImage(Preferences.getMainChar(getActivity()), muImgLeft);
            createMatchup();
        }
    }

    private void createMatchup() {
        if (getLeftPercent(characterLeft, characterRight).equals("Mirror")) {
            infoLeft.setText("Mirror");
            infoRight.setText("Mirror");
            muInfoLeft.setText("");
            muInfoRight.setText("");
            if (characterLeft.equals("Fox") && characterRight.equals("Fox"))
                to20XX();
            else
                un20XX();
        } else {
            un20XX();
            muInfoLeft.setText(getInfo(characterLeft, characterRight));
            infoLeft.setText(getLeftPercent(characterLeft, characterRight) + "%");
            muInfoRight.setText(getInfo(characterRight, characterLeft));
            infoRight.setText(getRightPercent(characterLeft, characterRight) + "%");
        }
    }

    private String getPercent(String left, String right) {
        return String.valueOf(Math.abs(Integer.parseInt(getLeftPercent(left, right)) - 100));
    }

    private int getIndex(Spinner spinner, String myString) {
        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(myString)) {
                index = i;
            }
        }
        return index;
    }

    private Bitmap downscaleBitmapUsingDensities(final int sampleSize, final int imageResId) {
        final BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inDensity = sampleSize;
        bitmapOptions.inTargetDensity = 1;
        final Bitmap scaledBitmap = BitmapFactory.decodeResource(getResources(), imageResId, bitmapOptions);
        scaledBitmap.setDensity(Bitmap.DENSITY_NONE);
        return scaledBitmap;
    }


    private void setMatchupImage(String picked, ImageButton imgView) {
        imgView.setImageBitmap(downscaleBitmapUsingDensities(3,
                getResources().getIdentifier(ArrayHelper.getFileName(picked),
                        "drawable", getActivity().getPackageName())));
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