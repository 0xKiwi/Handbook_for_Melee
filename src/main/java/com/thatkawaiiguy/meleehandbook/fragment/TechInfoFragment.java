package com.thatkawaiiguy.meleehandbook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;

public class TechInfoFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    public static TechInfoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TechInfoFragment fragment = new TechInfoFragment();
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
        View view = inflater.inflate(R.layout.collapsing_text_layout, container, false);
        super.onCreate(savedInstanceState);
        Bundle mainData = getActivity().getIntent().getExtras();
        if (mainData == null)
            return view;

        String techPicked = mainData.getString("option");

        TextView techSelectedInfo = (TextView) view.findViewById(R.id.infoText);

        if(techPicked.equals("Directional Influence"))
            switch (getArguments().getInt(ARG_PAGE)) {
                case 2:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.diangles_info_text)));
                    break;
                case 0:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.di_info_text)));
                    break;
                case 1:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.sdi_info_text)));
                    break;
            }
        else if (techPicked.equals("Wall jump"))
            switch (getArguments().getInt(ARG_PAGE)) {
                case 0:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.walljump_info_text)));
                    break;
                case 1:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.ledgewalljump_info_text)));
                    break;
                case 2:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.reversewalljump_info_text)));
                    break;
            }
        else if(techPicked.equals("Super wavedash & SDWD"))
            switch (getArguments().getInt(ARG_PAGE)) {
                case 0:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.swd_info_text)));
                    break;
                case 1:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.sdwd_info_text)));
                    break;
            }
        else if(techPicked.equals("Extended & homing grapple"))
            switch (getArguments().getInt(ARG_PAGE)) {
                case 0:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.egrapple_info_text)));
                    break;
                case 1:
                    techSelectedInfo.setText(Html.fromHtml(getString(R.string.hominggrapple_info_text)));
                    break;
            }

        return view;
    }
}
