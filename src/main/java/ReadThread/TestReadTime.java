package ReadThread;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-20**/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestReadTime{

    private static Thread[] th = new Thread[100];
    private static int i=0;
    public static void main(String[] args) throws IOException, InterruptedException {
        String path ="E:\\txt";
        long time = System.currentTimeMillis();
        File file = new File(path);
        Directorty(file);
        time=th[2].join()-time;
        System.out.println((System.currentTimeMillis()-time));
    }
        //遍历文件夹
    public static void Directorty(File file) throws IOException {

        File[]  fs = file.listFiles();
        for (File f:fs){
            if (!f.isDirectory()){
                th[i] = new ReadThread(f);
                th[i].start();
                i=i+1;

            }
            else{
                Directorty(f);
            }


        }
    }

}
