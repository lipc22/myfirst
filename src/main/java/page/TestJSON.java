package page;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-05**/

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJSON{
    public static void main(String[] args) {

        List<Map> list = new ArrayList<Map>();
        Map obj1 = new HashMap();
        Map obj2 = new HashMap();
        obj1.put("name2","zb");
        obj1.put("age2",30);
        obj1.put("birth2","2008-01-01");
        list.add(obj1);
        obj2.put("name3","zb1");
        obj2.put("age3",30);
        obj2.put("birth3","2018-01-01");
        list.add(obj2);
        JSONArray array = JSONArray.fromObject(list);
        System.out.println(array);
    }

}
