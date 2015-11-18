package com.thatkawaiiguy.meleehandbook.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.R;

public class AboutDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final TextView message = new TextView(getActivity());

        final SpannableString s = new SpannableString(getActivity().getText(
                R.string.about_text));
        Linkify.addLinks(s, Linkify.WEB_URLS);

        message.setText(s);
        message.setMovementMethod(LinkMovementMethod.getInstance());
        message.setPadding(16, 10, 16, 10);
        message.setTextSize(16);

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.action_about)
                .setNeutralButton(R.string.support,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse
                                        ("http://bit.ly/1NXCD2o"));
                                startActivity(browserIntent);
                            }
                        })
                .setNegativeButton(R.string.gplus,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse
                                        ("https://plus.google.com/+IvanMartinezxda"));
                                startActivity(browserIntent);
                            }
                        })
                .setPositiveButton(R.string.close,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        })
                .setView(message).create();
    }
}