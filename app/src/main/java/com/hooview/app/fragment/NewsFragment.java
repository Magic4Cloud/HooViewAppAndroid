package com.hooview.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hooview.app.R;
import com.hooview.app.base.BaseFragment;

/**
 * Created by yinyongliang on 16/11/15.
 * 首页专栏页面fragment
 */
public class NewsFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        return view;
    }

    @Override
    public void hideContentView() {

    }

    @Override
    public void showContentView() {

    }

    @Override
    public void onRetryClicked() {

    }
}
