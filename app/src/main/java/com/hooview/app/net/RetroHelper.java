package com.hooview.app.net;

import android.content.Context;
import android.widget.Toast;

import com.hooview.app.model.User;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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





    public static void name(final Context context) {



        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        GithubUserInfo info = retrofit.create(GithubUserInfo.class);

        //请求
        Call<User> userCall = info.getUserInfo("yinyongliang");


//        AppRequest.getInstance(context).requestData(new WrapCallBack<ResponseEntity>() {
//            @Override
//            public void onSuccees(ResponseEntity response) {
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        },AppRequest.getInstance(context).create(ApiConstants.class).getUsers("user"));
    }


}
