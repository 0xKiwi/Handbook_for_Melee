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

package com.thatkawaiiguy.meleehandbook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.thatkawaiiguy.meleehandbook.activity.CharacterFrameActivity;
import com.thatkawaiiguy.meleehandbook.other.CustomChildObject;
import com.thatkawaiiguy.meleehandbook.other.CustomParentObject;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.HitboxesAdapter;

import java.util.ArrayList;

public class FrameDataFragment extends Fragment {
    private final String[] parentList = {"Tilts","Aerial Attacks", "Smash Attacks", "Normal Attacks", "Special Attacks"};

    private final String[] smashList = {"Up Smash", "Down Smash", "Forward Smash"};
    private final String[] aerialList = {"Up Aerial", "Back Aerial", "Down Aerial", "Neutral Aerial", "Forward Aerial"};
    private final String[] normalList = {"Jab 1", "Jab 2", "Rapid Jab", "Grab", "Dash Grab", "Dash Attack","Jab 3"};
    private final String[] tiltList = {"Up Tilt", "Down Tilt", "Forward Tilt", "Forward Tilt (Up)", "Forward Tilt (Down)"};
    private final String[] specialList = {"Up-B", "Side-B", "Down-B", "Neutral B"};
    private final String[] marthSpecialList={"Side-B 1", "Side-B 2 Side/Down", "Side-B 2 Up",
        "Side-B 3 Side", "Side-B 3 Up", "Side-B 3 Down", "Side-B 4 Side",
            "Side-B 4 Up", "Side-B 4 Down"};

    private String actionBarTitle = "";

    private HitboxesAdapter mExpandableAdapter;

    public static FrameDataFragment newInstance() {
        Bundle args = new Bundle();
        FrameDataFragment fragment = new FrameDataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBarTitle = ((CharacterFrameActivity) getActivity()).getSupportActionBarTitle();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mExpandableAdapter = new HitboxesAdapter(getActivity(), setUpData(), actionBarTitle);
        mRecyclerView.setAdapter(mExpandableAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    private ArrayList<ParentObject> setUpData() {
        ArrayList<ParentObject> parentObjectList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Object> childObjectList = new ArrayList<>();

            switch (i) {
                case 0: {
                    childObjectList.add(new CustomChildObject().setChildText(tiltList[0]));
                    childObjectList.add(new CustomChildObject().setChildText(tiltList[1]));
                    childObjectList.add(new CustomChildObject().setChildText(tiltList[2]));
                    if (actionBarTitle.equals("Marth") || actionBarTitle.equals("Sheik") ||
                            actionBarTitle.equals("Yoshi") || actionBarTitle.equals("Princess Peach"))
                        break;
                    childObjectList.add(new CustomChildObject().setChildText(tiltList[3]));
                    childObjectList.add(new CustomChildObject().setChildText(tiltList[4]));
                }
                break;
                case 1: {
                    childObjectList.add(new CustomChildObject().setChildText(aerialList[0]));
                    childObjectList.add(new CustomChildObject().setChildText(aerialList[1]));
                    childObjectList.add(new CustomChildObject().setChildText(aerialList[2]));
                    childObjectList.add(new CustomChildObject().setChildText(aerialList[3]));
                    childObjectList.add(new CustomChildObject().setChildText(aerialList[4]));
                }
                break;
                case 2: {
                    childObjectList.add(new CustomChildObject().setChildText(smashList[0]));
                    childObjectList.add(new CustomChildObject().setChildText(smashList[1]));
                    childObjectList.add(new CustomChildObject().setChildText(smashList[2]));
                }
                break;
                case 3: {
                    childObjectList.add(new CustomChildObject().setChildText(normalList[0]));
                    switch(actionBarTitle) {
                        case "Marth":
                        case "Jigglypuff":
                        case "Samus Aran":
                        case "Ice Climbers":
                        case "Yoshi":
                            childObjectList.add(new CustomChildObject().setChildText(normalList[1]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[3]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[4]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[5]));
                            break;
                        case "Captain Falcon":
                            childObjectList.add(new CustomChildObject().setChildText(normalList[1]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[6]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[2]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[3]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[4]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[5]));
                            break;
                        case "Luigi":
                        case "Dr. Mario":
                            childObjectList.add(new CustomChildObject().setChildText(normalList[1]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[6]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[3]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[4]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[5]));
                            break;
                        case "Ganondorf":
                        case "Pikachu":
                            childObjectList.add(new CustomChildObject().setChildText(normalList[5]));
                            break;
                        default:
                            childObjectList.add(new CustomChildObject().setChildText(normalList[1]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[2]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[3]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[4]));
                            childObjectList.add(new CustomChildObject().setChildText(normalList[5]));
                            break;
                    }
                }
                break;
                case 4: {
                    childObjectList.add(new CustomChildObject().setChildText(specialList[0]));
                    if (!actionBarTitle.equals("Marth")) {
                        if(!actionBarTitle.equals("Yoshi"))
                            childObjectList.add(new CustomChildObject().setChildText(specialList[1]));
                        childObjectList.add(new CustomChildObject().setChildText(specialList[2]));
                        if(!actionBarTitle.equals("Dr. Mario"))
                            childObjectList.add(new CustomChildObject().setChildText(specialList[3]));
                    } else {
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[0]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[1]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[2]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[3]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[4]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[5]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[6]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[7]));
                        childObjectList.add(new CustomChildObject().setChildText(marthSpecialList[8]));
                        childObjectList.add(new CustomChildObject().setChildText(specialList[2]));
                        childObjectList.add(new CustomChildObject().setChildText(specialList[3]));
                    }
                }
                break;
            }

            CustomParentObject customParentObject = new CustomParentObject();
            customParentObject.setChildObjectList(childObjectList);
            customParentObject.setParentText(parentList[i]);
            parentObjectList.add(customParentObject);
        }
        return parentObjectList;
    }

    @Override
    public void onResume() {
        super.onResume();
        mExpandableAdapter.setCanStart();
    }
}