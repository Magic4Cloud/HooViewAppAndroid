package com.hooview.app.net;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.hooview.app.model.ResponseEntity;
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
public class HttpUtils {

    private static Context mAppContext;

    //文件缓存20M
    private static final long CACHE_SIZE = 1024 * 1024 * 20;


    //存储call的map
    private static Map<String, Call> callHashMap = new ConcurrentHashMap<>();


    //私有化构造函数
    private HttpUtils() {
    }

    public static GithubUserInfo mInstance;

    public static GithubUserInfo getmInstance(Context context) {
        mAppContext = context.getApplicationContext();
        if (mInstance == null) {
            mInstance = SingletonHolder.sInstance;
        }
        return mInstance;
    }

    private static class SingletonHolder {

        private static final GithubUserInfo sInstance = createRetrofitHttp();

        public static GithubUserInfo createRetrofitHttp() {
            OkHttpClient client = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(8, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .addInterceptor(new CommonInterceptor())
                    .cache(new Cache(mAppContext.getCacheDir(), CACHE_SIZE))
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            GithubUserInfo mRetrofitHelper =
                    retrofit.create(GithubUserInfo.class);
            return mRetrofitHelper;
        }
    }


    /**
     * 异步请求
     *
     * @param tag         传入的tag
     * @param requestCall
     * @param callBack
     * @param <T>         返回的实体类
     */
    public static <T extends ResponseEntity>  void asynRequest(String tag, Call<T> requestCall, WrapCallBack<T> callBack) {
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
    private static void addCall(String tag, Call call) {
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
    public static void removeCall(String tag) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }
        if (callHashMap.get(tag) != null) {
            callHashMap.get(tag).cancel();
            callHashMap.remove(tag);
        }
    }
}
