package page;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-03**/

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class test1{
        public static void main(String[] args){
            System.out.println("------启动爬虫-------");



            try{
                Connection conn = Jsoup.connect("http://ogaoxiao.com/").timeout(2000);
                Document doc = conn.get();

                Elements urls = doc.getElementsByTag("a");
                System.out.println("程序进行中");
                for(Element element:urls){
                    String url = element.attr("abs:href");
                    System.out.println("正在下载的链接："+url);
                    test1.downpageimage(url);
                }


            }
            catch (Exception e){

                System.out.println("连接超时");
                System.exit(0);

            }
        }
        public static void downpageimage(String pageurl) throws IOException {
            try {
                Connection conn2 = Jsoup.connect(pageurl).timeout(5000);
                Document doc2 = conn2.get();

                Elements imgs = doc2.getElementsByTag("img");

                System.out.println("检测到下列图片URL");
                System.out.println("开始下载");
                for (Element element : imgs) {
                    String imgSrc = element.attr("abs:src");
                    System.out.println(imgSrc);
                    test1.downImage("e:/img/搞笑/", imgSrc);
                }
                System.out.println("下载完成");
            }catch (Exception e){
                System.out.println("此链接超时");
            }finally {

            }

        }
        public static void downImage(String filePath,String imgUrl){
            File dir =new  File(filePath);
            if(!dir.exists()){
                dir.mkdirs();
            }

               String filename = imgUrl.substring(imgUrl.lastIndexOf("/") + 1, imgUrl.length());

            try {
                String urlTail = URLEncoder.encode(filename, "UTF-8");
               imgUrl = imgUrl.substring(0, imgUrl.lastIndexOf("/") + 1) +
                       urlTail.replaceAll("\\+", "\\%20");
           }catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
            }
            File file = new File(filePath+ File.separator+filename);
            try{
                URL url = new URL(imgUrl);
                URLConnection connecion = url.openConnection();
                connecion.setConnectTimeout(10*1000);
                InputStream in = connecion.getInputStream();
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                byte[] buf = new byte[1024];
                int size;
                while(-1 !=(size=in.read(buf))){
                    out.write(buf,0,size);
                }
                out.close();
                in.close();
            }catch (Exception e){}

        }
}
