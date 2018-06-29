package com.fadila.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 2017-08-31.
 */

public class FixedTabsPagerAdapter extends FragmentPagerAdapter {

    public FixedTabsPagerAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) { //kelas masing-masing fragment
        switch(position) {
            case 0:
                return new WawelFragment();
            case 1:
                return new MariackiFragment();
            case 2:
                return new MuseumFragment();
            case 3:
                return new MoundFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) { //nilai yang berada pada tiap fragment
        switch(position) {
            case 0:
                return "Taman Nasional";
            case 1:
                return "Gunung Krakatau";
            case 2:
                return "Makanan Khas";
            case 3:
                return "Kain Tapis";
            default:
                return null;
        }
    }
}
