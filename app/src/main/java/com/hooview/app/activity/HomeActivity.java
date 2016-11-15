package com.hooview.app.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

import com.hooview.app.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }
}
