package cn.redis.util;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolUtil {

    private static JedisPool pool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);     //最大连接数
        jedisPoolConfig.setMaxIdle(3);      //最大空闲数
        //   *******其他配置

        String host = "localhost";
        int port = 6379;
        pool = new JedisPool(jedisPoolConfig,host,port);
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }

    public static void close(Jedis jedis){
        jedis.close();
    }

    /**
     * 测试util类
     */
    @Test
    public void utilTest(){
        Jedis jedis = RedisPoolUtil.getJedis();
        System.out.println(jedis.ping());
        RedisPoolUtil.close(jedis);
    }

}
