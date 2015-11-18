package com.thatkawaiiguy.meleehandbook.adapter.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.thatkawaiiguy.meleehandbook.fragment.FrameDataFragment;
import com.thatkawaiiguy.meleehandbook.fragment.InfoPageFragment;

public class CharacterFragmentAdapter extends FragmentPagerAdapter{

    private final String[] tabTitles = new String[]{"Info", "Frame Data"};

    public CharacterFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return InfoPageFragment.newInstance(0);
        else if (position == 1)
            return FrameDataFragment.newInstance();
        return InfoPageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
