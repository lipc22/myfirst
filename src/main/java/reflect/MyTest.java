package reflect;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-20**/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyTest {
    public static void main(String[] args) {
        //创建目标类
        IDivisionService target = new DivisionServiceImpl();
        //创建代理对象
        IDivisionService agencyObj = (IDivisionService)BeanFactory.getAgencyObj(target);
        int consult = agencyObj.division(4, 0);
        System.out.println("两数相除商为--->"+consult);



    }
}