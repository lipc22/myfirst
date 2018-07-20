

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-10**/

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Dom4jTest{
    @Test
    public void readXMLDemo() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("F:\\project\\spider\\src\\main\\resources\\mapp\\test.xml"));
        Element node =document.getRootElement();

        listNodes(node);
    }
    /*
    * 遍历当前节点下所有子节点（元素）
    * @param node
    *
    * */
    public void listNodes(Element node){
        System.out.println("当前节点名称：" +node.getName());
        //获取当前节点所有属性节点
        List<Attribute> list = node.attributes();
        for(Attribute attr : list){
            System.out.println((attr.getText()+"-----"+attr.getName()
                +"------"+attr.getValue()));
        }
        if(!(node.getTextTrim()).equals("")){
            System.out.println("w文本内容：" + node.getText());
        }
        Iterator<Element> it = node.elementIterator();
        while(it.hasNext()){
            Element e =it.next();
            listNodes(e);
        }
    }

}
