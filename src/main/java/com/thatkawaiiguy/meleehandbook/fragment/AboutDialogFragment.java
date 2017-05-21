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
                .setNeutralButton(R.string.twitter, (DialogInterface dialog, int id) ->
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                                ("https://twitter.com/ThatKawaiiGuy"))))
                .setPositiveButton(R.string.close, (dialog, id) -> dialog.dismiss())
                .setView(message).create();
    }
}