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
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avocarrot.androidsdk.AvocarrotInstreamRecyclerView;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.thatkawaiiguy.meleehandbook.activity.TechTabActivity;
import com.thatkawaiiguy.meleehandbook.activity.VideoInfoActivity;
import com.thatkawaiiguy.meleehandbook.adapter.ExpandableAdapter;
import com.thatkawaiiguy.meleehandbook.adapter.TextAdapter;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.CustomChildObject;
import com.thatkawaiiguy.meleehandbook.other.CustomParentObject;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.ItemClickSupport;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

import java.util.ArrayList;

public class UniqueFragment extends Fragment {
    private String[] parentList;

    private final String djc = "Double jump cancel";
    private final String upbturn = "Up-B turnaround";
    private final String jumprefresh = "Double jump refresh";
    private final String psspike = "Princess/Swordsman spiking";

    private ExpandableAdapter mExpandableAdapter;

    private boolean canStart = true;

    private RecyclerView mRecyclerView;

    private final String[] uniqueTechs = ArrayHelper.getUniqueArray();

    public static UniqueFragment newInstance() {
        Bundle args = new Bundle();
        UniqueFragment fragment = new UniqueFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        parentList = ArrayHelper.getUniqueTechCharArray(getActivity());

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        if(Preferences.groupByCharacterEnabled(getActivity())) {
            mExpandableAdapter = new ExpandableAdapter(getActivity(), setUpData(), false);
            mRecyclerView.setAdapter(mExpandableAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        } else {
            AvocarrotInstreamRecyclerView avocarrotInstreamRecyclerView = new
                    AvocarrotInstreamRecyclerView(
                    new TextAdapter(uniqueTechs, getActivity()),
                    getActivity(),                   /* reference to your Activity */
                    getResources().getString(R.string.avocarrot_app_id), /* this is your Avocarrot API Key */
                    getResources().getString(R.string.native_on_main_placement)  /* this is your Avocarrot Placement
                Key */
            );

            avocarrotInstreamRecyclerView.setSandbox(true);
            avocarrotInstreamRecyclerView.setLogger(true, "ALL");

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(avocarrotInstreamRecyclerView);

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(int position) {
                    if(canStart) {
                        Intent mIntent;
                        if(uniqueTechs[position].equals("Super wavedash & SDWD") ||
                                uniqueTechs[position].equals("Extended & homing grapple"))
                            mIntent = new Intent(getActivity(), TechTabActivity.class);
                        else
                            mIntent = new Intent(getActivity(), VideoInfoActivity.class);
                        mIntent.putExtra("option", uniqueTechs[position]);
                        startActivity(mIntent);
                        canStart = false;
                    }
                }
            });
        }

        mRecyclerView.setHasFixedSize(true);

        return rootView;
    }

    private ArrayList<ParentObject> setUpData() {
        ArrayList<ParentObject> parentObjectList = new ArrayList<>();
        for(int i = 0; i < parentList.length; i++) {
            ArrayList<Object> childObjectList = new ArrayList<>();
            CustomChildObject customChildObject = new CustomChildObject();

            switch(parentList[i]) {
                case "Ganondorf":
                case "Captain Falcon": {
                    customChildObject.setChildText(jumprefresh);
                    childObjectList.add(customChildObject);
                }
                break;
                case "Dr. Mario": {
                    customChildObject.setChildText("Up-B cancel");
                    childObjectList.add(customChildObject);
                }
                break;
                case "Fox":
                case "Falco": {
                    CustomChildObject customChildObject2 = new CustomChildObject();
                    CustomChildObject customChildObject3 = new CustomChildObject();
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    CustomChildObject customChildObject5 = new CustomChildObject();
                    CustomChildObject customChildObject6 = new CustomChildObject();
                    CustomChildObject customChildObject7 = new CustomChildObject();
                    CustomChildObject customChildObject8 = new CustomChildObject();
                    customChildObject.setChildText("Chillin dash");
                    customChildObject2.setChildText("Ledgehop double laser");
                    customChildObject3.setChildText("Multishine");
                    customChildObject4.setChildText("Pillaring");
                    customChildObject5.setChildText("Short hop laser");
                    customChildObject6.setChildText("Side-B shorten");
                    customChildObject7.setChildText("Shine mine");
                    customChildObject8.setChildText("Waveshine");
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                    childObjectList.add(customChildObject4);
                    childObjectList.add(customChildObject5);
                    childObjectList.add(customChildObject6);
                    childObjectList.add(customChildObject7);
                    childObjectList.add(customChildObject8);
                }
                break;
                case "Ice Climbers": {
                    CustomChildObject customChildObject2 = new CustomChildObject();
                    customChildObject.setChildText("Desynching");
                    customChildObject2.setChildText("Wobbling");
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                }
                break;
                case "Jigglypuff": {
                    customChildObject.setChildText("Rising pound");
                    childObjectList.add(customChildObject);
                }
                break;
                case "Young Link":
                case "Link": {
                    customChildObject.setChildText("Boomerang superjump");
                    childObjectList.add(customChildObject);
                }
                break;
                case "Luigi": {
                    customChildObject.setChildText("Vududash");
                    childObjectList.add(customChildObject);
                }
                break;
                case "Mario": {
                    customChildObject.setChildText("Up-B walljump");
                    childObjectList.add(customChildObject);
                }
                break;
                case "Pichu":
                case "Pikachu":
                case "Princess Zelda": {
                    customChildObject.setChildText(upbturn);
                    childObjectList.add(customChildObject);
                }
                break;
                case "Mewtwo": {
                    CustomChildObject customChildObject2 = new CustomChildObject();
                    customChildObject.setChildText(djc);
                    customChildObject2.setChildText(upbturn);
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                }
                break;
                case "Princess Peach": {
                    CustomChildObject customChildObject2 = new CustomChildObject();
                    CustomChildObject customChildObject3 = new CustomChildObject();
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    customChildObject.setChildText(djc);
                    customChildObject2.setChildText("Float cancel");
                    customChildObject3.setChildText("Frozen turnip glitch");
                    customChildObject4.setChildText(psspike);
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                    childObjectList.add(customChildObject4);
                }
                break;
                case "Ness": {
                    CustomChildObject customChildObject2 = new CustomChildObject();
                    customChildObject.setChildText(djc);
                    customChildObject2.setChildText("Yo-yo glitch");
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                }
                break;
                case "Marth":
                case "Roy": {
                    customChildObject.setChildText(psspike);
                    childObjectList.add(customChildObject);
                }
                break;
                case "Samus Aran": {
                    CustomChildObject customChildObject2 = new CustomChildObject();
                    CustomChildObject customChildObject3 = new CustomChildObject();
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    customChildObject.setChildText("Extended & homing grapple");
                    customChildObject2.setChildText("RI grapple cancel");
                    customChildObject3.setChildText("SHFF missiles");
                    customChildObject4.setChildText("Super wavedash & SDWD");
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                    childObjectList.add(customChildObject4);
                }
                break;
                case "Yoshi": {
                    CustomChildObject customChildObject2 = new CustomChildObject();
                    CustomChildObject customChildObject3 = new CustomChildObject();
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    customChildObject.setChildText(djc);
                    customChildObject2.setChildText("DJ knockback armor");
                    customChildObject3.setChildText("Edge canceled eggs");
                    customChildObject4.setChildText("Parry");
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                    childObjectList.add(customChildObject4);
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
        canStart = true;
        if(Preferences.groupByCharacterEnabled(getActivity()) && mExpandableAdapter != null)
            mExpandableAdapter.setCanStart();
    }
}
