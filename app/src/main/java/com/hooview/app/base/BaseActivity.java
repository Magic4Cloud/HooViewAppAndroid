package com.hooview.app.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hooview.app.R;
import com.hooview.app.utils.PicassoUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yinyongliang on 16/11/14.
 * 底层基类
 */
public class BaseActivity extends AppCompatActivity {


    public String TAG = getClass().getSimpleName();

    private Toolbar mToolbar;

    /**
     * 子类重写次方法实现绑定注解，支持toolbar
     *
     * @param layoutResID 布局id
     * @param homeAsUp    是否返回到上个页面
     */
    public void setContentView(int layoutResID, boolean homeAsUp) {
        super.setContentView(layoutResID);
        initViews(homeAsUp);
        //设置转场动画
        overridePendingTransition(R.anim.pannel_right_in, R.anim.hold);
    }

    private void initViews(boolean homeAsUp) {
        //绑定注解
        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUp);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        overridePendingTransition(R.anim.hold, R.anim.pannel_left_out);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

}
