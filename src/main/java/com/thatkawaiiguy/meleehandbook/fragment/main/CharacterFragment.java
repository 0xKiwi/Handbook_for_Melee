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
import com.thatkawaiiguy.meleehandbook.activity.CharacterFrameActivity;
import com.thatkawaiiguy.meleehandbook.activity.CharacterActivity;
import com.thatkawaiiguy.meleehandbook.adapter.IconAdapter;
import com.thatkawaiiguy.meleehandbook.adapter.TextAdapter;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.ItemClickSupport;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.Preferences;

public class CharacterFragment extends Fragment {

    private boolean canStart = true;

    private String[] characters;

    public static CharacterFragment newInstance() {
        Bundle args = new Bundle();
        CharacterFragment fragment = new CharacterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);
        characters = ArrayHelper.getCharacterArray(getActivity(), true);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if(!Preferences.hideAds(getActivity())) {
            AvocarrotInstreamRecyclerView avocarrotInstreamRecyclerView = new
                    AvocarrotInstreamRecyclerView(
                    new IconAdapter(characters),
                    getActivity(),
                    getResources().getString(R.string.avocarrot_app_id), /* Avocarrot API Key */
                    getResources().getString(R.string.native_on_main_placement)/*Placement key*/
            );

            avocarrotInstreamRecyclerView.setSandbox(false);
            avocarrotInstreamRecyclerView.setFrequency(3, 10);
            avocarrotInstreamRecyclerView.setLogger(false, "ALL");

            recyclerView.setAdapter(avocarrotInstreamRecyclerView);

            ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(int position) {
                    if(((ConnectivityManager) getActivity().getSystemService(Context.
                            CONNECTIVITY_SERVICE)).getActiveNetworkInfo().isConnectedOrConnecting())
                        if(!TextAdapter.isPosAd(position, 3, 10))
                            if(canStart) {
                                position = TextAdapter.getProperPos(position, 3, 10);
                                Intent mIntent;
                                if(hasFrame(position))
                                    mIntent = new Intent(getActivity(), CharacterFrameActivity.class);
                                else
                                    mIntent = new Intent(getActivity(), CharacterActivity.class);
                                mIntent.putExtra("option", characters[position]);
                                startActivity(mIntent);
                                canStart = false;
                            }
                }
            });
        } else {
            recyclerView.setAdapter(new IconAdapter(characters));

            ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport
                    .OnItemClickListener() {
                @Override
                public void onItemClicked(int position) {
                    if(canStart) {
                        Intent mIntent;
                        if(hasFrame(position))
                            mIntent = new Intent(getActivity(), CharacterFrameActivity.class);
                        else
                            mIntent = new Intent(getActivity(), CharacterActivity.class);
                        mIntent.putExtra("option", characters[position]);
                        startActivity(mIntent);
                        canStart = false;
                    }
                }
            });
        }
        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    private boolean hasFrame(int position) {
        switch(characters[position]) {
            case "Captain Falcon":
                return true;
            case "Ganondorf":
                return true;
            case "Falco":
                return true;
            case "Fox":
                return true;
            case "Ice Climbers":
                return true;
            case "Jigglypuff":
                return true;
            case "Marth":
                return true;
            case "Pikachu":
                return true;
            case "Samus Aran":
                return true;
            case "Sheik":
                return true;
            case "Yoshi":
                return true;
            case "Dr. Mario":
                return true;
            case "Princess Peach":
                return true;
            case "Luigi":
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onResume() {
        canStart = true;
        super.onResume();
    }
}
