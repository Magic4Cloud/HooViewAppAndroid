package com.hooview.app.base;

import android.view.View;
import android.widget.RelativeLayout;

import com.hooview.app.R;
import com.hooview.app.utils.PicassoUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yinyongliang on 16/11/15.
 * 网络加载state判断的基类
 */
public abstract class BaseStateActivity extends BaseActivity {


    @BindView(R.id.empty_layout)
    RelativeLayout mEmptyLayout;
    @BindView(R.id.error_layout)
    RelativeLayout mErrorLayout;
    @BindView(R.id.loading_layout)
    RelativeLayout mLoadingView;

    @Override
    protected void onResume() {
        super.onResume();
        PicassoUtil.resume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PicassoUtil.pause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PicassoUtil.cancel(this);
        overridePendingTransition(R.anim.hold, R.anim.pannel_left_out);
    }


    //正在加载的页面
    public void showLoadingView() {
        if(mLoadingView != null) {
            mLoadingView.setVisibility(View.VISIBLE);
        }
        //隐藏ContentView
        hideContentView();

        if(mEmptyLayout != null) {
            mEmptyLayout.setVisibility(View.INVISIBLE);
        }
        if(mErrorLayout != null) {
            mErrorLayout.setVisibility(View.GONE);
        }
    }

    //加载成功的页面
    public void showSuccessView(){
        if(mLoadingView != null) {
            mLoadingView.setVisibility(View.INVISIBLE);
        }
        //显示ContentView
        showContentView();

        if(mEmptyLayout != null) {
            mEmptyLayout.setVisibility(View.INVISIBLE);
        }
        if(mErrorLayout != null) {
            mErrorLayout.setVisibility(View.GONE);
        }
    }

    //加载为空的页面
    public void showEmptyView(){
        if(mLoadingView != null) {
            mLoadingView.setVisibility(View.INVISIBLE);
        }
        //隐藏ContentView
        hideContentView();

        if(mEmptyLayout != null) {
            mEmptyLayout.setVisibility(View.VISIBLE);
        }
        if(mErrorLayout != null) {
            mErrorLayout.setVisibility(View.GONE);
        }
    }

    //加载失败的页面
    public void showErrorView(){
        if(mLoadingView != null) {
            mLoadingView.setVisibility(View.INVISIBLE);
        }
        //隐藏ContentView
        hideContentView();

        if(mEmptyLayout != null) {
            mEmptyLayout.setVisibility(View.INVISIBLE);
        }
        if(mErrorLayout != null) {
            mErrorLayout.setVisibility(View.VISIBLE);
        }
    }

    public abstract void hideContentView();

    public abstract void showContentView();

    @OnClick(R.id.btn_reload)
    public abstract void onRetryClicked();
}
