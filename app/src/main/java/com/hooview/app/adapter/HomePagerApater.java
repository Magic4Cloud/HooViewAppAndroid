package com.hooview.app.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hooview.app.fragment.HomeFragment;
import com.hooview.app.fragment.MyFragment;
import com.hooview.app.fragment.NewsFragment;

/**
 * Created by yinyongliang on 16/11/15.
 */
public class HomePagerApater extends FragmentPagerAdapter{

    private static final int PAGE_INDEX = 3;

    private Context context;

    public HomePagerApater(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new HomeFragment();
        } else if(position == 1) {
            return new NewsFragment();
        } else {
            return new MyFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_INDEX;
    }
}
