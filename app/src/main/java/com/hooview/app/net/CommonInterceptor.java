package com.hooview.app.net;

import com.hooview.app.application.MyApplication;
import com.hooview.app.utils.LogUtil;
import com.hooview.app.utils.NetworkUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yinyongliang on 16/11/17.
 * OKHTTP的拦截器，实现缓存功能
 * 无网络时加载缓存，有网络时加载最新数据
 */
public class CommonInterceptor implements Interceptor {

    /**
     * 设置缓存
     *
     * @param chain 请求链
     * @return
     * @throws IOException
     */
    public Response intercept(Chain chain) throws IOException {

        //request拦截
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        //网络是否可用
        if (!NetworkUtil.isNetworkAvailable(MyApplication.getAppContext())) {
            builder.cacheControl(CacheControl.FORCE_CACHE).build();
            LogUtil.i("network not work");
        } else {
            builder.cacheControl(CacheControl.FORCE_NETWORK).build();
        }

        Response response = chain.proceed(request);

        if (!NetworkUtil.isNetworkAvailable(MyApplication.getAppContext())) {
            int maxAge = 0 * 60; // 有网络时 设置缓存超时时间0个小时
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 3; // 无网络时，设置超时为3天
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }

        return response;
    }
}
