package com.gc.netmodule;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = "http://gcgc.8800.org:8089/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();


    private static Retrofit retrofit =  builder.client( httpClient.build())
            .client(OkHttpUtils.getInstance())
            .build();;


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }





}
