package com.thatkawaiiguy.meleehandbook.fragment.main;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thatkawaiiguy.meleehandbook.activity.TechTabActivity;
import com.thatkawaiiguy.meleehandbook.adapter.TextAdapter;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.other.ItemClickSupport;
import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.activity.UniqueTechActivity;

public class UniqueFragment extends Fragment {

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

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TextAdapter adapter = new TextAdapter(uniqueTechs);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.hasFixedSize();

        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                if(canStart) {
                    Intent mIntent;
                    if(uniqueTechs[position].equals("Super wavedash & SDWD") ||
                            uniqueTechs[position].equals("Extended & homing grapple"))
                        mIntent = new Intent(getActivity(), TechTabActivity.class);
                    else
                        mIntent = new Intent(getActivity(), UniqueTechActivity.class);
                    mIntent.putExtra("option", uniqueTechs[position]);
                    startActivity(mIntent);
                    canStart = false;
                }
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
}
