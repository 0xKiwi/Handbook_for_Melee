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

package com.thatkawaiiguy.meleehandbook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.utils.XMLParser;

public class TechInfoFragment extends Fragment {

    private static final String ARG_PAGE = "ARG_PAGE";

    public static TechInfoFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TechInfoFragment fragment = new TechInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collapsing_text_layout, container, false);
        super.onCreate(savedInstanceState);
        Bundle mainData = getActivity().getIntent().getExtras();
        if (mainData == null)
            return view;
        int id = mainData.getInt("xml");

        String techPicked = XMLParser.getDrawableFromTitle(id, mainData.getString("option"), getActivity());

        TextView techSelectedInfo = (TextView) view.findViewById(R.id.infoText);

        assert techPicked != null;
        switch(techPicked) {
            case "Directional Influence":
                switch(getArguments().getInt(ARG_PAGE)) {
                    case 0:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.di_info_text)));
                        break;
                    case 1:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.sdi_info_text)));
                        break;
                    case 2:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.dsdi_info_text)));
                        break;
                    case 3:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string
                                .diangles_info_text)));
                        break;
                }
                break;
            case "Wall jumping":
                switch(getArguments().getInt(ARG_PAGE)) {
                    case 0:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string
                                .walljump_info_text)));
                        break;
                    case 1:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string
                                .ledgewalljump_info_text)));
                        break;
                    case 2:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string
                                .reversewalljump_info_text)));
                        break;
                }
                break;
            case "Super wavedash & SDWD":
                switch(getArguments().getInt(ARG_PAGE)) {
                    case 0:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.swd_info_text)));
                        break;
                    case 1:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.sdwd_info_text)));
                        break;
                }
                break;
            case "Extended & homing grapple":
                switch(getArguments().getInt(ARG_PAGE)) {
                    case 0:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.egrapple_info_text)));
                        break;
                    case 1:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.hominggrapple_info_text)));
                        break;
                }
                break;
            case "Shield dropping":
                switch(getArguments().getInt(ARG_PAGE)) {
                    case 0:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.shielddrop_info_text)));
                        break;
                    case 1:
                        techSelectedInfo.setText(Html.fromHtml(getString(R.string.shaidrop_info_text)));
                        break;
                }
                break;
        }

        techSelectedInfo.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}
