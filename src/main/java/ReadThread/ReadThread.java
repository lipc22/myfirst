package ReadThread;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-20**/


import java.io.*;

public class ReadThread extends Thread{
        public  File file;

        public ReadThread(File file){
            this.file=file;
        }
        public void  read(File file) throws IOException {
           // synchronized(file){

                FileInputStream fipt = new FileInputStream(file);
                BufferedInputStream bufinput = new BufferedInputStream(fipt);
                byte[] a = new byte[8000];
                byte[] sum = new byte[0];
                int len;

               //long time = System.currentTimeMillis();
                while ((len = bufinput.read(a)) != -1) {
                    if (len < a.length) {
                        byte[] b = new byte[len];
                        System.arraycopy(a, 0, b, 0, len);
                        sum = addBytes(sum, b);
                    } else {
                        sum = addBytes(sum, a);
                    }
             //   }
                String article= new String(sum, "GBK");
                    System.out.println(article);
                //System.out.println(Thread.currentThread().toString() + " " + (System.currentTimeMillis() - time));
            }
    }

    public static byte[]  addBytes(byte[]  data1,byte[]  data2){
        byte[]  data3 = new byte[data1.length+data2.length];
        System.arraycopy(data1,0,data3,0,data1.length);
        System.arraycopy(data2,0,data3,data1.length,data2.length);
        return data3;
    }

    @Override
    public void run() {
        super.run();

        try {
            this.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
