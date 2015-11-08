package com.thatkawaiiguy.meleehandbook.fragment.main;

/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thatkawaiiguy.meleehandbook.adapter.IconAdapter;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.ItemClickSupport;
import com.thatkawaiiguy.meleehandbook.activity.StageActivity;
import com.thatkawaiiguy.meleehandbook.R;

/**
 * Demonstrates the use of {@link RecyclerView} with a {@link LinearLayoutManager} and a
 * {@link GridLayoutManager}.
 */
public class StageFragment extends Fragment {

    protected boolean canStart = true;

    protected IconAdapter mAdapter;
    protected RecyclerView mRecyclerView;

    private enum LayoutManagerType {LINEAR_LAYOUT_MANAGER}

    protected LayoutManagerType mCurrentLayoutManagerType;

    private final String[] stages = ArrayHelper.getMapArray();

    public static StageFragment newInstance() {
        Bundle args = new Bundle();
        StageFragment fragment = new StageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        if (savedInstanceState != null)
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable("layoutManager");
        setRecyclerViewLayoutManager();

        mAdapter = new IconAdapter(stages);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.hasFixedSize();

        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if (canStart) {
                    Intent mIntent;
                    mIntent = new Intent(getActivity(), StageActivity.class);
                    mIntent.putExtra("option", stages[position]);
                    startActivity(mIntent);
                }
                canStart = false;
            }
        });
        mRecyclerView.setHasFixedSize(true);

        return rootView;
    }

    @Override
    public void onResume() {
        canStart = true;
        super.onResume();
    }

    public void setRecyclerViewLayoutManager() {
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.scrollToPosition(0);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putSerializable("layoutManager", mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
}
