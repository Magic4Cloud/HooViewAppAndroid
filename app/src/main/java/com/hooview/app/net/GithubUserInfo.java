package com.hooview.app.net;

import com.hooview.app.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Author:   yyl
 * Description:
 * CreateDate:     2016/11/11
 */
public interface GithubUserInfo {

    //get方式请求
    @GET("users/{users}")
    Call<User> getUserInfo(@Path("users") String user);

    //get方式请求，使用@Query注解
    @GET("users")
    Call<User> getUserInfo2(@Query("users") String user);

    //get方式请求，使用@QueryMap注解
    @GET("users")
    Call<User> getUserInfo(@QueryMap Map<String,String> map);
}
