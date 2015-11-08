package com.thatkawaiiguy.meleehandbook.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;

public class FrameInfoDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final TextView message = new TextView(getActivity());

        final SpannableString s = new SpannableString(getActivity().getText(
                R.string.info_text));
        Linkify.addLinks(s, Linkify.WEB_URLS);

        message.setText(s);
        message.setMovementMethod(LinkMovementMethod.getInstance());
        message.setPadding(20, 10, 20, 10);
        message.setTextSize(18);

        return new AlertDialog.Builder(getActivity())
                .setTitle("Frame Data info")
                .setNegativeButton(R.string.close,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        })
                .setView(message).create();
    }
}