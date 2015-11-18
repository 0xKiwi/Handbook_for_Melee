package com.thatkawaiiguy.meleehandbook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;
import com.thatkawaiiguy.meleehandbook.other.ArrayHelper;

public class InfoPageFragment extends Fragment {

    private static final String ARG_PAGE = "ARG_PAGE";

    public static InfoPageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        InfoPageFragment fragment = new InfoPageFragment();
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

        String characterPicked = mainData.getString("option");

        ((TextView)view.findViewById(R.id.infoText)).setText(Html
                .fromHtml(ArrayHelper.getInfoString(characterPicked, getActivity())));

        ImageView characterImage = (ImageView) getActivity().findViewById(R.id.infoImage);

        assert characterPicked != null;
        assert characterPicked != null;
        switch (characterPicked) {
            case "Captain Falcon":
                characterImage.setImageResource(R.drawable.falcon);
                break;
            case "Ganondorf":
                characterImage.setImageResource(R.drawable.ganondorf);
                break;
            case "Falco":
                characterImage.setImageResource(R.drawable.falco);
                break;
            case "Fox":
                characterImage.setImageResource(R.drawable.fox);
                break;
            case "Sheik":
                characterImage.setImageResource(R.drawable.sheik);
                break;
            case "Marth":
                characterImage.setImageResource(R.drawable.marth);
                break;
            case "Ice Climbers":
                characterImage.setImageResource(R.drawable.iceclimbers);
                break;
            case "Jigglypuff":
                characterImage.setImageResource(R.drawable.jiggs);
                break;
            case "Pikachu":
                characterImage.setImageResource(R.drawable.pikachu);
                break;
            case "Samus Aran":
                characterImage.setImageResource(R.drawable.samus);
                break;
            case "Yoshi":
                characterImage.setImageResource(R.drawable.yoshi);
                break;
            case "Dr. Mario":
                characterImage.setImageResource(R.drawable.drmario);
                break;
        }
        return view;
    }
}
