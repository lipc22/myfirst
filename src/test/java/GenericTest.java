

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-06**/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericTest{
    public static void main(String[] args) {

        BufferedReader in;
        BufferedWriter out;
        Pattern pattern = Pattern.compile("\\d{3}");
        String s;
        try {
            in  = new BufferedReader(new FileReader("d:/a.txt"));
            out = new BufferedWriter(new FileWriter("d:/a.txt"));
            out.write("af1234qwe567");
            out.flush();
            while((s= in.readLine()) !=null){
                Matcher matcher = pattern.matcher(s);
                while(matcher.find()){
                    System.out.println(matcher.group());

                    System.out.println("开始索引： "+matcher.start());
                    System.out.println("结束索引："+matcher.end());

                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("没找到文件");
            System.exit(-1);
        }catch (IOException e){
            System.out.println("读写失败");
            System.exit(-1);
        }



        double double1 = (double)3/5;
        int time = 0;
        System.out.println(double1);
        System.out.println(Math.acos(double1)/Math.PI*360);
        System.out.println("随机抽奖2000次");
        for(int i=0; i<2000;i++){
            if(Math.random()>0.70d)
                    time++;

        }
        System.out.println("中奖概率"+(double)time/2000);
        Box<String> a = new Box<String>("aabbbbb");
        Box<Integer> b = new Box<Integer>(123123);
        //getData(a);
        getData(b);
        System.out.println(a.getData());
        System.out.println(b.getData());
    }
    public static void getData(Box<?extends Number> date){
        System.out.println("data"+date.getData());
    }


}
class Box<T> {
    private T data;
    public Box(){

    }
    public Box (T t){
        this.data = t;
    }
    public T getData(){
        return data;

    }
}
