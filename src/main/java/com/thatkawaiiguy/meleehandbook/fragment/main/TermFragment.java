package com.thatkawaiiguy.meleehandbook.fragment.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.adapter.TermAdapter;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;
import com.turingtechnologies.materialscrollbar.MaterialScrollBar;

public class TermFragment extends Fragment {
    protected TermAdapter mAdapter;

    protected RecyclerView mRecyclerView;

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected String[] terms = ArrayHelper.getTermArray();

    private enum LayoutManagerType {LINEAR_LAYOUT_MANAGER}

    public static TermFragment newInstance() {
        Bundle args = new Bundle();
        TermFragment fragment = new TermFragment();
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

        mAdapter = new TermAdapter(terms, getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.hasFixedSize();

        new MaterialScrollBar(getActivity(), mRecyclerView, true).setBarThickness(12).
                setAutoHide(false).setBarColour(ContextCompat.getColor(getActivity(), R.color.overscroll_color)).
        setHandleColour(ContextCompat.getColor(getActivity(), R.color.overscroll_color));
        return rootView;
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
