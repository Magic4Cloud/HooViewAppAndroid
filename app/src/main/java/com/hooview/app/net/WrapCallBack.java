package com.hooview.app.net;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yinyongliang on 16/11/17.
 * 封装回调
 */
public abstract class WrapCallBack<T extends ResponseEntity> implements Callback<T> {

    /**
     * 服务器返回数据的回调
     *
     * @param call
     * @param response 对response进行判断
     */
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() == 200) {
            //具体的bean返回
            onSuccees(response.body());
        } else {
            throw new RuntimeException("response error--->" + response.raw().message());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {//网络问题走该通道
        if (t instanceof SocketTimeoutException) {

        } else if (t instanceof ConnectException) {

        } else if (t instanceof RuntimeException) {

        }
    }

    public abstract void onSuccees(T response);

    public abstract void onFailure(Throwable t);
}
