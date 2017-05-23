package com.example.alexis.proyecto.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by anahisalgado on 20/04/16.
 */
public class PageAdapterDiaRutina extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public PageAdapterDiaRutina(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
