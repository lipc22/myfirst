

/*
 *@program:spider
 *:
 *@author：Mr.Peng
 *@creatt:2018-07-05**/

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil{
    private String address = "127.0.0.1";
    private int    port    = 6379;
    private String password= "abc123456789";
    private int  timeOut = 10000;
    private int maxTotal =1024;
    private int maxIdle =200;
    private int maxWait =1000;
    private boolean testOnBorrow = true;
    private JedisPool jedisPool =null;

    public  RedisUtil(){
        try{
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMaxWaitMillis(maxWait);
            config.setTestOnBorrow(testOnBorrow);
            jedisPool = new JedisPool(config,address,port,timeOut,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Jedis getJedis(){
        if(jedisPool!=null){
            return jedisPool.getResource();
        }
        return null;
    }

}
