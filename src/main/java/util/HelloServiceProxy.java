package util;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-11**/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler{

    private Object target;

    public Object bind(Object target,Class[] interfaces){
        this.target=target;
        return Proxy.newProxyInstance(
          target.getClass().getClassLoader(),target.getClass().getInterfaces(),this
        );
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("--------我是JDK动态代理--------");
        Object result = null;
        System.err.println("我准备说");
        result =method.invoke(target,args);
        System.err.println("我说过了");
        return result;
    }
}
