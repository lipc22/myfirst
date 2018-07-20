package reflect;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-20**/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    public static Object getAgencyObj(final Object target){

        Object agencyObj = null;

        agencyObj = Proxy.newProxyInstance(
                //获取目标对象类的加载器
                target.getClass().getClassLoader(),
                //获取对象接口的Class对象数组
                target.getClass().getInterfaces(),
                //一个内部类，用于创建监听对象
                new InvocationHandler() {
                    /**
                     * 通过反射机制获得实现类中方法的实例  method 及方法的参数 args 这取决于代理对象 agencyObj调用了那个方法。
                     */

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        int a = (Integer) args[0];
                        int b = (Integer) args[1];
                        //用于处理次要业务逻辑
                        if(b == 0){
                            System.out.println("除数不能为0");
                            return -1;
                        }
                        //用于处理次要业务逻辑
                        if(a == 0){
                            return 0;
                        }
                        //执行主业务逻辑
                        Object result = method.invoke(target, args);
                        return result;
                    }
                });

        return agencyObj;
    }

}