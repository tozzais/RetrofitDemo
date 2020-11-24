package com.xmm.retrofitdemo;

import com.gc.netmodule.response.BaseResult;
import com.xmm.retrofitdemo.bean.RequestLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountService {

    @POST(HttpUrl.login)
    Call<BaseResult<String>> login(@Body RequestLogin requestLogin);
}
