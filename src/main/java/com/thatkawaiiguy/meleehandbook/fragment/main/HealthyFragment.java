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

    private final String[] eyeList = {"Dozer", "Upstairs, downstairs", "King leer",
            "Sidewatcher", "Near, far"};
    private final String[] handList = {"Handshake", "Thumb sweep", "Cuticle check", "Wrist " +
            "circles", "Break at the wrist",
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

        postureText.setOnClickListener(v -> {
            if(canStart) {
                startActivity(new Intent(getActivity(),
                        HealthyActivity.class).putExtra("option", "Posture"));
                canStart = false;
            }
        });

        mentalText.setOnClickListener(v -> {
            if(canStart) {
                startActivity(new Intent(getActivity(),
                        HealthyActivity.class).putExtra("option", "Mental health"));
                canStart = false;
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
        for(int i = 0; i < 2; i++) {
            ArrayList<Object> childObjectList = new ArrayList<>();

            switch(i) {
                case 0: {
                    childObjectList.add(new CustomChildObject(eyeList[0]));
                    childObjectList.add(new CustomChildObject(eyeList[1]));
                    childObjectList.add(new CustomChildObject(eyeList[2]));
                    childObjectList.add(new CustomChildObject(eyeList[3]));
                    childObjectList.add(new CustomChildObject(eyeList[4]));
                }
                break;
                case 1: {
                    childObjectList.add(new CustomChildObject(handList[0]));
                    childObjectList.add(new CustomChildObject(handList[1]));
                    childObjectList.add(new CustomChildObject(handList[2]));
                    childObjectList.add(new CustomChildObject(handList[3]));
                    childObjectList.add(new CustomChildObject(handList[4]));
                    childObjectList.add(new CustomChildObject(handList[5]));
                    childObjectList.add(new CustomChildObject(handList[6]));
                    childObjectList.add(new CustomChildObject(handList[7]));
                    childObjectList.add(new CustomChildObject(handList[8]));
                    childObjectList.add(new CustomChildObject(handList[9]));
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