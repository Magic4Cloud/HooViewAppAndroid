package com.hooview.app.net;

import android.content.Context;
import android.text.TextUtils;

import com.hooview.app.utils.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yinyongliang on 16/11/17.
 * 封装的请求类
 */
public class AppRequest {

    private static AppRequest request = new AppRequest();

    private static Context mContext;

    private long cache_size = 1024 * 1024 * 20;

    private Retrofit retrofit;

    private static final int TIME_OUT = 7;

    private AppRequest() {
    }

    public static AppRequest getInstance(Context context) {
        mContext = context.getApplicationContext();//防止内存溢出
        return request;
    }

    //存储call的map
    private Map<String, Call> callHashMap = new ConcurrentHashMap<>();

    //初始化retrofit
    private void init() {
        OkHttpClient client = new OkHttpClient.Builder().
                addInterceptor(new CommonInterceptor()).
                connectTimeout(AppRequest.TIME_OUT, TimeUnit.SECONDS).
                readTimeout(AppRequest.TIME_OUT, TimeUnit.SECONDS).
                writeTimeout(AppRequest.TIME_OUT, TimeUnit.SECONDS).
                cache(new Cache(mContext.getCacheDir(), cache_size)).
                build();

        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                client(client).
                build();

    }

    //T 为api接口
    public <T> T create(Class<T> tClass) {
        return retrofit.create(tClass);
    }

    /**
     * 异步请求
     *
     * @param tag         传入的tag
     * @param requestCall
     * @param callBack
     * @param <T>         返回的实体类
     */
    public <T extends ResponseEntity> void asynRequest(String tag, Call<T> requestCall, WrapCallBack<T> callBack) {
        if (callBack == null) {
            throw new IllegalArgumentException("not set listener");
        }
        try {
            Call<T> call;
            if (requestCall.isExecuted()) {
                call = requestCall.clone();
            } else {
                call = requestCall;
            }
            addCall(tag, call);
            call.enqueue(callBack);
        } finally {
            removeCall(tag);
        }
    }

    /**
     * 添加call
     *
     * @param tag
     * @param call
     */
    private void addCall(String tag, Call call) {
        if (tag != null) {
            if (callHashMap.get(tag) == null) {
                callHashMap.put(tag, call);
            }
        }
    }

    /**
     * 移除call
     *
     * @param tag tag是call在map的唯一标识
     */
    public void removeCall(String tag) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }
        if (callHashMap.get(tag) != null) {
            callHashMap.get(tag).cancel();
            callHashMap.remove(tag);
        }
    }
}
