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

import com.avocarrot.androidsdk.AvocarrotInstreamRecyclerView;
import com.avocarrot.androidsdk.AvocarrotUser;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.TextAdapter;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

public class TechFragment extends Fragment {

    private static final String TAG = "TechFragment";

    private final String[] techs = ArrayHelper.getTechArray();

    private TextAdapter adapter;

    public static TechFragment newInstance() {
        Bundle args = new Bundle();
        TechFragment fragment = new TechFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);
        rootView.setTag(TAG);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new TextAdapter(techs, getActivity(), true);

        AvocarrotUser.setGender(AvocarrotUser.Gender.MALE);

        if(!Preferences.hideAds(getActivity())) {
            AvocarrotInstreamRecyclerView avocarrotInstreamRecyclerView = new
                    AvocarrotInstreamRecyclerView(
                    adapter,
                    getActivity(),
                    getResources().getString(R.string.avocarrot_app_id),
                    getResources().getString(R.string.native_on_main_placement)
            );

            avocarrotInstreamRecyclerView.setLayout(
                    R.layout.native_layout,
                    R.id.avo_container,
                    R.id.avo_ad_headline,
                    R.id.avo_ad_description,
                    R.id.avo_ad_icon,
                    R.id.avo_ad_icon,
                    R.id.avo_ad_button,
                    R.id.avo_ad_choices
            );

            avocarrotInstreamRecyclerView.setSandbox(false);
            avocarrotInstreamRecyclerView.setFrequency(4, 17);
            avocarrotInstreamRecyclerView.setLogger(false, "ALL");

            recyclerView.setAdapter(avocarrotInstreamRecyclerView);
        } else {
            recyclerView.setAdapter(adapter);
        }

        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    @Override
    public void onResume() {
        adapter.setCanStart(true);
        super.onResume();
    }
}
