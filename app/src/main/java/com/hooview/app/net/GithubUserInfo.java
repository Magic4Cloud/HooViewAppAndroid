package com.hooview.app.net;

import com.hooview.app.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Author:   yyl
 * Description:
 * CreateDate:     2016/11/11
 */
public interface GithubUserInfo {

    @GET("users/{users}")
    Call<User> getUserInfo(@Path("users") String user);
}
