
import java.lang.reflect.InvocationTargetException;


import java.lang.reflect.Method;


public class ReflectService {

    /**


     * 服务方法


     * @param name -- 姓名


     */



    public void sayHello(String name) {



        System.out.println("hello " + name);


    }


    /**


     * 测试入口


     * @param args


     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,

    InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException


    {


//通过反射创建对象
        Object  reflect = Class.forName("ReflectService").newInstance();

//获取方法-sayHello String
        //Method method = reflect.getClass().getMethod("sayHello",String.class);
        Method method = reflect.getClass().getMethod("sayHello", String.class);

//反射调用方法
        method.invoke(reflect,"lipengcheng");

    }

}