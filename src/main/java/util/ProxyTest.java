package util;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-11**/

public class ProxyTest{
    public static void main(String[] args){
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService interface1 = new HelloServiceImpl();
        System.out.println(HelloService.class);

        interface1 = (HelloService)proxy.bind(interface1,new Class[]{HelloService.class});

        interface1.sayHello("lipengcheng");
    }

}
