package cn.redis.practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class RedisDemo {

    private Jedis jedis;

    @BeforeEach
    public void getJedis(){
        String host = "localhost";
        int port = 6379;
        jedis = new Jedis(host,port);
    }

    @AfterEach
    public void closeJedis(){
        //System.out.println(jedis.ping());
        jedis.close();

    }

    /**
     * 测试String
     */
    @Test
    public void jedisSting(){
        //jedis.set("key","value");
        System.out.println(jedis.get("key"));
    }


}
