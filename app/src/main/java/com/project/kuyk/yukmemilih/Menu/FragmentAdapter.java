package com.project.kuyk.yukmemilih.Menu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.project.kuyk.yukmemilih.Menu.PilpresFragment;
import com.project.kuyk.yukmemilih.Menu.PilgubFragment;
import com.project.kuyk.yukmemilih.Menu.PilbupFragment;
/**
 * Created by a_pri on 11/18/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter{
    String[] judul = new String[]{"Pilpres", "Pilgub", "Pilbup"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = new PilpresFragment();
                break;
            case 1 :
                fragment = new PilgubFragment();
                break;
            case 2 :
                fragment = new PilbupFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return judul.length;
    }

    public CharSequence getPageTitle(int position){
        return judul[position];
    }
}
