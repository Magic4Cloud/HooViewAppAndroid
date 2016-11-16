package com.hooview.app.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hooview.app.R;
import com.hooview.app.adapter.HomePagerApater;
import com.hooview.app.base.BaseActivity;
import com.hooview.app.net.RetroHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页activity
 */
public class HomeActivity extends BaseActivity {

    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    @BindView(R.id.radio_home)
    RadioButton mRadioHome;
    @BindView(R.id.radio_consult)
    RadioButton mRadioConsult;
    @BindView(R.id.radio_me)
    RadioButton mRadioMine;
    @BindView(R.id.mRadioGroup)
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initViewPager();
        initListener();
    }

    //初始化ViewaPger的操作
    private void initViewPager() {
        HomePagerApater mHomePagerAdapter = new HomePagerApater(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mHomePagerAdapter);
        mViewPager.setOffscreenPageLimit(2);//设置缓存页数

        RetroHelper.name(this);
    }

    private void initListener() {
        mRadioGroup.check(R.id.radio_home);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_home) {
                    mViewPager.setCurrentItem(0,false);
                } else if (checkedId == R.id.radio_consult) {
                    mViewPager.setCurrentItem(1,false);
                } else {
                    mViewPager.setCurrentItem(2,false);
                }
                mRadioGroup.check(checkedId);
            }
        });
    }
}
