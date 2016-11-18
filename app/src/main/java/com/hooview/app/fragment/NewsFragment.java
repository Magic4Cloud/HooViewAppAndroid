package com.hooview.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hooview.app.R;
import com.hooview.app.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yinyongliang on 16/11/15.
 * 首页专栏页面fragment
 */
public class NewsFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.mSwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
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
