package com.hooview.app.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yinyongliang on 16/11/18.
 * Api通用配置
 */
public interface ApiConstants<T> {

    @GET("users")
    Call<T> getUsers(@Query("users") String user);
}
