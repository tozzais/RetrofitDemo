package com.gc.netmodule;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * created by xmm on 2020/08/21.
 */
public class OkHttpUtils {

    private final static String RESPONSE_CACHE = "alex_http_cache";
    private final static long RESPONSE_CACHE_SIZE = 10 * 1024 * 1024;
    private final static long HTTP_CONNECT_TIMEOUT = 10;
    private final static long HTTP_READ_TIMEOUT = 30;
    private static OkHttpClient singleton;


    public static OkHttpClient getInstance() {
        if (singleton == null) {
            synchronized (OkHttpUtils.class) {
                if (singleton == null) {
                    //定义logging
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    singleton = new OkHttpClient.Builder()
                            .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
                            .addInterceptor(interceptor)
//                            .addInterceptor(new BaseUrlInterceptor())
//                            .addInterceptor(chain -> {
//                                Request.Builder builder = chain.request().newBuilder();
//                                Request request;
//                                String userToken = SimpleCache.getUserToken();
//                                if (!TextUtils.isEmpty(userToken)){
//                                    builder.addHeader("Authorization",
//                                            "Bearer "+ userToken);
//                                }
//                                request = builder.build();
//                                return chain.proceed(request);
//                            })
                            .build();
                }
            }
        }
        return singleton;
    }



}
