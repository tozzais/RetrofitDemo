package com.xmm.retrofitdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gc.netmodule.ServiceGenerator;
import com.gc.netmodule.response.BaseResult;
import com.xmm.retrofitdemo.bean.RequestLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 1：请求封装
 * 2：多url支持
 * 3：封装 成module
 * 4:配置和准备请求，响应，认证，日志记录和错误处理。
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);

    }

    public void login(View view) {
        Log.e("MainActivity","请求了");
//
        AccountService client = ServiceGenerator.createService(AccountService.class);
        RequestLogin requestLogin = new RequestLogin("admin", "123456q", true);
        Call<BaseResult<String>> login = client.login(requestLogin);
        login.enqueue(new Callback<BaseResult<String>>() {
            @Override
            public void onResponse(Call<BaseResult<String>> call, Response<BaseResult<String>> response) {
                BaseResult<String> body = response.body();
                String data = body.Data;
                textView.setText(data);

            }

            @Override
            public void onFailure(Call<BaseResult<String>> call, Throwable t) {
                textView.setText(t.getMessage());
                Log.e("MainActivity",t.getMessage());

            }
        });


    }
}