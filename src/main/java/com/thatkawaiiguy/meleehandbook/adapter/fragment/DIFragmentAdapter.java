package com.thatkawaiiguy.meleehandbook.adapter.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.thatkawaiiguy.meleehandbook.fragment.TechInfoFragment;

/**
 * Created by thatkawaiiguy on 9/17/15.
 */
public class DIFragmentAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Directional Influence", "Smash DI", "DI Angles"};

    public DIFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return TechInfoFragment.newInstance(0);
        else if (position == 1)
            return TechInfoFragment.newInstance(1);
        else if (position == 2)
            return TechInfoFragment.newInstance(2);
        return TechInfoFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
