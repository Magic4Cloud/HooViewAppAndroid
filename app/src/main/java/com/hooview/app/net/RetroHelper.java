package com.hooview.app.net;

import android.content.Context;
import android.widget.Toast;

import com.hooview.app.bean.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:   yyl
 * Description: 网络请求的工具类
 * CreateDate:     2016/11/11
 */
public class RetroHelper {

    /*
    创建retrofit
     */
    static Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").
            addConverterFactory(GsonConverterFactory.create()).
            build();

    public static void name(final Context context) {
        GithubUserInfo info = retrofit.create(GithubUserInfo.class);

        //请求
        Call<User> userCall = info.getUserInfo("yinyongliang");
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(context, response.body().getName(), Toast.LENGTH_SHORT).show();

                return;
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}
