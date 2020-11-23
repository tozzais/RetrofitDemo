package com.xmm.retrofitdemo.bean;

public class RequestLogin {
    public String Account;
    public String Password;
    public boolean Remember;

    public RequestLogin(String account, String password, boolean remember) {
        Account = account;
        Password = password;
        Remember = remember;
    }
}
