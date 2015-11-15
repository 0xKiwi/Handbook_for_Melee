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
import com.thatkawaiiguy.meleehandbook.adapter.FrameDataAdapter;

import java.util.ArrayList;

public class FrameDataFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    public String[] parentList = {"Tilts","Aerial Attacks", "Smash Attacks", "Normal Attacks", "Special Attacks"};

    public String[] smashList = {"Up Smash", "Down Smash", "Forward Smash"};
    public String[] aerialList = {"Up Aerial", "Back Aerial", "Down Aerial", "Neutral Aerial", "Forward Aerial"};
    public String[] normalList = {"Jab 1", "Jab 2", "Rapid Jab", "Grab", "Dash Grab", "Dash Attack","Jab 3"};
    public String[] tiltList = {"Up Tilt", "Down Tilt", "Forward Tilt", "Forward Tilt (Up)", "Forward Tilt (Down)"};
    public String[] specialList = {"Up-B", "Side-B", "Down-B", "Neutral B"};
    public String[] marthSpecialList={"Side-B 1", "Side-B 2 Side/Down", "Side-B 2 Up",
        "Side-B 3 Side", "Side-B 3 Up", "Side-B 3 Down", "Side-B 4 Side",
            "Side-B 4 Up", "Side-B 4 Down"};

    String actionBarTitle = "";

    FrameDataAdapter mExpandableAdapter;

    public static FrameDataFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
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
        mExpandableAdapter = new FrameDataAdapter(getActivity(), setUpData(5), actionBarTitle);
        mRecyclerView.setAdapter(mExpandableAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    private ArrayList<ParentObject> setUpData(int numItems) {
        ArrayList<ParentObject> parentObjectList = new ArrayList<>();
        for (int i = 0; i < numItems; i++) {
            ArrayList<Object> childObjectList = new ArrayList<>();
            CustomChildObject customChildObject = new CustomChildObject();
            CustomChildObject customChildObject2 = new CustomChildObject();
            CustomChildObject customChildObject3 = new CustomChildObject();

            switch (i) {
                case 0: {
                    customChildObject.setChildText(tiltList[0]);
                    customChildObject2.setChildText(tiltList[1]);
                    customChildObject3.setChildText(tiltList[2]);
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                    if (actionBarTitle.equals("Marth") || actionBarTitle.equals("Sheik") ||
                            actionBarTitle.equals("Yoshi"))
                        break;
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    CustomChildObject customChildObject5 = new CustomChildObject();
                    customChildObject4.setChildText(tiltList[3]);
                    customChildObject5.setChildText(tiltList[4]);
                    childObjectList.add(customChildObject4);
                    childObjectList.add(customChildObject5);
                }
                break;
                case 1: {
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    CustomChildObject customChildObject5 = new CustomChildObject();
                    customChildObject.setChildText(aerialList[0]);
                    customChildObject2.setChildText(aerialList[1]);
                    customChildObject3.setChildText(aerialList[2]);
                    customChildObject4.setChildText(aerialList[3]);
                    customChildObject5.setChildText(aerialList[4]);
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                    childObjectList.add(customChildObject4);
                    childObjectList.add(customChildObject5);
                }
                break;
                case 2: {
                    customChildObject.setChildText(smashList[0]);
                    customChildObject2.setChildText(smashList[1]);
                    customChildObject3.setChildText(smashList[2]);
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                }
                break;
                case 3: {
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    CustomChildObject customChildObject5 = new CustomChildObject();
                    CustomChildObject customChildObject6 = new CustomChildObject();
                    CustomChildObject customChildObject7 = new CustomChildObject();
                    customChildObject.setChildText(normalList[0]);
                    childObjectList.add(customChildObject);
                    if (actionBarTitle.equals("Marth") || actionBarTitle.equals("Jigglypuff")
                            || actionBarTitle.equals("Samus Aran") || actionBarTitle.equals("Ice Climbers")
                            || actionBarTitle.equals("Yoshi")) {
                        customChildObject2.setChildText(normalList[1]);
                        customChildObject4.setChildText(normalList[3]);
                        customChildObject5.setChildText(normalList[4]);
                        customChildObject6.setChildText(normalList[5]);
                        childObjectList.add(customChildObject2);
                        childObjectList.add(customChildObject4);
                        childObjectList.add(customChildObject5);
                        childObjectList.add(customChildObject6);
                    } else if(actionBarTitle.equals("Captain Falcon")) {
                        customChildObject2.setChildText(normalList[1]);
                        customChildObject3.setChildText(normalList[6]);
                        customChildObject4.setChildText(normalList[2]);
                        customChildObject5.setChildText(normalList[3]);
                        customChildObject6.setChildText(normalList[4]);
                        customChildObject7.setChildText(normalList[5]);
                        childObjectList.add(customChildObject2);
                        childObjectList.add(customChildObject3);
                        childObjectList.add(customChildObject4);
                        childObjectList.add(customChildObject5);
                        childObjectList.add(customChildObject6);
                        childObjectList.add(customChildObject7);
                    } else if(actionBarTitle.equals("Dr. Mario")) {
                        customChildObject2.setChildText(normalList[1]);
                        customChildObject3.setChildText(normalList[6]);
                        customChildObject5.setChildText(normalList[3]);
                        customChildObject6.setChildText(normalList[4]);
                        customChildObject7.setChildText(normalList[5]);
                        childObjectList.add(customChildObject2);
                        childObjectList.add(customChildObject3);
                        childObjectList.add(customChildObject5);
                        childObjectList.add(customChildObject6);
                        childObjectList.add(customChildObject7);
                    } else if(actionBarTitle.equals("Ganondorf") || actionBarTitle.equals("Pikachu")) {
                        customChildObject6.setChildText(normalList[5]);
                        childObjectList.add(customChildObject6);
                    } else {
                        customChildObject2.setChildText(normalList[1]);
                        customChildObject3.setChildText(normalList[2]);
                        customChildObject4.setChildText(normalList[3]);
                        customChildObject5.setChildText(normalList[4]);
                        customChildObject6.setChildText(normalList[5]);
                        childObjectList.add(customChildObject2);
                        childObjectList.add(customChildObject3);
                        childObjectList.add(customChildObject4);
                        childObjectList.add(customChildObject5);
                        childObjectList.add(customChildObject6);
                    }
                }
                break;
                case 4: {
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    customChildObject.setChildText(specialList[0]);
                    if (!actionBarTitle.equals("Marth")) {
                        customChildObject2.setChildText(specialList[1]);
                        customChildObject3.setChildText(specialList[2]);
                        customChildObject4.setChildText(specialList[3]);
                        childObjectList.add(customChildObject);
                        if(!actionBarTitle.equals("Yoshi"))
                            childObjectList.add(customChildObject2);
                        childObjectList.add(customChildObject3);
                        if(!actionBarTitle.equals("Dr. Mario"))
                            childObjectList.add(customChildObject4);
                    } else {
                        CustomChildObject customChildObject5 = new CustomChildObject();
                        CustomChildObject customChildObject6 = new CustomChildObject();
                        CustomChildObject customChildObject7 = new CustomChildObject();
                        CustomChildObject customChildObject8 = new CustomChildObject();
                        CustomChildObject customChildObject9 = new CustomChildObject();
                        CustomChildObject customChildObject10 = new CustomChildObject();
                        CustomChildObject customChildObject11 = new CustomChildObject();
                        CustomChildObject customChildObject12 = new CustomChildObject();
                        customChildObject2.setChildText(marthSpecialList[0]);
                        customChildObject3.setChildText(marthSpecialList[1]);
                        customChildObject4.setChildText(marthSpecialList[2]);
                        customChildObject5.setChildText(marthSpecialList[3]);
                        customChildObject6.setChildText(marthSpecialList[4]);
                        customChildObject7.setChildText(marthSpecialList[5]);
                        customChildObject8.setChildText(marthSpecialList[6]);
                        customChildObject9.setChildText(marthSpecialList[7]);
                        customChildObject10.setChildText(marthSpecialList[8]);
                        customChildObject11.setChildText(specialList[2]);
                        customChildObject12.setChildText(specialList[3]);
                        childObjectList.add(customChildObject);
                        childObjectList.add(customChildObject2);
                        childObjectList.add(customChildObject3);
                        childObjectList.add(customChildObject4);
                        childObjectList.add(customChildObject5);
                        childObjectList.add(customChildObject6);
                        childObjectList.add(customChildObject7);
                        childObjectList.add(customChildObject8);
                        childObjectList.add(customChildObject9);
                        childObjectList.add(customChildObject10);
                        childObjectList.add(customChildObject11);
                        childObjectList.add(customChildObject12);
                    }
                }
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