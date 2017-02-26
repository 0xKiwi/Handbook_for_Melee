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

package com.thatkawaiiguy.meleehandbook.other;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.github.zagum.expandicon.ExpandIconView;
import com.thatkawaiiguy.meleehandbook.R;

public class CustomParentViewHolder extends ParentViewHolder {

    public final TextView dataText;
    public final ExpandIconView image;

    public CustomParentViewHolder(View itemView) {
        super(itemView);
        dataText = (TextView) itemView.findViewById(R.id.recycler_item_text_parent);
        image = (ExpandIconView) itemView.findViewById(R.id.expand);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        image.switchState();
    }
}