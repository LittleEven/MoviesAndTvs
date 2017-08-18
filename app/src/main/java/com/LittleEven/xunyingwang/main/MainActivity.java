package com.LittleEven.xunyingwang.main;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.LittleEven.xunyingwang.base.BaseActivity;
import com.LittleEven.xunyingwang.base.BaseFragment;
import com.LittleEven.xunyingwang.commune.CommuneFragment;
import com.LittleEven.xunyingwang.home.HomeFragment;
import com.LittleEven.xunyingwang.movie.MovieFragment;
import com.LittleEven.xunyingwang.rank.RankFragment;
import com.LittleEven.xunyingwang.tv.TvFragment;
import com.brioal.bottomtab.entity.TabEntity;
import com.brioal.bottomtab.interfaces.OnTabSelectedListener;
import com.brioal.bottomtab.view.BottomLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(com.LittleEven.xunyingwang.R.id.main_bottomTabLayout)
    BottomLayout mTabLayout;
    private List<TabEntity> mTabEntities = new ArrayList<>();

    private BaseFragment mCurrentFragment;
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.LittleEven.xunyingwang.R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        //TabLayout设置
        mTabLayout.setList(mTabEntities);
        mTabLayout.setColorNormal(Color.BLACK);
        mTabLayout.setExCircleColor(getResources().getColor(com.LittleEven.xunyingwang.R.color.colorPrimaryTrans));
        mTabLayout.setInCircleColor(getResources().getColor(com.LittleEven.xunyingwang.R.color.colorPrimary));
        mTabLayout.setColorSelect(Color.WHITE);
        mTabLayout.setSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int i) {
                changeFragment(i);
            }
        });
        //显示首页
        changeFragment(0);
    }

    /**
     * 切换Fragment
     *
     * @param index
     */
    private void changeFragment(int index) {
        BaseFragment fragment = null;
        switch (index) {
            case 0:
                fragment = HomeFragment.getInstance();
                break;
            case 1:
                fragment = MovieFragment.getInstance();
                break;
            case 2:
                fragment = TvFragment.getInstance();
                break;
            case 3:
                fragment = CommuneFragment.getInstance();
                break;
            case 4:
                fragment = RankFragment.getInstance();
                break;
            default:
                fragment = HomeFragment.getInstance();
                break;
        }
        if (mCurrentFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(mCurrentFragment).commit();
        }
        if (fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().show(fragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().add(com.LittleEven.xunyingwang.R.id.main_container, fragment).commit();
        }
        mCurrentFragment = fragment;
    }

    private void initData() {
        mTabEntities.clear();
        mTabEntities.add(new TabEntity(com.LittleEven.xunyingwang.R.mipmap.ic_icon_home, "首页"));
        mTabEntities.add(new TabEntity(com.LittleEven.xunyingwang.R.mipmap.ic_icon_movie, "电影"));
        mTabEntities.add(new TabEntity(com.LittleEven.xunyingwang.R.mipmap.ic_icon_tv, "电视剧"));
        mTabEntities.add(new TabEntity(com.LittleEven.xunyingwang.R.mipmap.ic_icon_contract, "交流圈"));
        mTabEntities.add(new TabEntity(com.LittleEven.xunyingwang.R.mipmap.ic_icon_rank, "排行榜"));
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("是否退出当前应用?")
                .setCancelable(true)
                .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("不退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
}
