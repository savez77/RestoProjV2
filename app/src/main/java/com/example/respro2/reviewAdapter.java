package com.example.respro2;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class reviewAdapter extends FragmentPagerAdapter {


    public reviewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new review1();
            case 1:
                return new review2();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}