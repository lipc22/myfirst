package page;

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-04**/

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisTest {
    public static void main(String[] args){
        Jedis jedis = new Jedis("localhost");
        jedis.auth("abc123456789");
        System.out.println("连接成功");
        jedis.set("key","www.runoob.com");
        System.out.println(jedis.get("key"));
        jedis.lpush("site-list","google");
        jedis.lpush("site-list","taobao");
        jedis.lpush("site-list","tencent");


        //获取存储数据并输出
        List<String> list = jedis.lrange("site-list",0,2);
        for(int i=0; i<list.size();i++){
            System.out.println(""+ list.get(i));
        }

        Set<String>  keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
            jedis.del(key);
        }

    }

}
