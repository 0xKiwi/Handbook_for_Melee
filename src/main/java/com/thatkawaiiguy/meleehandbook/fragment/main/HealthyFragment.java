/*
    This file is part of Melee Handbook.

    Melee Handbook is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Melee Handbook is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Melee Handbook.  If not, see <http://www.gnu.org/licenses/>
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
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.thatkawaiiguy.meleehandbook.activity.HealthyActivity;
import com.thatkawaiiguy.meleehandbook.other.CustomChildObject;
import com.thatkawaiiguy.meleehandbook.other.CustomParentObject;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.ExpandableAdapter;

import java.util.ArrayList;

public class HealthyFragment extends Fragment {
    private final String[] parentList = {"Eye stretches", "Hand stretches"};

    private final String[] eyeList = {"Dozer", "Upstairs, downstairs", "King leer", "Sidewatcher", "Near, far"};
    private final String[] handList = {"Handshake", "Thumb sweep", "Cuticle check", "Wrist circles", "Break at the wrist",
            "Stop (in the name of love)", "Underhanded stretch", "The block", "Thumb push",
            "Thumb pull"};

    private ExpandableAdapter mExpandableAdapter;

    private boolean canStart = true;

    public static HealthyFragment newInstance() {
        Bundle args = new Bundle();
        HealthyFragment fragment = new HealthyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.healthy_layout, container, false);

        final TextView postureText = (TextView) view.findViewById(R.id.postureText);
        TextView mentalText = (TextView) view.findViewById(R.id.mentalText);

        postureText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canStart) {
                    startActivity(new Intent(getActivity(),
                            HealthyActivity.class).putExtra("option", "Posture"));
                    canStart = false;
                }
            }
        });

        mentalText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canStart) {
                    startActivity(new Intent(getActivity(),
                            HealthyActivity.class).putExtra("option", "Mental health"));
                    canStart = false;
                }
            }
        });

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mExpandableAdapter = new ExpandableAdapter(getActivity(), setUpData(), true);
        mRecyclerView.setAdapter(mExpandableAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    private ArrayList<ParentObject> setUpData() {
        ArrayList<ParentObject> parentObjectList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<Object> childObjectList = new ArrayList<>();
            CustomChildObject customChildObject = new CustomChildObject();
            CustomChildObject customChildObject2 = new CustomChildObject();
            CustomChildObject customChildObject3 = new CustomChildObject();

            switch (i) {
                case 0: {
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    CustomChildObject customChildObject5 = new CustomChildObject();
                    customChildObject.setChildText(eyeList[0]);
                    customChildObject2.setChildText(eyeList[1]);
                    customChildObject3.setChildText(eyeList[2]);
                    customChildObject4.setChildText(eyeList[3]);
                    customChildObject5.setChildText(eyeList[4]);
                    childObjectList.add(customChildObject);
                    childObjectList.add(customChildObject2);
                    childObjectList.add(customChildObject3);
                    childObjectList.add(customChildObject4);
                    childObjectList.add(customChildObject5);
                }
                break;
                case 1: {
                    CustomChildObject customChildObject4 = new CustomChildObject();
                    CustomChildObject customChildObject5 = new CustomChildObject();
                    CustomChildObject customChildObject6 = new CustomChildObject();
                    CustomChildObject customChildObject7 = new CustomChildObject();
                    CustomChildObject customChildObject8 = new CustomChildObject();
                    CustomChildObject customChildObject9 = new CustomChildObject();
                    CustomChildObject customChildObject10 = new CustomChildObject();
                    customChildObject.setChildText(handList[0]);
                    customChildObject2.setChildText(handList[1]);
                    customChildObject3.setChildText(handList[2]);
                    customChildObject4.setChildText(handList[3]);
                    customChildObject5.setChildText(handList[4]);
                    customChildObject6.setChildText(handList[5]);
                    customChildObject7.setChildText(handList[6]);
                    customChildObject8.setChildText(handList[7]);
                    customChildObject9.setChildText(handList[8]);
                    customChildObject10.setChildText(handList[9]);
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
        mExpandableAdapter.setCanStart();
    }
}