package com.hooview.app.net;

import android.content.Context;

import com.hooview.app.model.ResponseEntity;
import com.hooview.app.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:   yyl
 * Description: 网络请求的工具类
 * CreateDate:     2016/11/11
 */
public class RetroHelper {

    private Context context;


    public void name(final Context context) {

        this.context = context;

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        GithubUserInfo info = retrofit.create(GithubUserInfo.class);

        //请求
        Call<User> userCall = info.getUserInfo("yinyongliang");


    }

    private void get() {
        HttpUtils.asynRequest("tag", HttpUtils.getmInstance(context).getUserInfo("yyl"), new WrapCallBack<User>() {
            @Override
            public void onSuccees(User response) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
