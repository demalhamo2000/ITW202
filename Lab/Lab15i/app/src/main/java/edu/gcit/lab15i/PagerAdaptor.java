package edu.gcit.lab15i;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdaptor extends FragmentPagerAdapter {
    int mNumOfTabs;
    public PagerAdaptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        mNumOfTabs = behavior;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TypeFragment1();
            case 1:
                return new TypeFragment2();
            case 2:
                return new TypeFragment3();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


}
