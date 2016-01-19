package com.thatkawaiiguy.meleehandbook.adapter.fragment;

        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;

        import com.thatkawaiiguy.meleehandbook.fragment.TechInfoFragment;

public class TabFragmentAdapter extends FragmentPagerAdapter {
    private final String[] tabTitles;

    public TabFragmentAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        tabTitles = titles;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
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
