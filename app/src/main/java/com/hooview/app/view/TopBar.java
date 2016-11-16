package com.hooview.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by yinyongliang on 16/11/16.
 * 设计原因导致不需要用toolbar，这里自定义topbar满足需求
 */
public class TopBar extends FrameLayout {
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TopBar(Context context) {
        super(context);
        init();
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //常用的初始化操作,获取属性
    private void init() {

    }
}
