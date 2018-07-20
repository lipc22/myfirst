package page;

/*
 *@program:spider
 *:发送请求和响应
 *@author：Mr.Peng
 *@creatt:2018-07-03**/


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class RequestAndResponseTool {
    public static void main(String[]   args){
        String html = "<html><head><title>First blood</title></head>"
                +"<body><p id='hehe'>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);

        System.out.println(doc.getElementById("hehe").parents());

    }
}
