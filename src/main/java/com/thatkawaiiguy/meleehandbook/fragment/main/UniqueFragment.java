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
import com.thatkawaiiguy.meleehandbook.utils.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.CustomChildObject;
import com.thatkawaiiguy.meleehandbook.other.CustomParentObject;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.utils.Preferences;
import com.thatkawaiiguy.meleehandbook.utils.XMLParser;

import java.util.ArrayList;

public class UniqueFragment extends Fragment {

    private String[] parentList;

    private ExpandableAdapter mExpandableAdapter;
    private TextAdapter adapter;

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

        if (Preferences.groupByCharacterEnabled(getActivity())) {
            mExpandableAdapter = new ExpandableAdapter(getActivity(), setUpData(), false);
            recyclerView.setAdapter(mExpandableAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        } else {
            adapter = new TextAdapter(getActivity(), true, R.xml.uniquetech);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
        }

        return rootView;
    }

    private ArrayList<ParentObject> setUpData() {
        ArrayList<ParentObject> parentObjectList = new ArrayList<>();
        for (String aParentList : parentList) {
            ArrayList<Object> childObjectList = new ArrayList<>();
            ArrayList<String> selected = getTechsForCharacter(aParentList);

            for (int r = 0; r < selected.size(); r++) {
                childObjectList.add(new CustomChildObject(selected.get(r)));
            }

            CustomParentObject customParentObject = new CustomParentObject();
            customParentObject.setChildObjectList(childObjectList);
            customParentObject.setParentText(aParentList);
            parentObjectList.add(customParentObject);
        }
        return parentObjectList;
    }

    private ArrayList<String> getTechsForCharacter(String character) {
        return XMLParser.getGroupedUniqueTech(getActivity().getResources(), character);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (Preferences.groupByCharacterEnabled(getActivity()) && mExpandableAdapter != null)
            mExpandableAdapter.setCanStart();
        else if (adapter != null)
            adapter.setCanStart(true);
    }
}
