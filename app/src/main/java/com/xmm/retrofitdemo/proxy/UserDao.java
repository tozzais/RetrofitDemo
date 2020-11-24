package com.xmm.retrofitdemo.proxy;

import com.xmm.retrofitdemo.proxy.IUserDao;

public class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
