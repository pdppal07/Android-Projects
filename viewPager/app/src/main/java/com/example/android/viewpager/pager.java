package com.example.android.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class pager extends FragmentPagerAdapter {

    List<Fragment> fragments;
    public pager(FragmentManager fm){
        super(fm);
        fragments =new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public  void addFragment(Fragment f){
        fragments.add(f);
    }
}
