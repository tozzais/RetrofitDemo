package com.xmm.retrofitdemo;

import com.xmm.retrofitdemo.proxy.IUserDao;
import com.xmm.retrofitdemo.proxy.UserDao;
import com.xmm.retrofitdemo.proxy.dynamicproxy.ProxyFactory;
import com.xmm.retrofitdemo.proxy.staticproxy.UserDaoProxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.security.auth.Subject;

/**
 * 代理(Proxy)是一种设计模式,
 * 提供了对目标对象另外的访问方式;
 * 即通过代理对象访问目标对象.
 * 这样做的好处是:可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能.
 */
public class ExampleUnitTest {
    @Test
    public void dynamicProxy() {
        /**
         * 动态代理
         */
        IUserDao userDao = new UserDao();
        System.out.println(userDao.getClass());

        IUserDao  proxyInstance = (IUserDao) new ProxyFactory(userDao).getProxyInstance();

        System.out.println(proxyInstance.getClass());

        proxyInstance.save();


    }
    @Test
    public void staticProxy() {
        /**
         * 静态代理
         * 优点：可以做到在不修改目标对象的功能前提下,对目标功能扩展.
         * 缺点：1:代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.
         *      2:一旦接口增加方法,目标对象与代理对象都要维护.
         */
        UserDao userDao = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }




}