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
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.thatkawaiiguy.meleehandbook.adapter.ExpandableAdapter;
import com.thatkawaiiguy.meleehandbook.adapter.TextAdapter;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.CustomChildObject;
import com.thatkawaiiguy.meleehandbook.other.CustomParentObject;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

import java.util.ArrayList;

public class UniqueFragment extends Fragment {
    private String[] parentList;

    private ExpandableAdapter mExpandableAdapter;
    private TextAdapter adapter;

    private final String djc = "Double jump cancel";
    final String upbturn = "Up-B turnaround";
    private final String jumprefresh = "Double jump refresh";
    private final String psspike = "Princess/Swordsman spiking";

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

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if(Preferences.groupByCharacterEnabled(getActivity())) {
            mExpandableAdapter = new ExpandableAdapter(getActivity(), setUpData(), false);
            recyclerView.setAdapter(mExpandableAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        } else {
            adapter = new TextAdapter(uniqueTechs, getActivity(), true);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
        }

        return rootView;
    }

    private ArrayList<ParentObject> setUpData() {
        ArrayList<ParentObject> parentObjectList = new ArrayList<>();
        for(int i = 0; i < parentList.length; i++) {
            ArrayList<Object> childObjectList = new ArrayList<>();

            switch(parentList[i]) {
                case "Ganondorf": {
                    childObjectList.add(new CustomChildObject().setChildText(jumprefresh));
                }
                break;
                case "Captain Falcon": {
                    childObjectList.add(new CustomChildObject().setChildText(jumprefresh));
                    childObjectList.add(new CustomChildObject().setChildText("Gentleman"));
                }
                break;
                case "Dr. Mario": {
                    childObjectList.add(new CustomChildObject().setChildText("Up-B cancel"));
                }
                break;
                case "Fox":
                case "Falco": {
                    childObjectList.add(new CustomChildObject().setChildText("Chillin dash"));
                    childObjectList.add(new CustomChildObject().setChildText("Ledgehop double " +
                            "laser"));
                    childObjectList.add(new CustomChildObject().setChildText("Multishine"));
                    childObjectList.add(new CustomChildObject().setChildText("Pillaring"));
                    childObjectList.add(new CustomChildObject().setChildText("Short hop laser"));
                    childObjectList.add(new CustomChildObject().setChildText("Side-B shorten"));
                    childObjectList.add(new CustomChildObject().setChildText("Shine mine"));
                    childObjectList.add(new CustomChildObject().setChildText("Waveshine"));
                }
                break;
                case "Ice Climbers": {
                    childObjectList.add(new CustomChildObject().setChildText("Desynching"));
                    childObjectList.add(new CustomChildObject().setChildText("Wobbling"));
                }
                break;
                case "Jigglypuff": {
                    childObjectList.add(new CustomChildObject().setChildText("Rising pound"));
                }
                break;
                case "Young Link":
                case "Link": {
                    childObjectList.add(new CustomChildObject().setChildText("Boomerang " +
                            "superjump"));
                }
                break;
                case "Luigi": {
                    childObjectList.add(new CustomChildObject().setChildText("Vududash"));
                }
                break;
                case "Mario": {
                    childObjectList.add(new CustomChildObject().setChildText("Up-B walljump"));
                }
                break;
                case "Pichu":
                case "Pikachu":
                case "Princess Zelda": {
                    childObjectList.add(new CustomChildObject().setChildText(upbturn));
                }
                break;
                case "Mewtwo": {
                    childObjectList.add(new CustomChildObject().setChildText(djc));
                    childObjectList.add(new CustomChildObject().setChildText(upbturn));
                }
                break;
                case "Princess Peach": {
                    childObjectList.add(new CustomChildObject().setChildText(djc));
                    childObjectList.add(new CustomChildObject().setChildText("Float cancel"));
                    childObjectList.add(new CustomChildObject().setChildText("Frozen turnip " +
                            "glitch"));
                    childObjectList.add(new CustomChildObject().setChildText(psspike));
                }
                break;
                case "Ness": {
                    childObjectList.add(new CustomChildObject().setChildText(djc));
                    childObjectList.add(new CustomChildObject().setChildText("Yo-yo glitch"));
                }
                break;
                case "Marth":
                case "Roy": {
                    childObjectList.add(new CustomChildObject().setChildText(psspike));
                }
                break;
                case "Samus Aran": {
                    childObjectList.add(new CustomChildObject().setChildText("Extended & homing " +
                            "grapple"));
                    childObjectList.add(new CustomChildObject().setChildText("RI grapple cancel"));
                    childObjectList.add(new CustomChildObject().setChildText("SHFF missiles"));
                    childObjectList.add(new CustomChildObject().setChildText("Super wavedash & " +
                            "SDWD"));
                }
                break;
                case "Yoshi": {
                    childObjectList.add(new CustomChildObject().setChildText(djc));
                    childObjectList.add(new CustomChildObject().setChildText("DJ knockback armor"));
                    childObjectList.add(new CustomChildObject().setChildText("Edge canceled eggs"));
                    childObjectList.add(new CustomChildObject().setChildText("Parry"));
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

        if(Preferences.groupByCharacterEnabled(getActivity()) && mExpandableAdapter != null)
            mExpandableAdapter.setCanStart();
        else if(adapter != null)
            adapter.setCanStart(true);
    }
}
