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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.matchup_layout, container, false);

        leftView = view.findViewById(R.id.viewleft);
        rightView = view.findViewById(R.id.viewright);
        infoLeft = (TextView) view.findViewById(R.id.muTextLeft);
        infoRight = (TextView) view.findViewById(R.id.muTextRight);
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
                                                } catch(IllegalStateException e) {
                                                    e.printStackTrace();
                                                } catch(IOException e) {
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
                                                   } catch(IllegalStateException e) {
                                                       e.printStackTrace();
                                                   } catch(IOException e) {
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

    public String getRightPercent(String left, String right) {
        if(left.equals(right))
            return "Mirror";
        return getLeftPercent(right, left);
    }

    public String getLeftPercent(String left, String right) {
        switch(left) {
            case "Fox": {
                switch(right) {
                    case "Fox":
                        return "Mirror";
                    case "Falco":
                        return "50";
                    case "Sheik":
                        return "50";
                    case "Marth":
                        return "50";
                    case "Princess Peach":
                        return "60";
                    case "Captain Falcon":
                        return "60";
                    case "Ice Climbers":
                        return "70";
                    case "Samus Aran":
                        return "60";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "70";
                    case "Mario":
                        return "60";
                    case "Ganondorf":
                        return "60";
                    case "Link":
                        return "70";
                    case "Luigi":
                        return "70";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "90";
                    case "Young Link":
                        return "80";
                    case "Pikachu":
                        return "70";
                    case "Yoshi":
                        return "80";
                    case "Princess Zelda":
                        return "90";
                    case "Mr. Game & Watch":
                        return "80";
                    case "Ness":
                        return "90";
                    case "Bowser":
                        return "90";
                    case "Kirby":
                        return "90";
                    case "Pichu":
                        return "90";
                    case "Mewtwo":
                        return "90";
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
                        return "50";
                    case "Marth":
                        return "50";
                    case "Princess Peach":
                        return "50";
                    case "Captain Falcon":
                        return "60";
                    case "Ice Climbers":
                        return "50";
                    case "Samus Aran":
                        return "60";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "40";
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
                        return "80";
                    case "Yoshi":
                        return "70";
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
                        return "60";
                    case "Captain Falcon":
                        return "70";
                    case "Ice Climbers":
                        return "50";
                    case "Samus Aran":
                        return "60";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "60";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "80";
                    case "Link":
                        return "65";
                    case "Luigi":
                        return "80";
                    case "Donkey Kong":
                        return "80";
                    case "Roy":
                        return "90";
                    case "Young Link":
                        return "80";
                    case "Pikachu":
                        return "80";
                    case "Yoshi":
                        return "90";
                    case "Princess Zelda":
                        return "80";
                    case "Mr. Game & Watch":
                        return "90";
                    case "Ness":
                        return "80";
                    case "Bowser":
                        return "90";
                    case "Kirby":
                        return "60";
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
                        return "70";
                    case "Jigglypuff":
                        return "60";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "50";
                    case "Link":
                        return "55";
                    case "Luigi":
                        return "70";
                    case "Donkey Kong":
                        return "60";
                    case "Roy":
                        return "70";
                    case "Young Link":
                        return "60";
                    case "Pikachu":
                        return "90";
                    case "Yoshi":
                        return "70";
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
                        return "40";
                    case "Ice Climbers":
                        return "80";
                    case "Samus Aran":
                        return "40";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "60";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "50";
                    case "Link":
                        return "20";
                    case "Luigi":
                        return "50";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "30";
                    case "Pikachu":
                        return "70";
                    case "Yoshi":
                        return "80";
                    case "Princess Zelda":
                        return "80";
                    case "Mr. Game & Watch":
                        return "70";
                    case "Ness":
                        return "70";
                    case "Bowser":
                        return "800";
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
                        return "80";
                    case "Samus Aran":
                        return "70";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "60";
                    case "Mario":
                        return "70";
                    case "Ganondorf":
                        return "50";
                    case "Link":
                        return "20";
                    case "Luigi":
                        return "50";
                    case "Donkey Kong":
                        return "70";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "30";
                    case "Pikachu":
                        return "70";
                    case "Yoshi":
                        return "80";
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
                        return "30";
                    case "Dr. Mario":
                        return "60";
                    case "Jigglypuff":
                        return "30";
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
                        return "80";
                    case "Pikachu":
                        return "70";
                    case "Yoshi":
                        return "90";
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
                        return "50";
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
                        return "50";
                    case "Mr. Game & Watch":
                        return "70";
                    case "Ness":
                        return "50";
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
                        return "50";
                    case "Ganondorf":
                        return "40";
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
                        return "20";
                    case "Yoshi":
                        return "70";
                    case "Princess Zelda":
                        return "40";
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
                        return "70";
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
                        return "20";
                    case "Yoshi":
                        return "70";
                    case "Princess Zelda":
                        return "40";
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
                        return "55";
                    case "Donkey Kong":
                        return "60";
                    case "Roy":
                        return "60";
                    case "Young Link":
                        return "55";
                    case "Pikachu":
                        return "65";
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
                        return "50";
                    case "Young Link":
                        return "45";
                    case "Pikachu":
                        return "50";
                    case "Yoshi":
                        return "50";
                    case "Princess Zelda":
                        return "50";
                    case "Mr. Game & Watch":
                        return "40";
                    case "Ness":
                        return "40";
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
                        return "20";
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
                        return "50";
                    case "Princess Zelda":
                        return "60";
                    case "Mr. Game & Watch":
                        return "60";
                    case "Ness":
                        return "30";
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
                        return "30";
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
                        return "70";
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

    public void setMatchupsView() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.matchup_array, android.R.layout.simple_spinner_item);
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
    }

    public void createMatchup() {
        if(getLeftPercent(characterLeft, characterRight).equals("Mirror")) {
            infoLeft.setText("Mirror");
            infoRight.setText("Mirror");
            if(characterLeft.equals("Fox") || characterLeft.equals("Falco")) {
                MediaPlayer mp = new MediaPlayer();
                try {
                    AssetFileDescriptor afd;
                    afd = getResources().getAssets().openFd("shine.wav");
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength
                            ());
                    mp.prepare();
                    mp.start();
                } catch(IllegalStateException e) {
                    e.printStackTrace();
                } catch(IOException e) {
                    e.printStackTrace();
                }
                if(characterLeft.equals("Fox") && characterRight.equals("Fox"))
                    to20XX();
            } else
                un20XX();
        } else {
            un20XX();
            infoLeft.setText(getLeftPercent(characterLeft, characterRight) + "%");
            infoRight.setText(getRightPercent(characterLeft, characterRight) + "%");
        }
    }

    public void setMatchupImage(String picked, ImageButton imgView) {
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

    public void setMatchupLeft(String character) {
        characterLeft = character;
    }

    public void setMatchupRight(String character) {
        characterRight = character;
    }

    public void un20XX() {
        shineTop.setVisibility(View.GONE);
        shineBottom.setVisibility(View.GONE);
    }

    public void to20XX() {
        shineTop.setVisibility(View.VISIBLE);
        shineBottom.setVisibility(View.VISIBLE);
    }
}
