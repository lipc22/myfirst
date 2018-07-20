

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-05**/


import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Test1{
    private RedisUtil redisUtil = new RedisUtil();

@Test
    public void testStr(){
        Jedis jedis = redisUtil.getJedis();
        jedis.set("id","15");
        String id = jedis.get("id");
        System.out.println(id);
        jedis.close();
    }
    @Test
    public void testList(){
        Jedis jedis = redisUtil.getJedis();
        jedis.del("id");
        jedis.del("java Framework");
        System.out.println(jedis.lrange("java Framework",0,-1));
        jedis.lpush("java Framework","spring");
        jedis.lpush("java Framework","struts");
        jedis.lpush("java Framework","hibernate");
        System.out.println(jedis.lrange("java Framework",0,-1));
        System.out.println(jedis.lrange("java Framework",0,0));
        jedis.del("java Framework");
        jedis.rpush("java Framework","spring");
        jedis.rpush("java Framework","struts");
        jedis.rpush("java Framework","hibernate");
        System.out.println(jedis.lrange("java Framework",0,-1));
        jedis.close();
    }
    @Test
    public void testSet(){
        Jedis jedis = redisUtil.getJedis();
        jedis.flushAll();
        jedis.sadd("user1","liuling");
        jedis.sadd("user1","name2");
        jedis.sadd("user1","name3");
        jedis.sadd("user1","name4");
        jedis.sadd("user1","name5");
        System.out.println(jedis.smembers("user1"));
        System.out.println(jedis.srandmember("user1",2)); //随机返回一定数量元素 不指定数量参数则随机返回一个
        System.out.println(jedis.sismember("user1","name"));//是否存在某个元素
        System.out.println(jedis.scard("user1"));//Redis SCARD命令用于获取存储在集合中的元素的数量
        jedis.close();
    }
    @Test
    public void testOrder(){
        Jedis jedis = redisUtil.getJedis();
        jedis.del("a");
        jedis.rpush("a","6");
        jedis.lpush("a","1");
        jedis.lpush("a","7");
        jedis.lpush("a","4");
        System.out.println(jedis.lrange("a",0,-1));
        System.out.println(jedis.sort("a"));//输出排序，redis内的list顺序不变
        System.out.println(jedis.lrange("a",0,-1));
        jedis.close();
    }

}
