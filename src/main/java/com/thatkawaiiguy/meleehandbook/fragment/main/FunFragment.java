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
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avocarrot.androidsdk.AvocarrotInstreamRecyclerView;
import com.thatkawaiiguy.meleehandbook.activity.FunActivity;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.ItemClickSupport;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.TextAdapter;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

public class FunFragment extends Fragment {

    private static final String TAG = "TechFragment";

    private final String[] funs = ArrayHelper.getFunArray();

    private boolean canStart = true;

    private RecyclerView mRecyclerView;

    public static FunFragment newInstance() {
        Bundle args = new Bundle();
        FunFragment fragment = new FunFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        if(!Preferences.hideAds(getActivity())) {
            AvocarrotInstreamRecyclerView avocarrotInstreamRecyclerView = new
                    AvocarrotInstreamRecyclerView(
                    new TextAdapter(funs),
                    getActivity(),
                    getResources().getString(R.string.avocarrot_app_id), /* Avocarrot API Key */
                    getResources().getString(R.string.native_on_main_placement)/*Placement key*/
            );

            avocarrotInstreamRecyclerView.setSandbox(true);
            avocarrotInstreamRecyclerView.setFrequency(3, 9);
            avocarrotInstreamRecyclerView.setLogger(true, "ALL");

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(avocarrotInstreamRecyclerView);

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(int position) {
                    if(((ConnectivityManager) getActivity().getSystemService(Context.
                            CONNECTIVITY_SERVICE)).getActiveNetworkInfo().isConnectedOrConnecting())
                        if(!TextAdapter.isPosAd(position))
                            if(canStart) {
                                startActivity(new Intent(getActivity(), FunActivity.class).putExtra("option", funs[position]));
                                canStart = false;
                            }
                }
            });
            mRecyclerView.setHasFixedSize(true);
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(new TextAdapter(funs));

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(int position) {
                    if(canStart) {
                        startActivity(new Intent(getActivity(), FunActivity.class).putExtra("option", funs[position]));
                        canStart = false;
                    }
                }
            });

            mRecyclerView.setHasFixedSize(true);
        }

        return rootView;
    }

    @Override
    public void onResume() {
        canStart = true;
        super.onResume();
    }
}
