

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-09**/

public class testAB {
    public static void main(String[] args){
        testAB a1 = new testAB();
        testAB a2 = new B();
        B  b = new B();
        D  d = new D();
        System.out.println(a2.show(b));
        System.out.println(a1.show(d));

    }
    public String show(D obj){
        return ("A and D   "+this.getClass());
    }
    public String show(testAB obj){
        return ("A and A   "+getClass());
    }
}
class B extends testAB{
    public String show(B obj){
        return ("B and B   "+getClass());
    }
    public String show(testAB obj){
        return ("B and A   "+getClass());
    }
    public String showextend(){return  "aaaaaa";}
}
class C extends B{}
class D extends B{}
