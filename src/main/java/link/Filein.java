package link;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-19**/

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Date;

public class Filein{
    File   file = null;
    FileReader  fr =null;
    FileWriter  fw = null;
    BufferedReader  bfr = null;
    BufferedWriter  bfw =null;

    public static void main(String[]  ss) throws IOException {




    }
    @Before
   public void    fileCreate() throws IOException {
        file  =new File("E:/太监武帝.txt");
        if(!file.exists()){
            file.createNewFile();
        }else {}


    }
    @Test
    public void    FileWriterTest() throws IOException {

//       fr = new FileReader(file);
        fw = new FileWriter(file);
        fw.write("你好 你好 我好 大家好才是真的好a 广州好迪");
        fw.write("\r\n");
        fw.write("会是第二行吗");
        fw.flush();
        fw.close();
    }
    @Test
    public void  FileInputStreamTest() throws IOException {
        FileInputStream   fipt= new FileInputStream(file);
        BufferedInputStream  bufinput = new BufferedInputStream(fipt);
        byte[] a =new byte[8000];
        byte[] sum =new byte[0];
        int len;

        long  time = System.currentTimeMillis();
        while((len=bufinput.read(a))!=-1) {
            if(len<a.length ){
                byte[] b = new byte[len];
                System.arraycopy(a,0,b,0,len);
                sum = addBytes(sum,b);
            }else {
                sum = addBytes(sum, a);
            }
        }
        System.out.println((new String(sum,"GBK")));
        System.out.println(System.currentTimeMillis()-time);
    }
    public static byte[]  addBytes(byte[]  data1,byte[]  data2){
        byte[]  data3 = new byte[data1.length+data2.length];
        System.arraycopy(data1,0,data3,0,data1.length);
        System.arraycopy(data2,0,data3,data1.length,data2.length);
        return data3;
    }
    public void  fileBufferedInputStream () throws FileNotFoundException {
        BufferedInputStream bufferedInputStream= new BufferedInputStream(new FileInputStream(file));

       // bufferedInputStream.
      //  while((n=bis.read()))
    }
}
