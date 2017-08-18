package com.LittleEven.xunyingwang.rank;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.LittleEven.xunyingwang.douban.DouBanFragment;
import com.LittleEven.xunyingwang.recenthot.RecentHotFragment;

public class RankViewPagerAdapter extends FragmentStatePagerAdapter {

    public RankViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return position == 0 ? DouBanFragment.getInstance() : RecentHotFragment.getInstance();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? "豆瓣TOP250" : "最近热门";
    }
}
