package util;

/*
 *@program:spider
 *:查找字符串出现的次数
 *@author：Mr.Peng
 *@creatt:2018-07-11**/

import java.io.*;

public class CheckTxt{

    public int test(String path,String target) throws IOException {

        FileReader freader =new FileReader(path);//创建FileReader
        BufferedReader reader= new BufferedReader(freader);//创建缓冲字符流
        StringBuilder sb = new StringBuilder();//可变不安全字符串 单线程下操作频繁好用
        StringBuffer  sbuf = new StringBuffer();//可变线程安全字符串 用于多线程
        while(true){        //  全部读取到字符串
            String line =reader.readLine();
            if(line!=null){
                sb =sb.append(line);
                sbuf = sbuf.append(line);
            }else {
                break;
            }
        }

        StringBuilder result = new StringBuilder(sb.toString());
        //String result2 = result.replaceAll(target,"");//空格替代
       // return (result.length()-result2.length())/target.length();//通过长度计算次数
        int index = 0,count=0;
       // while((index=result.indexOf(target))!=-1){   //获取出现索引的位置
       //     System.out.println(index);
       //     result = result.delete(0,index+target.length());  //剪切掉出现字符串的前面部分
       //     count++;

      //  }
      //  return count;
        while((index = result.indexOf(target,index))!=-1){    //从指定索引开始检测
            System.out.println("index"+index);       //索引定义到出现目标字符串的后面
            index =index+target.length();
            count++;
        }
return count;
    }
    public static void main(String[]  args) throws IOException {
        CheckTxt t = new CheckTxt();
        System.out.println(t.test("F:\\project\\spider\\src\\main\\resources\\ee.txt","aa"));
    }

}
